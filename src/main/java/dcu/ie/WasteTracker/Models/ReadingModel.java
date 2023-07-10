package dcu.ie.WasteTracker.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reading")
public class ReadingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "readingId")
    private int readingId;
    private float Distance;
    private float Time;

    public ReadingModel() {
//        this.authority = "USER";
//        this.enabled = true;
    }

    public int getReadingId() {
        return readingId;
    }

    public void setReadingId(int readingId) {
        this.readingId = readingId;
    }

    public float getDistance() {
        return Distance;
    }

    public void setDistance(float distance) {
        Distance = distance;
    }

    public float getTime() {
        return Time;
    }

    public void setTime(float time) {
        Time = time;
    }
}