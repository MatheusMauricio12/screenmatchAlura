package screenmatch.calcs;

import screenmatch.models.Title;

public class TimeCalculator {
    private int totalDuration = 0;

    public int getTotalDuration() {
        return totalDuration;
    }

    public void include(Title t){
        totalDuration += t.getDurationInMinutes();
    }
}
