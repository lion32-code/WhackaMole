package com.example.whackamole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

 int varRandMole;
 int varPrevRandMole;
 private TextView time;
 private TextView score;
 private ImageView imageMole1;
 private ImageView imageMole2;
 private ImageView imageMole3;
 private ImageView imageMole4;
 private ImageView imageMole5;
 private ImageView imageMole6;
 private ImageView imageMole7;
 private ImageView imageMole8;
 private ImageView imageMole9;
 public int varScore = 0;
 final Handler handler = new Handler();





 public int timeInterval = 1000;
 public int moleUpTime = 350;


 public CountDownTimer mTimer = new myTimer(30000, 1000);
 private Timer timer = new Timer();


 public ImageView molesClick [] = new ImageView [9];

 public int yValue;


 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);

  time = findViewById(R.id.time);
  score = findViewById(R.id.score);


  mTimer.start();
  handler.post(moleLoop);


  imageMole1 = (findViewById(R.id.imageMole1));
  imageMole2 = (findViewById(R.id.imageMole2));
  imageMole3 = (findViewById(R.id.imageMole3));
  imageMole4 = (findViewById(R.id.imageMole4));
  imageMole5 = (findViewById(R.id.imageMole5));
  imageMole6 = (findViewById(R.id.imageMole6));
  imageMole7 = (findViewById(R.id.imageMole7));
  imageMole8 = (findViewById(R.id.imageMole8));
  imageMole9 = (findViewById(R.id.imageMole9));


  molesClick [0] = imageMole1;
  molesClick [1] = imageMole2;
  molesClick [2] = imageMole3;
  molesClick [3] = imageMole4;
  molesClick [4] = imageMole5;
  molesClick [5] = imageMole6;
  molesClick [6] = imageMole7;
  molesClick [7] = imageMole8;
  molesClick [8] = imageMole9;



  DisplayMetrics metrics = new DisplayMetrics();
  getWindowManager().getDefaultDisplay().getMetrics(metrics);

  // Scale mole translation based on device dimensions
  int sHeight = metrics.heightPixels;
  yValue = (sHeight/9)*-1;

 }

 public void Endgame(View view) {
  MainActivity.this.finish();
  System.exit(0);
 }






 public class myTimer extends CountDownTimer {
  public myTimer(int maxTime, long stepTime) {
   super(maxTime, stepTime);

  }
  @Override

  public void onFinish() {
   this.cancel();
   EndGame(varScore);
   time.setText("done!");

  }


  public void onTick(long millisUntilFinished) {

   time.setText(String.valueOf(millisUntilFinished / 1000));


  }

 }




 public void EndGame(int EndScore) {

  Intent intent = new Intent(this, EndActivity.class);
  intent.putExtra("score", EndScore);

  mTimer.cancel();
  startActivity(intent);
  this.finish();

 }


 public Runnable moleLoop = new Runnable() {
  @Override
  public void run () {
   gameRandom();
   molesClick[varRandMole].animate().translationY(yValue).setDuration(moleUpTime);


   timer = new Timer();
   timer.schedule(new TimerTask() {
    public void run() {
      for (int i = 0; i < 9; i++) {
       if (molesClick[i].getTranslationY() == yValue) {

        final int j = i;

        runOnUiThread(new Runnable() {
         @Override
         public void run() {
          molesClick[j].animate().translationY(0);
         }
        });

       }
      }
    }
   }, timeInterval);

   handler.postDelayed(moleLoop, timeInterval);

  }
 };

 public void gameRandom() {
  Random rand = new Random();


  if (varRandMole == varPrevRandMole){
   varRandMole = rand.nextInt(8);

  }

  varPrevRandMole = varRandMole;
 }



 // Updates score text field
 public void updateScore(int Score){
  score.setText(String.valueOf(Score));
 }


 public void onClick(View v) {


  switch(v.getId()) {
   case R.id.imageMole1:
    if (molesClick[0].getTranslationY() < 0) {
     directHit();
    }
    break;
   case R.id.imageMole2:
    if (molesClick[1].getTranslationY() < 0) {
     directHit();
    }
    break;
   case R.id.imageMole3:
    if (molesClick[2].getTranslationY() < 0) {
     directHit();
    }
    break;
   case R.id.imageMole4:
    if (molesClick[3].getTranslationY() < 0) {
     directHit();
    }
    break;
   case R.id.imageMole5:
    if (molesClick[4].getTranslationY() < 0) {
     directHit();
    }
    break;
   case R.id.imageMole6:
    if (molesClick[5].getTranslationY() < 0) {
     directHit();
    }
    break;
   case R.id.imageMole7:
    if (molesClick[6].getTranslationY() < 0) {
     directHit();
    }
    break;
   case R.id.imageMole8:
    if (molesClick[7].getTranslationY() < 0) {
     directHit();
    }
    break;
   case R.id.imageMole9:
    if (molesClick[8].getTranslationY() < 0) {
     directHit();
    }
    break;
  }
 }


 public void directHit(){
  varScore += 50;
  updateScore(varScore);
 }
}

