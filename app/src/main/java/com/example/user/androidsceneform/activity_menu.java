package com.example.user.androidsceneform;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class activity_menu extends AppCompatActivity {
    //activity
    private Button boothButton, aboutButton, scanButton, addButton;

    //exit

    boolean isPressed = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //variable
        boothButton = findViewById(R.id.btn_booth);
        aboutButton = findViewById(R.id.btn_about);
        scanButton = findViewById(R.id.btn_scan);
        addButton = findViewById(R.id.btn_add);

        //booth
        boothButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_menu.this, activity_booth.class);
                startActivity(intent);
            }
        });
        //about
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_menu.this, activity_about.class);
                startActivity(intent);
            }
        });
        //booth
        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_menu.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //add
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_menu.this, viewe3d.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (isPressed) {
            finishAffinity();

            System.exit(0);
        }else {
            Toast.makeText(getApplicationContext()
                    , "Please Click back again to exit."
                    ,Toast.LENGTH_SHORT).show();
            isPressed = true;
        }
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                isPressed = false;
            }
        };
        new Handler().postDelayed(runnable,2000);
    }
}
