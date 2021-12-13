package com.example.whackamole;

import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class StartGame  extends AppCompatActivity {
    public static final String TAG = "StartGame";
    private Button accessibility_custom_action_0button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startgame);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){

        }
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
        }



        accessibility_custom_action_0button = findViewById(R.id.accessibility_custom_action_0button);

        accessibility_custom_action_0button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               openMainActivity();
                accessibility_custom_action_0button.setEnabled(true);
            }
    });
    }
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void QuitApp(View view) {
       StartGame.this.finish();
        System.exit(0);
    }
}


