package com.example.cardetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BikeComapny extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_comapny);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomBar);

        bottomNavigationView.setSelectedItemId(R.id.bike);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.car:
                        startActivity(new Intent(getApplicationContext(),CarCompany.class));
                        finish();
                        overridePendingTransition(0 ,0);
                        return  true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return  true;

                    case R.id.bike:
                        return  true;
                }
                return false;
            }
        });
    }
}