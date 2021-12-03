package com.example.cartoonanimeproject;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIUtility {
    /**public static APIResponse getCartoonFromJson()
    {
        //create a GSON object
        Gson gson = new Gson();
        APIResponse response = null;

        try(
                FileReader fileReader = new FileReader("json.json");
                JsonReader jsonReader = new JsonReader(fileReader);
        )
        {
            response = gson.fromJson(jsonReader, APIResponse.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return response;
    }*/

    /**
     * This will call the anime api with the specified search term
     */
    public static APIResponse getCartoonsData(String search) throws IOException, InterruptedException {
        search = search.trim().replace(" ", "%20");

        //String uri = "https://api.jikan.moe/v3/search/anime?q="+search;
        String uri = "https://api.jikan.moe/v3/search/anime?q=shinchan";


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        String jsonString =response.body();

        Gson gson = new Gson();
        APIResponse apiResponse = null;

        try{
            apiResponse = gson.fromJson(jsonString, APIResponse.class);
            //apiResponse  = gson.fromJson(jsonString, APIResponse.class);
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return apiResponse;
    }

    /**
     * This will call the anime api with the specified search term
     */
    public static CartoonTotalInfo getMoreInfo(String malId) throws IOException, InterruptedException {
        malId = malId.trim().replace(" ", "%20");

        String uri = "https://api.jikan.moe/v3/search/anime?i="+malId;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

        //this approach stores the API response to a String and then creates objects
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        return gson.fromJson(response.body(), CartoonTotalInfo.class);
    }
}
