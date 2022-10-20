package com.example.user.androidsceneform;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_about extends AppCompatActivity {
    Button contact, email, maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        contact = findViewById(R.id.contact);
        email = findViewById(R.id.email);
        maps = findViewById(R.id.maps);

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLink("https://wa.me/+6285895188073");
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLink("mailto:micohari0@gmail.com?subject=Pemesanan%20Booth&body=Saya%20ingin%20bertanya-tanya%20tentang%20model%20booth");
            }
        });
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goLink("https://goo.gl/maps/Q52UBzLbkxCwbAxe7");
            }
        });
    }

    private void goLink(String s) {


        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}
