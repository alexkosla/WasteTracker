package dcu.ie.WasteTracker.Entities;

public class UserEntity {
    private String Username;
    private boolean MondayPickup;
    private boolean TuesdayPickup;
    private boolean WednesdayPickup;
    private boolean ThursdayPickup;
    private boolean FridayPickup;
    private boolean SaturdayPickup;
    private boolean SundayPickup;

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
