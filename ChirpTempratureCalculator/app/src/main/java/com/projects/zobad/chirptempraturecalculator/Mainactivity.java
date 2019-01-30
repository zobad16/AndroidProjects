package com.projects.zobad.chirptempraturecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Mainactivity extends AppCompatActivity {
    TextView message1 ;
    EditText etChirp;
    Button submit;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        message1 = findViewById(R.id.tvMessage1);
        etChirp = findViewById(R.id.etChirps);
        submit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);
        tvResult.setVisibility(View.GONE);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int input = Integer.parseInt(etChirp.getText().toString().trim());
                double result = (input/3)+4;
                tvResult.setText(getString(R.string.result)+result);
                tvResult.setVisibility(View.VISIBLE);
            }
        });

    }
}

