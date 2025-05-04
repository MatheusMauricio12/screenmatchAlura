package screenmatch.models;

import com.google.gson.annotations.SerializedName;
import screenmatch.models.exceptions.TitleConversionException;

public class Title implements Comparable<Title>{
    @SerializedName("Title")
    private String name;
    @SerializedName("Year")
    private int yearOfRelease;
    private boolean includedInPlan;
    private double scoreSoma;
    private int totalUsersScore;
    private int durationInMinutes;

    public Title(TitleOMDB titleOMDB){
        this.name = titleOMDB.title();
        if(titleOMDB.year().length() > 4){
            throw new TitleConversionException("Release year is invalid"
            + "it's more than 4 numbers"
            );
        }
        this.yearOfRelease = Integer.valueOf(titleOMDB.year());
        this.durationInMinutes = Integer.valueOf(titleOMDB.runtime().substring(0, 2));
    }

    public Title(String name, int releaseYear) {
        this.name = name;
        this.yearOfRelease = releaseYear;
    }

    public void showMovie(){
        System.out.format("""
                Name: %s
                Year of Relase: %d
                Duration: %d
                """, name, yearOfRelease, durationInMinutes);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setYearOfRelease(int year){
        this.yearOfRelease = year;
    }

    public int getYearOfRelease(){
        return this.yearOfRelease;
    }

    public void setDurationInMinutes(int duration){
        this.durationInMinutes = duration;
    }

    public int getDurationInMinutes(){
        return this.durationInMinutes;
    }

    public void setIncludedInPlan(boolean includedInPlan){
        this.includedInPlan = includedInPlan;
    }

    public boolean getIncludedInPlan(){
        return this.includedInPlan;
    }

    public void rate(double rate){
        scoreSoma += rate;
        totalUsersScore++;
    }

    public double getAverageScore(){
        return scoreSoma / totalUsersScore;
    }

    public int getTotalUsersScore(){
        return totalUsersScore;
    }

    @Override
    public int compareTo(Title otherTitle) {
        return this.getName().compareTo(otherTitle.getName());
    }

    @Override
    public String toString() {
        return "Title: " + name + ", Year: " +
                yearOfRelease + ", Runtime: " + durationInMinutes;
    }
}
