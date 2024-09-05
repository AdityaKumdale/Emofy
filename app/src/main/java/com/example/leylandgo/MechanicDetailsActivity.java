package com.example.leylandgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MechanicDetailsActivity extends AppCompatActivity {
    private String[][] mechanic_details1 =
            {       {"Therapist Name :Ajit Saste", "Therapist Address : Pimpri", "Exp : 5 yrs", "Mobile No:989898989","600"},
    {"Therapist Name :Prasad Pawal", "Therapist Address : Nigdi" , "Exp : 15yrs", "Mobile No:7898989898", "960"},
    {"Therapist Name :Swapnil Kale", "Therapist Address : Pune", "Exp : 8yrs", "Mobile No:8898989898", "300"},
        {"Therapist Name :Deepak Deshmukh", "Garage Address : Chinchuad", "Exp : 6yrs","Mobile No:9898000000", "500"},
                {"Therapist Name :Ashok Pandya", "Therapist Address : Katraj", "Exp : 7yrs", "Mobile No:7798989898", "800"}
        };

    private String[][] mechanic_details2 =
            {       {"Therapist Name :Seema Patil", "Therapist Address : Pimpri", "Exp : 5 yrs", "Mobile No:989898989","600"},
                    {"Therapist Name :Aasad Pawal", "Therapist Address : Delhi" , "Exp : 15yrs", "Mobile No:7898989898", "960"},
                    {"Therapist Name :Nil Kale", "Therapist Address : Pune", "Exp : 8yrs", "Mobile No:8898989898", "300"},
                    {"Therapist Name :Deeneseh Deshmukh", "Therapist Address : Chinchuad", "Exp : 6yrs","Mobile No:9898000000", "500"},
                    {"Therapist Name :Mahima Panday", "Therapist Address : Katraj", "Exp : 7yrs", "Mobile No:7798989898", "800"}
            };


        TextView tv;
    Button btn;
    String[][]mechanic_details = {};
    HashMap<String,String> item;
    ArrayList<HashMap<String, String>> list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanic_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonCartCheckout);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Leyland Mechanics")==0){
            mechanic_details = mechanic_details1;
        } else{
            if(title.compareTo("Non-Leyland Mechanics")==0)
                mechanic_details = mechanic_details2;
        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MechanicDetailsActivity.this,FindMechanicActivity.class));
            }
        });

        list = new ArrayList<>();
        for(int i=0;i<mechanic_details.length;i++){
            item = new HashMap<String,String>();
            item.put(("line1"), mechanic_details[i][0]);
            item.put(("line2"), mechanic_details[i][1]);
            item.put(("line3"), mechanic_details[i][2]);
            item.put(("line4"), mechanic_details[i][3]);
            item.put(("line5"), "Basic Servicing Fees: "+mechanic_details[i][4] +"/-");
            list.add(item);
        }
        sa= new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.ListViewLD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(MechanicDetailsActivity.this,BookServiceingActivity.class);
                it.putExtra(("text1"), mechanic_details[i][0]);
                it.putExtra(("text2"), mechanic_details[i][1]);
                it.putExtra(("text3"), mechanic_details[i][2]);
                it.putExtra(("text4"), mechanic_details[i][3]);
                it.putExtra(("text5"), mechanic_details[i][4]);
                startActivity(it);
            }
        });
    }
}