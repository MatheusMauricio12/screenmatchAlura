import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import screenmatch.models.Title;
import screenmatch.models.TitleOMDB;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MainWithRequest {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        String search = "";

        List<Title> titles = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!search.equalsIgnoreCase("exit")) {

            System.out.println("Please type the name of the movie that you want to search: ");
            String answer = sc.nextLine();

            if (search.equals("exit")){
                break;
            }
            String address = "http://omdbapi.com/?t=" + answer.replace(" ", "+") + "&apikey=90b3e11a&";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(address))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                System.out.println(json);

                TitleOMDB myTitleOMDB = gson.fromJson(json, TitleOMDB.class);


                Title myTitle = new Title(myTitleOMDB);
                System.out.println(myTitle);

                FileWriter writing = new FileWriter("movie.txt");
                writing.write(myTitle.toString());
                writing.close();

                titles.add(myTitle);

            } catch (NumberFormatException e) {
                System.out.println("An error's occurred: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("A search error's occurred, please verify if the address is correctly typed.");
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Process's finished!");
            }
            System.out.println(titles);

            FileWriter writejson = new FileWriter("movies.json");
            writejson.write(gson.toJson(titles));
            writejson.close();
        }
    }
}
