package com.projects.zobad.intentchallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    EditText name,web,location,phone;
    ImageView happy,sad,neutral;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //implements View.OnClickListener
        //Check for the name of view using view.findViewById
        name = findViewById(R.id.etName);
        web = findViewById(R.id.etWeb);
        location = findViewById(R.id.etLocation);
        phone = findViewById(R.id.etPhone);
        happy = findViewById(R.id.imgHappy);
        neutral = findViewById(R.id.imgNeutral);
        sad = findViewById(R.id.imgSad);

        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String extra_name= name.getText().toString().trim();
                String extra_phone = phone.getText().toString().trim();
                String extra_web = web.getText().toString().trim();
                String extra_location = location.getText().toString();
                intent.putExtra("name",extra_name);
                intent.putExtra("web", extra_web);
                intent.putExtra("location", extra_location);
                intent.putExtra("phone",extra_phone);
                intent.putExtra("mood","happy");
                setResult(RESULT_OK,intent);
                Main2Activity.this.finish();
            }
        });
        neutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String extra_name= name.getText().toString().trim();
                String extra_phone = phone.getText().toString().trim();
                String extra_web = web.getText().toString().trim();
                String extra_location = location.getText().toString();
                String extra_mood = "neutral";
                intent.putExtra("name",extra_name);
                intent.putExtra("web", extra_web);
                intent.putExtra("location", extra_location);
                intent.putExtra("phone",extra_phone);
                intent.putExtra("mood",extra_mood);
                setResult(RESULT_OK, intent);
                Main2Activity.this.finish();
            }
        });
        sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String extra_name= name.getText().toString().trim();
                String extra_phone = phone.getText().toString().trim();
                String extra_web = web.getText().toString().trim();
                String extra_location = location.getText().toString();
                String extra_mood = "sad";
                intent.putExtra("name",extra_name);
                intent.putExtra("web", extra_web);
                intent.putExtra("location", extra_location);
                intent.putExtra("phone",extra_phone);
                intent.putExtra("mood",extra_mood);
                setResult(RESULT_OK,intent);
                Main2Activity.this.finish();

            }
        });

    }
}
