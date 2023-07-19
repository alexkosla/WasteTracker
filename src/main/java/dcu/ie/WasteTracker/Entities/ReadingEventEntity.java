package dcu.ie.WasteTracker.Entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ReadingEventEntity {
    private String title;
    private String start;
    private String end;
    private String color;

    public ReadingEventEntity(float distance, LocalDateTime timestamp) {
//        this.title = title;
        this.start = timestamp.toString();
        this.end = timestamp.toString();
        // hardcoded bin height of 20cm
        float percent = distanceToPercent(distance, 20f) * 100;
        this.title = String.format("%.0f%%", percent);

        if(percent >= 0.75f)
            this.color = "Red";
        else if(percent >= 0.5f)
            this.color = "Yellow";
        else
            this.color = "Green";

    }

    public float distanceToPercent(float distance, float height)
    {
        // when a bin is 100%
        float max = height - 3;
        float spaceLeft = height - distance;
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
