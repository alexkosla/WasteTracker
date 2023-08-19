package dcu.ie.WasteTracker.Entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ReadingEventEntity {
    private String title;
    private String start;
    private String end;
    private String color;

    public ReadingEventEntity(float distance, LocalDateTime timestamp) {
        this.start = timestamp.toString();
        // end is exclusive of start (see event parsing docs for fullcalendar) so it needs to be AFTER start
        this.end = timestamp.plusMinutes(1).toString();
        // hardcoded to match the bin and sensor heights of my bin
        float percent = distanceToPercent(distance, 26.5f, 2f) * 100;
        // round percent to be a multiple of 5 to account for noise
        percent = 5*Math.round(percent/5);
        System.out.println("rounded percent to: "+percent);

        this.title = String.format("%.0f%%", percent);

        if(percent >= 75)
            this.color = "Red";
        else if(percent >= 50)
            this.color = "Orange";
        else
            this.color = "Green";

    }

    public float getPercent()
    {
        // remove % symbol so it can be parsed as a float
        return Float.valueOf(this.getTitle().replace("%", ""));
    }

    public float distanceToPercent(float distance, float height, float sensorHeight)
    {
        // when a bin is 100%

        // according to tests, the bin is 26.5 cm tall
        // and the sensor is 25cm from the bottom of the bin
        float max = height - sensorHeight;
        // bin is 20cm tall
        // max is 17cm (amount of total space)
        // distance is 10cm
        float percent = (max - distance) / max;
        if(percent > 1)
            percent = 1;

        return percent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
