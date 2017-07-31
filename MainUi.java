package com.example.chabha.healthylifegym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainUi extends AppCompatActivity {

    private Button viewAllBtn;
    private Button searchBtn;
    private Button updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ui);

        viewAllBtn= (Button) findViewById(R.id.viewAll);
        searchBtn= (Button) findViewById(R.id.search);
        updateBtn= (Button) findViewById(R.id.update);

        viewAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),viewAllCust.class);//go to view all customer form
                startActivity(i);
            }
        });
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),searchCust.class);//go to search customer form
                startActivity(i);
            }
        });
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),searchCust.class);//go to update customer form
                startActivity(i);
            }
        });
    }
}
