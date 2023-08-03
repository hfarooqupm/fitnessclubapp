package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    Button button1,button2,button3;

    private AdView mAdView;
    private AdView mAdView1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
Toolbar toolbar=findViewById(R.id.toolbar);
setSupportActionBar(toolbar);




        button1=findViewById(R.id.beginnerstart);
        button2=findViewById(R.id.intermediatestart);
        button3=findViewById(R.id.advancedstart);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,BeginnerActivity.class);
                startActivity(intent);


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,IntermediateActivity.class);
                startActivity(intent);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AdvancedActivity.class);
                startActivity(intent);

            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

         mAdView1 = findViewById(R.id.adView1);
              AdRequest adRequest1 = new AdRequest.Builder().build();
                mAdView1.loadAd(adRequest1);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if(id==R.id.privacy){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://dailyworkoutapps.com/terms-of-use.html"));
            startActivity(intent);



            return true;
        }
        if(id==R.id.terms){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://dailyworkoutapps.com/terms-of-use.html"));
            startActivity(intent);


            return true;

        }
        if(id==R.id.share){

            Intent myintent=new Intent(Intent.ACTION_SEND);
            myintent.setType("text/plain");

            String sharebody="This is the best app for workout at home without equipment\n"+"https://play.google.com/store/apps/details?id=";
            String sharehub="Workout App";
            myintent.putExtra(Intent.EXTRA_SUBJECT,sharehub);
            myintent.putExtra(Intent.EXTRA_TEXT,sharebody);
            startActivity(Intent.createChooser(myintent,"share using"));



            return true;

        }
        if(id==R.id.rate){

            try {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=" + getPackageName())));

            }catch (Exception ex){
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id="+ getPackageName())));

            }

            return true;
        }
        if(id==R.id.more){

            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Leap+Fitness+Group"));
            startActivity(intent);

            return true;
        }
        return true;
    }

    public void food(View view) {
        Intent intent=new Intent(MainActivity.this,FoodActivity.class);
        startActivity(intent);


    }

    public void beginner(View view) {
        Intent intent=new Intent(MainActivity.this,BeginnerActivityNoRegistration.class);
        startActivity(intent);



    }

    public void intermediate(View view) {
        Intent intent=new Intent(MainActivity.this,IntermediateActivity.class);
        startActivity(intent);

    }

    public void advanced(View view) {
        Intent intent=new Intent(MainActivity.this,AdvancedActivity.class);
        startActivity(intent);

    }
}