package screenmatch.models;

public class Tvshow extends Title {
    private int seasons;
    private boolean active;
    private int episodesBySeason;
    private int minutesByEpisode;

    public Tvshow(String name, int releaseYear) {
        super(name, releaseYear);
    }

    public int getEpisodesBySeason() {
        return episodesBySeason;
    }

    public void setEpisodesBySeason(int episodesBySeason) {
        this.episodesBySeason = episodesBySeason;
    }

    public int getMinutesByEpisode() {
        return minutesByEpisode;
    }

    public void setMinutesByEpisode(int minutesBySeason) {
        this.minutesByEpisode = minutesBySeason;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public boolean getActive(){
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Tv Show: " + this.getName() + " (" + this.getYearOfRelease() + ")";
    }

    @Override
    public int getDurationInMinutes() {
        return (episodesBySeason * minutesByEpisode) * seasons;
    }
}
