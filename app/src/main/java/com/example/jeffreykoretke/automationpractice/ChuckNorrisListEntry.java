package com.example.jeffreykoretke.automationpractice;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URL;

public class ChuckNorrisListEntry extends ArrayAdapter<String>{

    private final Activity context;
    private final String [] imageUrl;
    private final String [] joke;


    ChuckNorrisListEntry(Activity context, String  [] url, String [] joke ){
        super(context, R.layout.list_single);
        this.context = context;
        this.imageUrl = url;
        this.joke = joke;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent){

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_single, null, true);

        ImageView pic = rowView.findViewById(R.id.list_image);
        TextView jokeText = rowView.findViewById(R.id.joke_text);

        jokeText.setText(joke[position]);

        try{
            URL url = new URL(imageUrl[position]);
            Picasso.with(context).load(url.toString()).into(pic);

        }catch (Exception e){
            System.out.println("Error loading image url");
        }

        return rowView;
    }
}
