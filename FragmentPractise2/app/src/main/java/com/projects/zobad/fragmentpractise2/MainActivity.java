package com.projects.zobad.fragmentpractise2;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected{

   // ArrayList<String > description;
    String [] descriptions;
    TextView tvDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription = findViewById(R.id.tvDescription);
        descriptions = getResources().getStringArray(R.array.descriptions);
        //The phone is in portrait mode
        if(findViewById(R.id.layout_portrait)!= null){
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                   .hide(manager.findFragmentById(R.id.detailsFrag))
                   .show(manager.findFragmentById(R.id.listFrag))
                   .commit();
        }

        //The phone is in landscape mode
        if(findViewById(R.id.layout_land)!=null){
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                        .show(manager.findFragmentById(R.id.listFrag))
                        .show(manager.findFragmentById(R.id.detailsFrag))
                        .commit();

            }



    }

    @Override
    public void onItemSelected(int index) {
        //tvDescription.setText(description.get(index));
        tvDescription.setText(descriptions[index]);
    }
}
