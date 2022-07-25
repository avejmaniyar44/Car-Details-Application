package com.example.cardetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    ImageButton rc,insurance;
    TextView t1,t2,t3;
    RecyclerView list1,list2,list3;
    List<App>  appList1,appList2,appList3;
    String No;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        e1= findViewById(R.id.edt_txt1);
        t1 =findViewById(R.id.renew_insu);
        t2 = findViewById(R.id.textView6);
        t3 = findViewById(R.id.sellcar);

        rc = findViewById(R.id.img_btn1);
        insurance = findViewById(R.id.img_btn2);

        list1 = findViewById(R.id.list1);
        list2 = findViewById(R.id.list2);
        list3 = findViewById(R.id.list3);
        appList1 = new ArrayList<>();
        appList2 = new ArrayList<>();
        appList3 = new ArrayList<>();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomBar);

        bottomNavigationView.setSelectedItemId(R.id.home);





        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url1 = "https://ci.policybazaar.com";
                Intent intent  = new Intent(Intent.ACTION_VIEW,Uri.parse(url1));
                startActivity(intent);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url2 = "https://parivahan.gov.in/parivahan/";
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(url2));
                startActivity(intent);

            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url3 = "https://cars24.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(url3));
                startActivity(intent);
            }
        });
        rc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                No=e1.getText().toString();
                if (No.isEmpty()) {
                    Toast.makeText(MainActivity.this,"Please Enter Number",Toast.LENGTH_LONG).show();
                }
                else
                {
                  Intent intent = new Intent(MainActivity.this,RCDetails.class);
                    intent.putExtra("key",No);
                    startActivity(intent);
                }
            }
        });
        insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                No=e1.getText().toString();
                if (No.isEmpty()) {
                    Toast.makeText(MainActivity.this,"Please Enter Number",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this,insurance.class);
                    intent.putExtra("key",No);
                    startActivity(intent);
                }
            }
        });

        appList1.add(new App(R.drawable.car3,"Hyundai Venue"));
        appList1.add(new App(R.drawable.car4,"Mahindra Scorpio"));
        appList1.add(new App(R.drawable.car5,"Toyota Vellfare"));
        appList1.add(new App(R.drawable.car6,"Honda City"));
        appList1.add(new App(R.drawable.car7,"Vitara Brezza"));
        appList1.add(new App(R.drawable.car8,"Kia Seltos"));
        appList1.add(new App(R.drawable.car9,"Mahindra XUV700"));

        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        list1.setLayoutManager(manager1);

        CustomAdapter adapter1 = new CustomAdapter(this,appList1);
        list1.setAdapter(adapter1);

        appList2.add(new App(R.drawable.bike1,"TVS Apache"));
        appList2.add(new App(R.drawable.bike2,"Classic 350"));
        appList2.add(new App(R.drawable.bike3,"Activa 6G"));
        appList2.add(new App(R.drawable.bike4,"Honda Livo"));
        appList2.add(new App(R.drawable.bike5,"Hero Deluxe"));
        appList2.add(new App(R.drawable.bike6,"Honda Hornet"));
        appList2.add(new App(R.drawable.bike7,"Honda Unicorn"));

        LinearLayoutManager manager2 = new LinearLayoutManager(this);
        manager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        list2.setLayoutManager(manager2);

        CustomAdapter adapter2 = new CustomAdapter(this,appList2);
        list2.setAdapter(adapter2);


        appList3.add(new App(R.drawable.news1,""));
        appList3.add(new App(R.drawable.news4,""));
        appList3.add(new App(R.drawable.news33,""));
        appList3.add(new App(R.drawable.news44,""));
        appList3.add(new App(R.drawable.news55,""));
        appList3.add(new App(R.drawable.news66,""));
        appList3.add(new App(R.drawable.news77,""));

        LinearLayoutManager manager3 = new LinearLayoutManager(this);
        manager3.setOrientation(LinearLayoutManager.HORIZONTAL);
        list3.setLayoutManager(manager3);

        CustomAdapter adapter3 = new CustomAdapter(this,appList3);
        list3.setAdapter(adapter3);

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