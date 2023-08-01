package dcu.ie.WasteTracker.Entities;

import dcu.ie.WasteTracker.Models.UserModel;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserEntity {
    private String Username;
    private LocalDateTime Timestamp;
    private boolean MondayPickup;
    private boolean TuesdayPickup;
    private boolean WednesdayPickup;
    private boolean ThursdayPickup;
    private boolean FridayPickup;
    private boolean SaturdayPickup;
    private boolean SundayPickup;

    public UserEntity() {}

    public UserEntity(UserModel userModel) {
        this.Timestamp = userModel.getTimestamp();
        this.Username = userModel.getUsername();
        this.MondayPickup = userModel.isMondayPickup();
        this.TuesdayPickup = userModel.isTuesdayPickup();
        this.WednesdayPickup = userModel.isWednesdayPickup();
        this.ThursdayPickup = userModel.isThursdayPickup();
        this.FridayPickup = userModel.isFridayPickup();
        this.SaturdayPickup = userModel.isSaturdayPickup();
        this.SundayPickup = userModel.isSundayPickup();
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public LocalDateTime getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        Timestamp = timestamp;
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
