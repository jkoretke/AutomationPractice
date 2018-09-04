package com.example.jeffreykoretke.automationpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.ListView;

import java.io.IOException;
import java.net.URL;

public class ChuckNorrisList extends FragmentActivity implements Runnable {

    private String [] jokes;
    private String [] imageURLs;
    private  URL APIURL = null;
    private ChuckNorrisFact [] chuckNorrisFacts;
    private ListView list;

    protected void onCreate(@Nullable Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cn_list_activity);


        //TODO call API and display list of jokes and pics here
        //TODO what happens when you click a list item?

        try {
            APIURL = new URL("https://api.chucknorris.io/jokes/random");
        }
        catch (Exception e){
            e.printStackTrace();
        }




        try{
            HTTPClient httpClient = new HTTPClient(APIURL);
            chuckNorrisFacts = httpClient.getChuckNorrisFacts();
            run();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public void run(){

        imageURLs = new String[chuckNorrisFacts.length];
        jokes = new String[chuckNorrisFacts.length];

        for(int i = 0; i < chuckNorrisFacts.length; i++){
            imageURLs[i] = chuckNorrisFacts[i].getPicURL();
            jokes[i] = chuckNorrisFacts[i].getJoke();
        }

        ChuckNorrisListEntry adapter = new ChuckNorrisListEntry(ChuckNorrisList.this, imageURLs, jokes);

        list = findViewById(R.id.list);
        list.setAdapter(adapter);

    }
}
