package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity2 extends AppCompatActivity {
    String buttonvalue;

    Button startbtn;
    private CountDownTimer countDownTimer;
    TextView mtextview;
    private boolean runnningtime;
    private long lefttime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third2);

        Intent intent=getIntent();
        buttonvalue=intent.getStringExtra("value");

        int intvalue=Integer.valueOf(buttonvalue);

        switch (intvalue){

            case 1:
                setContentView(R.layout.activity_boat_pose2);
                break;
            case 2:
                setContentView(R.layout.activity_basiccrunches_pose2);
                break;
            case 3:
                setContentView(R.layout.activity_bench_pose2);
                break;
            case 4:
                setContentView(R.layout.activity_bicycle_pose2);
                break;
            case 5:
                setContentView(R.layout.activity_legraise_pose2);
                break;
            case 6:
                setContentView(R.layout.activity_boatpose2);
                break;
            case 7:
                setContentView(R.layout.activity_legup_pose2);
                break;
            case 8:
                setContentView(R.layout.activity_situp_pose2);
                break;
            case 9:
                setContentView(R.layout.activity_vups_pose2);
                break;
            case 10:
                setContentView(R.layout.activity_plankrotation_pose2);
                break;
            case 11:
                setContentView(R.layout.activity_plankwithleft_pose2);
                break;
            case 12:
                setContentView(R.layout.activity_russiontwist_pose3);
                break;
            case 13:
                setContentView(R.layout.activity_bridge_pose3);
                break;
            case 14:
                setContentView(R.layout.activity_verticalegcrunches_pose3);
                break;
            case 15:
                setContentView(R.layout.activity_windmill_pose3);
                break;




        }

        startbtn=findViewById(R.id.startbutton);
        mtextview=findViewById(R.id.time);


        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(runnningtime){

                    stoptimer();
                }
                else{

                    startTimer();
                }

            }
        });



    }

    private void stoptimer(){


        countDownTimer.cancel();
        runnningtime=false;
        startbtn.setText("START");
    }

    private void startTimer(){

        final CharSequence value1=mtextview.getText();
        String number1=value1.toString();
        String number2=number1.substring(0,2);
        String number3=number1.substring(3,5);


        final int number=Integer.valueOf(number2)*60+Integer.valueOf(number3);
        lefttime=number*1000;

        countDownTimer =new CountDownTimer(lefttime,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                lefttime = millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish() {
                int newvalue=Integer.valueOf(buttonvalue)+1;
                if(newvalue<=7){
                    Intent intent=new Intent(ThirdActivity2.this,ThirdActivity2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);

                }
                else{
                    newvalue=1;
                    Intent intent=new Intent(ThirdActivity2.this,ThirdActivity2.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);

                }


            }
        }.start();
        startbtn.setText("PAUSE");
        runnningtime=true;


    }


    private void updateTimer(){
        int minutes=(int) (lefttime/1000)/60;
        int seconds=(int) (lefttime/1000)%60;

        String lefttimeText="";
        if(minutes<10)
            lefttimeText="0";
        lefttimeText=lefttimeText+minutes+":";


        if(seconds<10)
            lefttimeText+="0";
        lefttimeText+=seconds;
        mtextview.setText(lefttimeText);




    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}