package com.example.chabha.healthylifegym;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    private Button sveBtn;
    private Button cnclBtn;
    private EditText nameTxt;
    private EditText ageTxt;
    private EditText mobTxt;
    private RadioButton genderRd;
    private RadioGroup gen;

    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final DatabaseReference users = firebaseDatabase.getReference("Users");
        nameTxt = (EditText) findViewById(R.id.name);
        ageTxt = (EditText) findViewById(R.id.age);
        mobTxt = (EditText) findViewById(R.id.mobNo);
        gen = (RadioGroup) findViewById(R.id.radiogrp);

        sveBtn= (Button) findViewById(R.id.btnSave);
        cnclBtn= (Button) findViewById(R.id.btnCancel);

        sveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id=mobTxt.getText().toString();//create unique id for each record

                DatabaseReference name = users.child(id).child("Name");
                name.setValue(nameTxt.getText().toString());

                DatabaseReference age = users.child(id).child("Age");
                age.setValue(ageTxt.getText().toString());

                DatabaseReference gender = users.child(id).child("Gender");
                int checkedRadioButtonId = gen.getCheckedRadioButtonId();
                genderRd= (RadioButton) findViewById(checkedRadioButtonId);
                gender.setValue(genderRd.getText());

                DatabaseReference mobno = users.child(id).child("MobNo");
                mobno.setValue(mobTxt.getText().toString());



            }
        });




    }
}
