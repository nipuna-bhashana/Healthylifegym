package com.example.chabha.healthylifegym;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class ViewShedule extends AppCompatActivity {


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
        setContentView(R.layout.activity_view_shedule);
        Bundle bundle=getIntent().getExtras();
        final String id=bundle.getString("ID");

        exe2 = (EditText) findViewById(R.id.ex2);
        exe3 = (EditText) findViewById(R.id.ex3);
        exe4 = (EditText) findViewById(R.id.ex4);
        exe5 = (EditText) findViewById(R.id.ex5);
        exe6 = (EditText) findViewById(R.id.ex6);
        exe7 = (EditText) findViewById(R.id.ex7);
        exe8 = (EditText) findViewById(R.id.ex8);
        exe9 = (EditText) findViewById(R.id.ex9);

        final DatabaseReference users = firebaseDatabase.getReference("User_Shedule");

        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, String> map = (Map<String, String>) dataSnapshot.child(id).getValue();
                exe2.setText(map.get("EXE_1"));
                exe3.setText(map.get("EXE_2"));
                exe4.setText(map.get("EXE_3"));
                exe5.setText(map.get("EXE_4"));
                exe6.setText(map.get("EXE_5"));
                exe7.setText(map.get("EXE_6"));
                exe8.setText(map.get("EXE_7"));
                exe9.setText(map.get("EXE_8"));
                ;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
