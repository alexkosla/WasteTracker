package dcu.ie.WasteTracker.Entities;

import dcu.ie.WasteTracker.Models.UserModel;

import java.time.LocalDateTime;

// A schedule data transfer object that is returned to the front-end to display
// waste pickup days. Exists as a 'user' entity because it was originally intended
// to be extended to support having multiple users/logins/schedules on the application
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

    public boolean isTuesdayPickup() {
        return TuesdayPickup;
    }

    public boolean isWednesdayPickup() {
        return WednesdayPickup;
    }

    public boolean isThursdayPickup() {
        return ThursdayPickup;
    }

    public boolean isFridayPickup() {
        return FridayPickup;
    }

    public boolean isSaturdayPickup() {
        return SaturdayPickup;
    }

    public boolean isSundayPickup() {
        return SundayPickup;
    }

    public void setMondayPickup(boolean mondayPickup) {
        MondayPickup = mondayPickup;
    }

    public void setTuesdayPickup(boolean tuesdayPickup) {
        TuesdayPickup = tuesdayPickup;
    }

    public void setWednesdayPickup(boolean wednesdayPickup) {
        WednesdayPickup = wednesdayPickup;
    }

    public void setThursdayPickup(boolean thursdayPickup) {
        ThursdayPickup = thursdayPickup;
    }

    public void setFridayPickup(boolean fridayPickup) {
        FridayPickup = fridayPickup;
    }

    public void setSaturdayPickup(boolean saturdayPickup) {
        SaturdayPickup = saturdayPickup;
    }

    public void setSundayPickup(boolean sundayPickup) {
        SundayPickup = sundayPickup;
    }
}
