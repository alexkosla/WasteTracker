package dcu.ie.WasteTracker.Models;

import dcu.ie.WasteTracker.Entities.ReadingEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "readingtest")
public class ReadingModel {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name="reading_Id", nullable = false)
    private UUID readingId;
    private float Distance;
    private LocalDateTime Time;

    public ReadingModel()
    {

    }

    public ReadingModel(float distance, LocalDateTime time)
    {
        this.Distance = distance;
        this.Time = time;
        this.readingId = UUID.randomUUID();
    }

    public ReadingModel(ReadingEntity readingEntity)
    {
        this.Distance = readingEntity.getDistance();
        this.Time = readingEntity.getTime();
        this.readingId = UUID.randomUUID();
    }

    public UUID getReadingId() {
        return readingId;
    }

    public void setReadingId(UUID reading_Id) {
        this.readingId = reading_Id;
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