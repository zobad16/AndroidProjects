package com.projects.zobad.intentchallenge;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    final static int ACTIVITY2 =2;
    Button btnCreateContact;
    ImageView imgMood, imgWeb, imgLocation, imgCall;
    LinearLayout layoutImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutImage = findViewById(R.id.layout_image);
        layoutImage.setVisibility(View.GONE);
        imgCall = findViewById(R.id.imgCall);
        imgMood = findViewById(R.id.imgMood);
        imgWeb = findViewById(R.id.imgWeb);
        imgLocation = findViewById(R.id.imgLocation);
        btnCreateContact = findViewById(R.id.btnCreateContact);

        btnCreateContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,
                        com.projects.zobad.intentchallenge.Main2Activity.class);
                startActivityForResult(intent,ACTIVITY2);

            }
        });
        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imgWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        imgLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK)
        {
            //1)implicit intent to make call tel
            //2)implicit intent to open website http
            //3)implicit intent to open location geo
            String mood = data.getStringExtra("mood");
            String extra_name = data.getStringExtra("name");
            if(mood.equalsIgnoreCase( "happy")){imgMood.setImageResource(R.drawable.happy);}
            else if(mood.equalsIgnoreCase( "sad")){imgMood.setImageResource(R.drawable.sad);}
            else if (mood.equalsIgnoreCase( "neutral")) {imgMood.setImageResource(R.drawable.neutral);}
            final String telephone = "tel:"+data.getStringExtra("phone");
            final String web = "http://"+data.getStringExtra("web");
            final String location = "geo:0,0?q="+data.getStringExtra("location");
            layoutImage.setVisibility(View.VISIBLE);

            imgCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(telephone));
                    startActivity(intent);
                }
            });
            imgWeb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse( web));
                    startActivity(intent);
                }
            });
            imgLocation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(location));
                    startActivity(intent);
                }
            });

        }
        if(resultCode == RESULT_CANCELED)
        {
            //tvResult.setText("No Data received");
        }
    }
}
