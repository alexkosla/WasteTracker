package dcu.ie.WasteTracker.Entities;

import java.sql.Timestamp;

public class ReadingEntity {
    private float Distance;
    private Timestamp Time;

    public ReadingEntity(float distance, Timestamp time) {
        Distance = distance;
        Time = time;
    }

    public float getDistance() {
        return Distance;
    }

    public void setDistance(float distance) {
        Distance = distance;
    }

    public Timestamp getTime() {
        return Time;
    }

    public void setTime(Timestamp time) {
        Time = time;
    }
}
