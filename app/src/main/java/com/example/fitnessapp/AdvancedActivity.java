package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class AdvancedActivity extends AppCompatActivity {

    int[] newArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);


        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        newArray=new int[]{

                R.id.boat_pose,R.id.basiccrunches_pose,R.id.bench_pose,R.id.bicycle_pose,R.id.legraise_pose,R.id.heeltouch_pose,R.id.legup_pose,R.id.situp_pose,
                R.id.vups_pose,R.id.plankrotation_pose,R.id.plankwithleft_pose,R.id.russiontwist_pose,R.id.bridge_pose,R.id.verticalegcrunches_pose,
                R.id.windmill_pose





        };



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if(id==R.id.privacy){return true;}
        if(id==R.id.terms){return true;}
        if(id==R.id.share){return true;}
        if(id==R.id.rate){return true;}
        if(id==R.id.more){return true;}
        return true;
    }

    public void imagebuttonclicked(View view) {
        for(int i=0;i<newArray.length;i++){
            if(view.getId()==newArray[i]){
                int value=i+1;
                Log.i("FIRST",String.valueOf(value));
                Intent intent =new Intent(AdvancedActivity.this,ThirdActivity3.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);
            }



        }



    }
}