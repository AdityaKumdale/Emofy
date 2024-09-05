package com.example.leylandgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {
    private String[][] packages =
            {
                    {"Package 1 : Mini Pack", "", "","", "99"},
                    {"Package 2 : Medium Pack", "", "","", "299"},
                    {"Package 3 : Large Pack", "", "","", "899"},
                    {"Package 4 : Mega Pack", "", "","", "1499"},
                    {"Package 5 : Premium Pack", "", "","", "4699"},
            };
    private String[] package_details = {
            "Stress Balls\n" + "Meditate Set \n" +
                    "Lifetime Membership\n"+
                    "Puzzle Pack\n" +
                    "Riddles \n" +
                    "Interactive Bot \n" +
                    "*****************\n" +
                    "CONTACT of Seller: 9423827556",
            "Mini PACK + Free Delivery",
            "Mini PACK +Riddles",
            "Mini PACK +Lifetime Membership",
            "Complete Above Packs\n" +
                    "Mega Pack + Gifts \n" +
                    "Therapist\n" +
                    "AI Bot\n" +
                    "Books\n" +
                    "*************** \n" +
                    "CONTACT of Seller: 9423827556"
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart,btnBack;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart = findViewById(R.id.buttonLDGoToCart);
        btnBack = findViewById(R.id.buttonCartCheckout);
        listView = findViewById(R.id.ListViewLD);

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(LabTestActivity.this,Homeactivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<packages.length;i++){
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line2", "Total Cost: "+packages[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e,});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(LabTestActivity.this,CartLabActivity.class));
                Toast.makeText(getApplicationContext(), "Our Seller Will Contact you soon!!", Toast.LENGTH_LONG).show();
            }
        });
    }
}