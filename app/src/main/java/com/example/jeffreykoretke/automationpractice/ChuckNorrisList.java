package com.example.jeffreykoretke.automationpractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

public class ChuckNorrisList extends FragmentActivity implements Runnable {

    private String [] jokes;
    private String [] imageURLs;

    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cn_list_activity);


        //TODO call API and display list of jokes and pics here
        //TODO what happens when you click a list item?



        try{
            run();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public void run(){


    }
}
