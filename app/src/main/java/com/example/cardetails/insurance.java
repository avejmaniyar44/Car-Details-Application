package com.example.cardetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class insurance extends AppCompatActivity {
    DatabaseReference reff;
    String New_no;
    TextView t1,t2,t3,t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance2);
        t1 = findViewById(R.id.in1);
        t2 = findViewById(R.id.in2);
        t3 = findViewById(R.id.in3);
        t4 = findViewById(R.id.in4);
        Intent intent = getIntent();
        New_no=intent.getStringExtra("key");
        reff= FirebaseDatabase.getInstance().getReference().child("vehicle").child(New_no);
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String oName = snapshot.child("n1").getValue(String.class);
                    String rc = snapshot.child("n4").getValue(String.class);
                    String insu = snapshot.child("n12").getValue(String.class);
                    String pollu = snapshot.child("n13").getValue(String.class);

                    t1.setText(oName);
                    t2.setText(rc);
                    t3.setText(insu);
                    t4.setText(pollu);


                }
                else {
                    finish();
                    Toast.makeText(getApplicationContext(),"Vehicle Not Found",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}