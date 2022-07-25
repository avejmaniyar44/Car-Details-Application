package com.example.cardetails;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class RCDetails extends AppCompatActivity {
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    DatabaseReference reff;
    String New_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_c_details);
        t1=(TextView) findViewById(R.id.t1);
        t2=(TextView) findViewById(R.id.t2);
        t3=(TextView) findViewById(R.id.t3);
        t4=(TextView) findViewById(R.id.t4);
        t5=(TextView) findViewById(R.id.t5);
        t6=(TextView) findViewById(R.id.t6);
        t7=(TextView) findViewById(R.id.t7);
        t8=(TextView) findViewById(R.id.t8);
        t9=(TextView) findViewById(R.id.t9);
        t10=(TextView) findViewById(R.id.t10);
        t11=(TextView) findViewById(R.id.t11);

        Intent intent = getIntent();
        New_no=intent.getStringExtra("key");
        reff= FirebaseDatabase.getInstance().getReference().child("vehicle").child(New_no);
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()) {
                    String oName = snapshot.child("n1").getValue(String.class);
                    String oShip = snapshot.child("n2").getValue(String.class);
                    String date = snapshot.child("n3").getValue(String.class);
                    String rc = snapshot.child("n4").getValue(String.class);
                    String vehicleName = snapshot.child("n5").getValue(String.class);
                    String color = snapshot.child("n6").getValue(String.class);
                    String type = snapshot.child("n7").getValue(String.class);
                    String fuel = snapshot.child("n8").getValue(String.class);
                    String status = snapshot.child("n9").getValue(String.class);
                    String rtoName = snapshot.child("n10").getValue(String.class);
                    String code = snapshot.child("n11").getValue(String.class);

                    t1.setText(oName);
                    t2.setText(oShip);
                    t3.setText(date);
                    t4.setText(rc);
                    t5.setText(vehicleName);
                    t6.setText(type);
                    t7.setText(fuel);
                    t8.setText(status);
                    t9.setText(rtoName);
                    t10.setText(code);
                    t11.setText(color);
                }
                else
                {
                    finish();
                    Toast.makeText(getApplicationContext(),"Vehicle Not Found",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w( "Failed to read value.", error.toException());
            }
        });
    }
}