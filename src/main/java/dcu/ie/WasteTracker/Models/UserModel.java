package dcu.ie.WasteTracker.Models;

import dcu.ie.WasteTracker.Entities.UserEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "user")
public class UserModel {
    @Id
    @GeneratedValue
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "user_Id", nullable = false)
    private UUID UserId;
    private LocalDateTime Timestamp;
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "Username", nullable = false)
    private String Username;
    private boolean MondayPickup;
    private boolean TuesdayPickup;
    private boolean WednesdayPickup;
    private boolean ThursdayPickup;

    @JdbcTypeCode(SqlTypes.BOOLEAN)
    @Column(name="FridayPickup", nullable = false)
    private boolean FridayPickup;
    private boolean SaturdayPickup;
    private boolean SundayPickup;

    public UserModel()
    {

    }
    public UserModel(UserEntity userEntity) {
        this.UserId = UUID.randomUUID();
        this.Timestamp = userEntity.getTimestamp();
        this.Username = userEntity.getUsername();
        this.MondayPickup = userEntity.isMondayPickup();
        this.TuesdayPickup = userEntity.isTuesdayPickup();
        this.WednesdayPickup = userEntity.isWednesdayPickup();
        this.ThursdayPickup = userEntity.isThursdayPickup();
        this.FridayPickup = userEntity.isFridayPickup();
        this.SaturdayPickup = userEntity.isSaturdayPickup();
        this.SundayPickup = userEntity.isSundayPickup();
    }

    public UUID getUserId() {
        return UserId;
    }

    public void setUserId(UUID userId) {
        UserId = userId;
    }

    public LocalDateTime getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        Timestamp = timestamp;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public boolean isMondayPickup() {
        return MondayPickup;
    }

    public void setMondayPickup(boolean mondayPickup) {
        MondayPickup = mondayPickup;
    }

    public boolean isTuesdayPickup() {
        return TuesdayPickup;
    }

    public void setTuesdayPickup(boolean tuesdayPickup) {
        TuesdayPickup = tuesdayPickup;
    }

    public boolean isWednesdayPickup() {
        return WednesdayPickup;
    }

    public void setWednesdayPickup(boolean wednesdayPickup) {
        WednesdayPickup = wednesdayPickup;
    }

    public boolean isThursdayPickup() {
        return ThursdayPickup;
    }

    public void setThursdayPickup(boolean thursdayPickup) {
        ThursdayPickup = thursdayPickup;
    }

    public boolean isFridayPickup() {
        return FridayPickup;
    }

    public void setFridayPickup(boolean fridayPickup) {
        FridayPickup = fridayPickup;
    }

    public boolean isSaturdayPickup() {
        return SaturdayPickup;
    }

    public void setSaturdayPickup(boolean saturdayPickup) {
        SaturdayPickup = saturdayPickup;
    }

    public boolean isSundayPickup() {
        return SundayPickup;
    }

    public void setSundayPickup(boolean sundayPickup) {
        SundayPickup = sundayPickup;
    }

}
