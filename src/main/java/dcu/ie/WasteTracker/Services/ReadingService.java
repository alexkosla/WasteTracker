package dcu.ie.WasteTracker.Services;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import dcu.ie.WasteTracker.Entities.ReadingEntity;
import dcu.ie.WasteTracker.Entities.ReadingEventEntity;
import org.springframework.stereotype.Service;

import dcu.ie.WasteTracker.Models.ReadingModel;
import dcu.ie.WasteTracker.Repositories.ReadingRepository;

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

    public List<ReadingEventEntity> getDaily()
    {
        var readings = readingRepository.findAll();

        /*
        What follows is an attempted java recreation of the below LINQ code
        dates = readingList.Select(r -> r.getTimestamp().getDate()).Distinct();
        foreach(Date d in dates)
        {
	        finalDates.append(readingList.Where(r -> r.getTimeStamp().getDate() == d).SortBy(r ->.getTimestamp()).LastOrDefault());
        }
         */
        Comparator<ReadingModel> readingModelComparator = Comparator.comparing(d -> d.getTime(), Timestamp::compareTo);

        List<LocalDate> reading_dates = readings.stream().map(r -> r.getTime().toLocalDateTime().toLocalDate()).sorted(LocalDate::compareTo).distinct().toList();
        var sorted_readings = readings.stream().sorted(readingModelComparator).collect(Collectors.toList());

        List<ReadingModel> filteredReadingModels = new ArrayList<ReadingModel>();
        List<ReadingEventEntity> readingEventEntities = new ArrayList<ReadingEventEntity>();
        for (LocalDate day : reading_dates)
        {
            // CODE DOES NOT WORK HERE, YOU NEED A 'DATE' ISH TYPE THAT HAS A .getDate() (as in calendar date) method
            // it's checking for a time that exactly matches the date to the milliseconds which it won't be able to find
            var reading = sorted_readings.stream()
                    .filter(sr -> sr.getTime().toLocalDateTime().toLocalDate().toEpochDay() == day.toEpochDay())
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
}
