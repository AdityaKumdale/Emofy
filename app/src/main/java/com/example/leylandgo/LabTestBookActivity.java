package com.example.leylandgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LabTestBookActivity extends AppCompatActivity {

    EditText edname,edaddress,edcontact,edpincode;
    Button btnBooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);

        edname = findViewById(R.id.editTextLTBFullName);
        edaddress = findViewById(R.id.editTextLTBAppAddress);
        edcontact = findViewById(R.id.editTextLTBContact);
        edpincode = findViewById(R.id.editTextLTBPincode);
        btnBooking = findViewById(R.id.buttonLTBBooking);

        Intent intent = getIntent();
        String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();

                Database db = new Database(getApplicationContext(),"Leland",null,1);
                db.addCart(username,edname.getText().toString(), Float.parseFloat(edaddress.getText().toString()),edcontact.getText().toString());
                db.removeCart(username,"Lab");
                Toast.makeText(getApplicationContext(),"Your booking is done successfully",Toast.LENGTH_LONG);
                startActivity(new Intent(LabTestBookActivity.this,Homeactivity.class));
            }
        });
    }
}