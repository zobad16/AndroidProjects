package com.projects.zobad.fragmentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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
        for(int i = 1; i<10; i++)
        {
            descriptions.add("Description for item"+i);
        }
    }

    @Override
    public void onItemSelected(int index) {

        tvDescription.setText(descriptions.get(index));
    }
}
