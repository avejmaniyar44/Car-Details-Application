package com.example.cardetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CarCompany extends AppCompatActivity {
    ImageButton tata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_company);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomBar);

        bottomNavigationView.setSelectedItemId(R.id.car);
        tata =findViewById(R.id.tata);

        tata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CarCompany.this,TataCars.class);
                startActivity(intent);
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.car:
                        return  true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        return  true;

                    case R.id.bike:
                        startActivity(new Intent(getApplicationContext(),BikeComapny.class));
                        finish();
                        overridePendingTransition(0 ,0);
                        return  true;
                }
                return false;
            }
        });
    }
}