package com.example.user.androidsceneform;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class activity_booth extends AppCompatActivity {

    Button booth1, booth2, booth3, booth4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booth);

        booth1 = findViewById(R.id.booth1);
        booth2 = findViewById(R.id.booth2);
        booth3 = findViewById(R.id.booth3);
        booth4 = findViewById(R.id.booth4);



        booth1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean installed = isAppInstalled("com.whatsapp");

                if (installed)
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=6285895188073&text=Saya%20Pesan%20Booth%0AModel%20%20%20%3A%20Booth%20Container%0AUkuran%20%3A%205m%20x%202%2C5m%20x%203m%20%0AHarga%20%3A%2018.000.000"));
                    startActivity(intent);
                }

                else
                {
                    Toast.makeText(activity_booth.this, "Whatsapp is not installed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        booth2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean installed = isAppInstalled("com.whatsapp");

                if (installed)
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=6285895188073&text=Saya%20Pesan%20Booth%0AModel%20%20%20%3A%20Booth%20Galvalum%0AUkuran%20%3A%202m%20x%201m%20x%203m%20%0AHarga%20%3A%203.500.000"));
                    startActivity(intent);
                }

                else
                {
                    Toast.makeText(activity_booth.this, "Whatsapp is not installed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        booth3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean installed = isAppInstalled("com.whatsapp");

                if (installed)
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=6285895188073&text=Saya%20Pesan%20Booth%0AModel%20%20%20%3A%20Booth%20Kayu%0AUkuran%20%3A%202m%20x%201m%20x%203m%20%0AHarga%20%3A%202.800.000"));
                    startActivity(intent);
                }

                else
                {
                    Toast.makeText(activity_booth.this, "Whatsapp is not installed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        booth4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean installed = isAppInstalled("com.whatsapp");

                if (installed)
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=6285895188073&text=Saya%20Pesan%20Booth%0AModel%20%20%20%3A%20Booth%20Alumunium%0AUkuran%20%3A%202m%20x%201m%20x%203m%20%0AHarga%20%3A%201.500.000"));
                    startActivity(intent);
                }

                else
                {
                    Toast.makeText(activity_booth.this, "Whatsapp is not installed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean isAppInstalled(String s) {
        PackageManager packageManager = getPackageManager();
        boolean is_installed;

        try {
            packageManager.getPackageInfo(s, PackageManager.GET_ACTIVITIES);
            is_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            is_installed = false;
            e.printStackTrace();
        }
        return is_installed;
    }
}
