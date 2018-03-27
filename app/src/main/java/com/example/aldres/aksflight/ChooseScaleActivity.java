package com.example.aldres.aksflight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ChooseScaleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_scale);
        //get the spinner from the xml.
        final Spinner dropdown = findViewById(R.id.spinner1);
        Button startButton = findViewById(R.id.start_button);
//create a list of items for the spinner.
        final String[] items = new String[]{"1:1000", "1:2000", "1:5000"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int scale;
                switch (dropdown.getSelectedItem().toString()){
                    case "1:1000" : scale = 20;
                    case "1:2000" : scale = 19;
                    case "1:5000" : scale = 18;
                    default: scale = 20;
                }
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                intent.putExtra("scale", scale);
                startActivity(intent);
            }
        });



    }
}
