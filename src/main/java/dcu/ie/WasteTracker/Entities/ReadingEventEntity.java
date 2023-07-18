package dcu.ie.WasteTracker.Entities;

import java.sql.Timestamp;

public class ReadingEventEntity {
    private String title;
    private String start;
    private String end;
    private String color;

    public ReadingEventEntity(float distance, Timestamp timestamp) {
//        this.title = title;
        this.start = timestamp.toString();
        this.end = timestamp.toString();

        // really bad placeholder code, you'll need a separate method to convert distance into percent
        // but should it be in this class or in the service?
        if(distance <= 5.0)
        {
            this.title = "80%";
            this.color = "Red";
        } else if (distance <= 10.0) {
            this.title = "60%";
            this.color = "Yellow";
        } else {
            this.title = "30%";
            this.color = "Green";
        }
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
