package dcu.ie.WasteTracker.Entities;

import java.time.DayOfWeek;

public class DailyAverageEntity {
    private String MondayAvg;
    private String MondayChange;
    private String TuesdayAvg;
    private String TuesdayChange;
    private String WednesdayAvg;
    private String WednesdayChange;
    private String ThursdayAvg;
    private String ThursdayChange;
    private String FridayAvg;
    private String FridayChange;
    private String SaturdayAvg;
    private String SaturdayChange;
    private String SundayAvg;
    private String SundayChange;

    public DailyAverageEntity() {
    }

    public void setDayAvg(float averagePercent, DayOfWeek dayOfWeek)
    {
        switch(dayOfWeek.getValue())
        {
            case(1):
                this.setMondayAvg(averagePercent);
                break;
            case(2):
                this.setTuesdayAvg(averagePercent);
                break;
            case(3):
                this.setWednesdayAvg(averagePercent);
                break;
            case(4):
                this.setThursdayAvg(averagePercent);
                break;
            case(5):
                this.setFridayAvg(averagePercent);
                break;
            case(6):
                this.setSaturdayAvg(averagePercent);
                break;
            case(7):
                this.setSundayAvg(averagePercent);
                break;
        }
    }

    public void setMondayAvg(String mondayAvg) {
        MondayAvg = mondayAvg;
    }

    public void setTuesdayAvg(String tuesdayAvg) {
        TuesdayAvg = tuesdayAvg;
    }

    public void setWednesdayAvg(String wednesdayAvg) {
        WednesdayAvg = wednesdayAvg;
    }

    public void setThursdayAvg(String thursdayAvg) {
        ThursdayAvg = thursdayAvg;
    }

    public void setFridayAvg(String fridayAvg) {
        FridayAvg = fridayAvg;
    }

    public void setSaturdayAvg(String saturdayAvg) {
        SaturdayAvg = saturdayAvg;
    }

    public void setSundayAvg(String sundayAvg) {
        SundayAvg = sundayAvg;
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

    public String getMondayAvg() {
        return MondayAvg;
    }

    public void setMondayAvg(float mondayAvg) {
        MondayAvg = String.valueOf(mondayAvg);
    }

    public String getTuesdayAvg() {
        return TuesdayAvg;
    }

    public void setTuesdayAvg(float tuesdayAvg) {
        TuesdayAvg = String.valueOf(tuesdayAvg);
    }

    public String getWednesdayAvg() {
        return WednesdayAvg;
    }

    public void setWednesdayAvg(float wednesdayAvg) {
        WednesdayAvg = String.valueOf(wednesdayAvg);
    }

    public String getThursdayAvg() {
        return ThursdayAvg;
    }

    public void setThursdayAvg(float thursdayAvg) {
        ThursdayAvg = String.valueOf(thursdayAvg);
    }

    public String getFridayAvg() {
        return FridayAvg;
    }

    public void setFridayAvg(float fridayAvg) {
        FridayAvg = String.valueOf(fridayAvg);
    }

    public String getSaturdayAvg() {
        return SaturdayAvg;
    }

    public void setSaturdayAvg(float saturdayAvg) {
        SaturdayAvg = String.valueOf(saturdayAvg);
    }

    public String getSundayAvg() {
        return SundayAvg;
    }

    public void setSundayAvg(float sundayAvg) {
        SundayAvg = String.valueOf(sundayAvg);
    }
}
