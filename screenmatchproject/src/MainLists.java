import screenmatch.models.Movie;
import screenmatch.models.Title;
import screenmatch.models.Tvshow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainLists {
    public static void main(String[]args){
        Movie movieOne = new Movie("Avatar", 2009);
        Tvshow supernatural = new Tvshow("Supernatural", 2005);
        Movie movieTwo = new Movie("The Warriors", 1979);
        Movie movieThree = new Movie(("World War - Z"), 2013);

        movieOne.rate(9);
        movieTwo.rate(7);

        List<Title> titlesList = new ArrayList<>();

        titlesList.add(movieOne);
        titlesList.add(movieTwo);
        titlesList.add(supernatural);
        titlesList.add(movieThree);

        for(Title title: titlesList){
            System.out.println(title.getName());
            if(title instanceof Movie){
                Movie movies = (Movie) title;
                System.out.println(movies.getClassification());
            }
        }
        ArrayList<String> searchByArtist = new ArrayList<>();
        searchByArtist.add("Adam Sandler");
        searchByArtist.add("Samuel L. Jackson");
        searchByArtist.add("Chad Tantrum");

        Collections.sort(titlesList);
        System.out.println(titlesList);

        titlesList.sort(Comparator.comparing(Title::getYearOfRelease));
        System.out.println(titlesList);
    }
}
