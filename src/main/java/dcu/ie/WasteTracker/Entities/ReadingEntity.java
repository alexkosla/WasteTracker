package dcu.ie.WasteTracker.Entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

// data transfer object to parse incoming reading jsons from the RPI
public class ReadingEntity {
    private float Distance;
    private LocalDateTime Time;

    public ReadingEntity(float distance, LocalDateTime time) {
        Distance = distance;
        Time = time;
    }

    public float getDistance() {
        return Distance;
    }

    public void setDistance(float distance) {
        Distance = distance;
    }

    public LocalDateTime getTime() {
        return Time;
    }

    public void setTime(LocalDateTime time) {
        Time = time;
    }
}
