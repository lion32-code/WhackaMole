package com.example.whackamole;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndActivity extends AppCompatActivity {
    private Button accessibility_custom_action_0button;
    private TextView Sccore;
    private Button accessibility_custom_action_1button;
    private TextView Highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        Sccore = findViewById(R.id.Sccore);
        Highscore = findViewById(R.id.Highscore);



        accessibility_custom_action_0button = findViewById(R.id.accessibility_custom_action_0button);
        TextView ScoreCheck = (TextView) findViewById(R.id.Sccore);
        accessibility_custom_action_1button = findViewById(R.id.accessibility_custom_action_1button);


        // Get the extras our Intent sent through
        Intent intent = getIntent();
         int Score = intent.getExtras().getInt("score", 0);
         Sccore.setText(Score + "");


        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int highScore = settings.getInt("HIGH_SCORE", 0);


        if(Score > highScore) {
            Highscore.setText("HIGH SCORE: "+ Score);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIGH_SCORE", Score);
            editor.commit();


        }
        else {
            Highscore.setText("HIGH SCORE: " + highScore);
        }




        // Menu button goes back to the main menu
        if (accessibility_custom_action_0button != null) {
            accessibility_custom_action_0button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EndActivity.this.finish();
                    System.exit(0);
                }
            });
        }

        if (accessibility_custom_action_1button != null) {
            accessibility_custom_action_1button.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    openMainActivity();
                    accessibility_custom_action_0button.setEnabled(true);
                }
            });
        }
    }
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

