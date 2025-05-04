package screenmatch.calcs;

public class RecomendationFilter {
    private String recommendation;

    public void toFilter(Classify classificate){
        if(classificate.getClassification() >= 4){
            System.out.println("Favorites of the moment");
        } else if(classificate.getClassification() >= 2) {
            System.out.println("Good amount of reviews lately");
        } else {
            System.out.println("Maybe you would like to watch later");
        }
    }
}
