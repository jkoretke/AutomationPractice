package com.example.jeffreykoretke.automationpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button changeTextButton, displayTextButton;
    private TextView changeTextView, displayTextView;
    private EditText inputText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeTextView = findViewById(R.id.textView);
        displayTextView = findViewById(R.id.display_text_view);
        inputText = findViewById(R.id.input_text);

        changeTextButton = findViewById(R.id.change_text_btn);
        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeTextView.setText("Changed!");
            }
        });

        displayTextButton = findViewById(R.id.display_text_button);
        displayTextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                displayTextView.setText(inputText.getText());
            }
        });
    }
}
