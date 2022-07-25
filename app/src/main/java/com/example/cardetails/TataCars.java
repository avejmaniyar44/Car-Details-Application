package com.example.cardetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TataCars extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tata_cars);
        getSupportActionBar().hide();

    }
}