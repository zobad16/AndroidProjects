package com.projects.zobad.falsephone;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityMain extends AppCompatActivity {

    TextView tvMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMessage = findViewById(R.id.tvNumber);
        if(getIntent().getData() != null)
        {
            tvMessage.setText(getIntent().getData().toString().trim());
        }
        else
        {
            tvMessage.setText("No data received");
        }

    }
}
