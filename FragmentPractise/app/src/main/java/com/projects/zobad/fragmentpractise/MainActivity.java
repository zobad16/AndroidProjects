package com.projects.zobad.fragmentpractise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected{

    TextView tvDescription;
    ArrayList<String> descriptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription = findViewById(R.id.tvDescription);

        descriptions = new ArrayList<String>();
        for(int i =0 ; i<10; i++){
            descriptions.add("Item "+(i+1)+": Description");
        }


    }

    @Override
    public void onItemSelected(int index) {
        tvDescription.setText(descriptions.get(index));
    }
}
