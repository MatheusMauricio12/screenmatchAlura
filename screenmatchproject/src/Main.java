import screenmatch.calcs.RecomendationFilter;
import screenmatch.models.Episodes;
import screenmatch.models.Movie;
import screenmatch.calcs.TimeCalculator;
import screenmatch.models.Tvshow;

import java.util.ArrayList;

public class Main {
    public static void main(String[]args){
        Movie movieOne = new Movie("Avatar", 2009);
        movieOne.setDurationInMinutes(162);

        movieOne.showMovie();
        movieOne.rate(8);
        movieOne.rate(9);
        movieOne.rate(10);
        System.out.println("Total user's scores: " + movieOne.getTotalUsersScore());
        System.out.println("Average score: " + movieOne.getAverageScore());

        Tvshow supernatural = new Tvshow("Supernatural", 2005);
        supernatural.setSeasons(10);
        supernatural.setMinutesByEpisode(40);
        supernatural.setEpisodesBySeason(12);

        System.out.println("To watch " + supernatural.getName() + " entirely, you will have to spend: " + supernatural.getDurationInMinutes() + "minutes.");

        TimeCalculator calc = new TimeCalculator();

        calc.include(movieOne);
        calc.include(supernatural);

        System.out.println(calc.getTotalDuration());

        RecomendationFilter filter = new RecomendationFilter();

        filter.toFilter(movieOne);

        Episodes episode = new Episodes();
        episode.setNumber(1);
        episode.setName("Pilot");
        episode.setTvshow(supernatural);
        episode.setTotalViews(1000);

        filter.toFilter(episode);

        Movie movieTwo = new Movie("The Warriors", 1979);
        movieTwo.rate(8);

        ArrayList<Movie> moviesList = new ArrayList<>();

        moviesList.add(movieOne);
        moviesList.add(movieTwo);

        System.out.println("List's size: " + moviesList.size());
        System.out.println("First movie: " + moviesList.get(0).getName());

        System.out.println(movieOne.toString());

    }
}
