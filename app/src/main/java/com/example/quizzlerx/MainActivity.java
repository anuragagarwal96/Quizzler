package com.example.quizzlerx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    public void nextScreen(View v){

        Intent nextScreenLoad = new Intent(this,SpaceQuiz.class);
        startActivity(nextScreenLoad);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}