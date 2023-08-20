package dcu.ie.WasteTracker.Entities;

import java.time.DayOfWeek;

// data transfer object containing average daily changes in bin fullness
// returned to the front-end
public class DailyAverageEntity {
    private String MondayChange;
    private String TuesdayChange;
    private String WednesdayChange;
    private String ThursdayChange;
    private String FridayChange;
    private String SaturdayChange;
    private String SundayChange;

    public DailyAverageEntity() {
    }

    public String getMondayChange() {
        return MondayChange;
    }

    public void setMondayChange(float mondayChange) {
        MondayChange = String.valueOf(mondayChange);
    }

    public String getTuesdayChange() {
        return TuesdayChange;
    }

    public void setTuesdayChange(float tuesdayChange) {
        TuesdayChange = String.valueOf(tuesdayChange);
    }

    public String getWednesdayChange() {
        return WednesdayChange;
    }

    public void setWednesdayChange(float wednesdayChange) {
        WednesdayChange = String.valueOf(wednesdayChange);
    }

    public String getThursdayChange() {
        return ThursdayChange;
    }

    public void setThursdayChange(float thursdayChange) {
        ThursdayChange = String.valueOf(thursdayChange);
    }

    public String getFridayChange() {
        return FridayChange;
    }

    public void setFridayChange(float fridayChange) {
        FridayChange = String.valueOf(fridayChange);
    }

    public String getSaturdayChange() {
        return SaturdayChange;
    }

    public void setSaturdayChange(float saturdayChange) {
        SaturdayChange = String.valueOf(saturdayChange);
    }

    public String getSundayChange() {
        return SundayChange;
    }

    public void setSundayChange(float sundayChange) {
        SundayChange = String.valueOf(sundayChange);
    }

}
