package com.projects.zobad.intentchallenge2;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.util.List;

import static android.content.Intent.ACTION_DIAL;
import static android.content.Intent.parseUri;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class ActivityMain extends AppCompatActivity {

    Button btnCreate;
    TextView tvMsg;
    LinearLayout linearLayout;
    ImageView imgMood,imgCall, imgWeb, imgLocation;
    String extra_name = "" ,extra_call= "", extra_web= "",extra_location="", extra_mood="";
    final int CREATE_ACTIVITY = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMsg =findViewById(R.id.textView);
        linearLayout = findViewById(R.id.linearLayout);
        imgMood = findViewById(R.id.imgMood);
        imgCall = findViewById(R.id.imgCall);
        imgWeb = findViewById(R.id.imgWeb);
        imgLocation = findViewById(R.id.imgLocation);
        btnCreate = findViewById(R.id.btnCreate);

        linearLayout.setVisibility(View.GONE);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityMain.this,
                        com.projects.zobad.intentchallenge2.CreateActivity.class);
                if(isIntentAvailable(intent)) {
                    //startActivity(intent);
                    Toast.makeText(getBaseContext(), "a", Toast.LENGTH_LONG).show();
                    startActivityForResult(intent,CREATE_ACTIVITY);
                }
                else{
                    Toast.makeText(getBaseContext(), "Failed", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private Boolean isIntentAvailable(Intent intent) {
           List<ResolveInfo> list = getPackageManager().queryIntentActivities(intent,
                    PackageManager.MATCH_DEFAULT_ONLY);
            return list.size() > 0;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK)
        {

            extra_name = data.getStringExtra("name");
            extra_call = data.getStringExtra("phone");
            extra_web = data.getStringExtra("web");
            extra_location = data.getStringExtra("location");
            extra_mood = data.getStringExtra("mood");
            if(extra_mood.equalsIgnoreCase("happy"))
            {
                imgMood.setImageResource(R.drawable.happy);

            }
            else if(extra_mood.equalsIgnoreCase("sad")){imgMood.setImageResource(R.drawable.sad);}
            else if(extra_mood.equalsIgnoreCase("neutral"))imgMood.setImageResource(R.drawable.neutral);
            linearLayout.setVisibility(View.VISIBLE);
            imgCall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+extra_call));
                    startActivity(intent);
                }
            });
            imgWeb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+extra_web));
                    startActivity(intent);
                }
            });
            imgLocation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q="+extra_location));
                    startActivity(intent);
                }
            });

        }
        else {}
    }
}
