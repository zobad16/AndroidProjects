package com.projects.zobad.intentchallenge2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class CreateActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etPhone, etWeb, etLocation;
    ImageView imgHappy, imgSad, imgNeutral;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_actvity);

        etName =findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etWeb = findViewById(R.id.etWeb);
        etLocation = findViewById(R.id.etLocation);
        imgHappy = findViewById(R.id.imgHappy);
        imgSad = findViewById(R.id.imgSad);
        imgNeutral = findViewById(R.id.imgNeutral);

        imgHappy.setOnClickListener(this);
        imgSad.setOnClickListener(this);
        imgNeutral.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
      if(  v.getId() == R.id.imgHappy){
          Intent intent = new Intent();
          intent.putExtra("name",etName.getText().toString().trim());
          intent.putExtra("phone", etPhone.getText().toString().trim());
          intent.putExtra("web",etWeb.getText().toString().trim());
          intent.putExtra("location",etLocation.getText().toString().trim());
          intent.putExtra("mood","happy");
          setResult(RESULT_OK,intent);
          CreateActivity.this.finish();
      }
      else if(v.getId() == R.id.imgNeutral) {
          Intent intent = new Intent();
          intent.putExtra("name",etName.getText().toString().trim());
          intent.putExtra("phone", etPhone.getText().toString().trim());
          intent.putExtra("web",etWeb.getText().toString().trim());
          intent.putExtra("location",etLocation.getText().toString().trim());
          intent.putExtra("mood","neutral");
          setResult(RESULT_OK,intent);
          CreateActivity.this.finish();

      }
      else if(v.getId() == R.id.imgSad){
          Intent intent = new Intent();
          intent.putExtra("name",etName.getText().toString().trim());
          intent.putExtra("phone", etPhone.getText().toString().trim());
          intent.putExtra("web",etWeb.getText().toString().trim());
          intent.putExtra("location",etLocation.getText().toString().trim());
          intent.putExtra("mood","sad");
          setResult(RESULT_OK,intent);
          CreateActivity.this.finish();

      }
    }
}
