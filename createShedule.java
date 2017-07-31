package com.example.chabha.healthylifegym;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class createShedule extends AppCompatActivity {

    private Button sveBtn;
    private Button cnclBtn;
    private EditText idtxt;
    private EditText exe10;
    private EditText exe2;
    private EditText exe3;
    private EditText exe4;
    private EditText exe5;
    private EditText exe6;
    private EditText exe7;
    private EditText exe8;
    private EditText exe9;
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_shedule);

        final DatabaseReference users = firebaseDatabase.getReference("User_Shedule");
        idtxt = (EditText) findViewById(R.id.id);
        exe2 = (EditText) findViewById(R.id.ex2);
        exe3 = (EditText) findViewById(R.id.ex3);
        exe4 = (EditText) findViewById(R.id.ex4);
        exe5 = (EditText) findViewById(R.id.ex5);
        exe6 = (EditText) findViewById(R.id.ex6);
        exe7 = (EditText) findViewById(R.id.ex7);
        exe8 = (EditText) findViewById(R.id.ex8);
        exe9 = (EditText) findViewById(R.id.ex9);

        sveBtn = (Button) findViewById(R.id.save);

        sveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=idtxt.getText().toString();//create unique id for each record

                DatabaseReference ex1 = users.child(id).child("EXE_1");
                ex1.setValue(exe2.getText().toString());
                DatabaseReference ex2 = users.child(id).child("EXE_2");
                ex2.setValue(exe3.getText().toString());
                DatabaseReference ex3 = users.child(id).child("EXE_3");
                ex3.setValue(exe4.getText().toString());
                DatabaseReference ex4 = users.child(id).child("EXE_4");
                ex4.setValue(exe5.getText().toString());
                DatabaseReference ex5 = users.child(id).child("EXE_5");
                ex5.setValue(exe6.getText().toString());
                DatabaseReference ex6 = users.child(id).child("EXE_6");
                ex6.setValue(exe7.getText().toString());
                DatabaseReference ex7 = users.child(id).child("EXE_7");
                ex7.setValue(exe8.getText().toString());
                DatabaseReference ex8 = users.child(id).child("EXE_8");
                ex8.setValue(exe9.getText().toString());


            }
        });






    }
}
