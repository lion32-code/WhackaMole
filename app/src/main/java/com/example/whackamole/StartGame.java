package com.example.whackamole;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class StartGame  extends AppCompatActivity {
    public static final String TAG = "StartGame";
    private Button startbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startgame);

        startbutton = findViewById(R.id.startbutton);

       startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               openMainActivity();
               startbutton.setEnabled(false);
            }
    });
    }
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
