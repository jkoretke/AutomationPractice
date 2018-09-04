package com.example.jeffreykoretke.automationpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

public class ChuckNorrisListController extends FragmentActivity implements Runnable {

    private String [] jokes;
    private String [] imageURLs;

    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_cn_joke_activity);


        //TODO call API and display list of jokes and pics here



        try{
            run();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public void run(){


    }
}
