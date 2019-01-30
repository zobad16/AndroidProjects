package com.projects.zobad.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    boolean bartActive =true;
    public void fade(View view){
        Log.i("Info","Image Clicked Bart");
        ImageView bart = (ImageView)findViewById(R.id.bartImageView);
        ImageView homer = (ImageView)findViewById(R.id.homerImageView);
        if(bartActive)
        {
            //Fade Animation
            /*bart.animate().alpha(0).setDuration(2000);
            homer.animate().alpha(1).setDuration(2000);*/

            //Move Down Animation
            bart.animate().rotation(360).alpha(0).setDuration(1000);
            homer.animate().alpha(1).rotation(360).setDuration(1000);
            bartActive =false;
        }
        else {
            /*bart.animate().alpha(1).setDuration(2000);
            homer.animate().alpha(0).setDuration(2000);*/
            //bart.animate().translationX(0).setDuration(2000);
            bart.animate().alpha(1).rotation(360).setDuration(1000);
            homer.animate().rotation(360).alpha(0).setDuration(1000);

            bartActive = true;
        }
    }
    public void fadeHomer(View view){
        Log.i("Info","Image Clicked Homer");
        ImageView bart = (ImageView)findViewById(R.id.bartImageView);
        ImageView homer = (ImageView)findViewById(R.id.homerImageView);
       /* homer.animate().alpha(0).setDuration(2000);
        bart.animate().alpha(1).setDuration(2000);
        */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
