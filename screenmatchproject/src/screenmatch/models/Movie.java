package screenmatch.models;

import screenmatch.calcs.Classify;

public class Movie extends Title implements Classify {
    private String director;

    public Movie(String name, int releaseYear){
        super(name, releaseYear);
    }

    public String getDirector(){
        return director;
    }

    public void setDirector(String director){
        this.director = director;
    }

    @Override
    public int getClassification() {
        return (int) getAverageScore() / 2;
    }

    @Override
    public String toString() {
    return "Movie: " + this.getName() + " (" + this.getYearOfRelease() + ")";
    }
}
