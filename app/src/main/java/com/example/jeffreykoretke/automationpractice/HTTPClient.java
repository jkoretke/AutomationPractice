package com.example.jeffreykoretke.automationpractice;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPClient {

    private ChuckNorrisFact [] chuckNorrisFacts;
    private URL url;

    public HTTPClient(URL url){
        this.url = url;
    }

    private void populateChuckNorrisFacts() throws IOException{
        String json = getJson(url);
        Gson gson = new Gson();
        chuckNorrisFacts = gson.fromJson(json, ChuckNorrisFact[].class);
    }

    private String getJson(URL url) throws IOException{
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        if(responseCode != 200)
            System.err.println("Invalid API call");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while((inputLine = in.readLine()) != null){
            response.append(inputLine);

            //for debugging
            System.out.println(inputLine);

        }
        in.close();

        return response.toString();
    }
}
