package dcu.ie.WasteTracker.Services;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import dcu.ie.WasteTracker.Entities.DailyAverageEntity;
import dcu.ie.WasteTracker.Entities.ReadingEntity;
import dcu.ie.WasteTracker.Entities.ReadingEventEntity;
import org.springframework.stereotype.Service;

import dcu.ie.WasteTracker.Models.ReadingModel;
import dcu.ie.WasteTracker.Repositories.ReadingRepository;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class ReadingService {
    private final ReadingRepository readingRepository;

    public ReadingService(ReadingRepository readingRepository)
    {
        this.readingRepository = readingRepository;
    }

    public List<ReadingModel> getAllReadings()
    {
        return readingRepository.findAll();
    }


    // getDaily: Gets all of the readings in the database, and filters them so only the last reading of
    // each day is returned, in a list of readings.
    public List<ReadingEventEntity> getDaily()
    {
        var readings = readingRepository.findAll();

        /*
        What follows is an attempted java recreation of the below LINQ (C#) code
        dates = readingList.Select(r -> r.getTimestamp().getDate()).Distinct();
        foreach(Date d in dates)
        {
	        finalDates.append(readingList.Where(r -> r.getTimeStamp().getDate() == d).SortBy(r ->.getTimestamp()).LastOrDefault());
        }
         */
        Comparator<ReadingModel> readingModelComparator = Comparator.comparing(d -> d.getTime(), LocalDateTime::compareTo);

        List<LocalDate> reading_dates = readings.stream().map(r -> r.getTime().toLocalDate()).sorted(LocalDate::compareTo).distinct().toList();
        var sorted_readings = readings.stream().sorted(readingModelComparator).collect(Collectors.toList());

        List<ReadingModel> filteredReadingModels = new ArrayList<ReadingModel>();
        List<ReadingEventEntity> readingEventEntities = new ArrayList<ReadingEventEntity>();
        for (LocalDate day : reading_dates)
        {
            // CODE DOES NOT WORK HERE, YOU NEED A 'DATE' ISH TYPE THAT HAS A .getDate() (as in calendar date) method
            // it's checking for a time that exactly matches the date to the milliseconds which it won't be able to find
            var reading = sorted_readings.stream()
                    .filter(sr -> sr.getTime().toLocalDate().toEpochDay() == day.toEpochDay())
                    .sorted(readingModelComparator)
                            .collect(Collectors.toList());

            // only add the last reading from each day
            filteredReadingModels.add(reading.get(reading.size() - 1));
        }

        for (ReadingModel readingModel : filteredReadingModels)
        {
            ReadingEventEntity entity = new ReadingEventEntity(readingModel.getDistance(), readingModel.getTime());
            readingEventEntities.add(entity);
        }

        return readingEventEntities;
    }

    public ReadingModel saveReading(ReadingEntity readingEntity)
    {
        ReadingModel readingModel = new ReadingModel(readingEntity);
        readingRepository.save(readingModel);
        return readingModel;
    }

    // getDailyChanges: Calculates the average increase in bin fullness for each day of the week.
    public DailyAverageEntity getDailyChanges()
    {
        List<ReadingEventEntity> dailyReadings = getDaily();
        DailyAverageEntity dailyAverageEntity = new DailyAverageEntity();

        // initialize delta variables for changes in fill % for each day of the week
        float monDelta, tuesDelta, wedDelta, thursDelta, friDelta, satDelta, sunDelta;
        monDelta = tuesDelta = wedDelta = thursDelta = friDelta = satDelta = sunDelta = 0f;

        // variables for the number of individual weekdays encountered
        int monCount, tuesCount, wedCount, thursCount, friCount, satCount, sunCount;
        monCount = tuesCount = wedCount = thursCount = friCount = satCount = sunCount = 0;

        // get all of the daily changes for each daily reading
        for(int readingDay = dailyReadings.size() - 1; readingDay > 0; readingDay--)
        {
            float oldPercent = dailyReadings.get(readingDay-1).getPercent();
            float newPercent = dailyReadings.get(readingDay).getPercent();
            LocalDateTime newDay = LocalDateTime.parse(dailyReadings.get(readingDay).getStart());
            LocalDateTime oldDay = LocalDateTime.parse(dailyReadings.get(readingDay-1).getStart());
            float delta = newPercent - oldPercent;

            // check if bin has been emptied and adjust the delta
            if (delta <= 0)
            {
                // if percent goes from 90% to 5%, it should be a 15% change
                delta = (100 - oldPercent) + newPercent;
            }

            // if the two daily readings aren't from adjacent days, then calculate an average change
            // note that this may not work if the bin has been emptied multiple times
            var newDayOfWeekVal =  newDay.getDayOfWeek().getValue();
            var left = newDayOfWeekVal - 1;
            var right = oldDay.getDayOfWeek().getValue();
            // use a mod on the old day because (1-1 =/= 7)
            long daysBetween = DAYS.between(oldDay, newDay);
            if (daysBetween > 1)
            {
                // note this is triggered on 7-24 looking back at 7-23
                // divide the change by the amount of days passed between the two readings
                var daysPast = oldDay.getDayOfWeek().compareTo(newDay.getDayOfWeek());
                delta = delta / daysBetween;
            }

            switch (newDay.getDayOfWeek().getValue())
            {
                case(1):
                    monDelta = monDelta + delta;
                    monCount++;
                    break;
                case(2):
                    tuesDelta = tuesDelta + delta;
                    tuesCount++;
                    break;
                case(3):
                    wedDelta = wedDelta + delta;
                    wedCount++;
                    break;
                case(4):
                    thursDelta = thursDelta + delta;
                    thursCount++;
                    break;
                case(5):
                    friDelta = friDelta + delta;
                    friCount++;
                    break;
                case(6):
                    satDelta = satDelta + delta;
                    satCount++;
                    break;
                case(7):
                    sunDelta = sunDelta + delta;
                    sunCount++;
                    break;
            }

        }

        // NEEDS TO DIVIDE BY NUMBER OF MONDAYS/TUESDAY/ETC. NOT BY TOTAL NUMBER OF DAYS
        dailyAverageEntity.setMondayChange(monDelta / monCount);
        dailyAverageEntity.setTuesdayChange(tuesDelta / tuesCount);
        dailyAverageEntity.setWednesdayChange(wedDelta / wedCount);
        dailyAverageEntity.setThursdayChange(thursDelta / thursCount);
        dailyAverageEntity.setFridayChange(friDelta / friCount);
        dailyAverageEntity.setSaturdayChange(satDelta / satCount);
        dailyAverageEntity.setSundayChange(sunDelta / sunCount);

        return dailyAverageEntity;
    }

    public String dayOfWeekAvg(List<ReadingModel> readingModels, int day)
    {
        float avgDistance = ((float) readingModels.stream()
                .filter(reading -> reading.getTime().getDayOfWeek().getValue() == day)
                .map(reading -> reading.getDistance())
                .mapToDouble(Float::doubleValue)
                .average()
                .orElse(0.0));

        return distanceToPercentString(avgDistance, 26.5f, 1.5f);
    }

    public String distanceToPercentString(float distance, float height, float sensorHeight)
    {
        // when a bin is 100%

        // according to tests, the bin is 26.5 cm tall
        // and the sensor is 25cm from the bottom of the bin
        float max = height - sensorHeight;
        // bin is 20cm tall
        // max is 17cm (amount of total space)
        // distance is 10cm
        double percent = ((max - distance) / max)*100;
        if(percent > 1)
            percent = 1;

        return String.format("%.1f%%", percent*100);
    }
}
