package screenmatch.models;

import screenmatch.calcs.Classify;

public class Episodes implements Classify {
    private int number;
    private String name;
    private Tvshow tvshow;
    private int totalViews;

    public int getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tvshow getTvshow() {
        return tvshow;
    }

    public void setTvshow(Tvshow tvshow) {
        this.tvshow = tvshow;
    }

    @Override
    public int getClassification() {
        if (totalViews > 100) {
            return 4;
        } else {
            return 2;
        }
    }
}
