package dcu.ie.WasteTracker.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "reading")
public class ReadingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reading_Id", nullable = false)
    private int readingId;
    private float Distance;
    private Timestamp Time;

    public ReadingModel() {
//        this.authority = "USER";
//        this.enabled = true;
    }

    public int getReadingId() {
        return readingId;
    }

    public void setReadingId(int reading_Id) {
        this.readingId = reading_Id;
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