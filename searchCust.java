package com.example.chabha.healthylifegym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class searchCust extends AppCompatActivity {

    private Button Btn;
    private Button UpBtn;
    private EditText nameTxt;
    private EditText ageTxt;
    private EditText mobTxt;
    private EditText searchId;
    String gender=null;

    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_cust);

        final DatabaseReference users = firebaseDatabase.getReference("Users");
        searchId = (EditText) findViewById(R.id.searchTxt);
        nameTxt = (EditText) findViewById(R.id.name);
        ageTxt = (EditText) findViewById(R.id.age);
        mobTxt = (EditText) findViewById(R.id.mobNo);

        Btn= (Button) findViewById(R.id.searchBtn);
        UpBtn= (Button) findViewById(R.id.update);

//search details
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                users.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Map<String, String> map = (Map<String, String>) dataSnapshot.child(searchId.getText().toString()).getValue();
                        try {

                            nameTxt.setText(map.get("Name"));
                            ageTxt.setText(map.get("Age"));
                            mobTxt.setText(map.get("MobNo"));
                            gender=map.get("Gender");


                        }catch (NullPointerException e){
                            Toast.makeText(getApplicationContext(), "User id  not valid!!", Toast.LENGTH_LONG).show();
                            Log.d("E_Value", "FileExplorerActivity: Exception:"+e.getMessage());

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
//Update Details
        UpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id=mobTxt.getText().toString();//create unique id for each record

                DatabaseReference name = users.child(id).child("Name");
                name.setValue(nameTxt.getText().toString());

                DatabaseReference age = users.child(id).child("Age");
                age.setValue(ageTxt.getText().toString());

                DatabaseReference gendert = users.child(id).child("Gender");
                gendert.setValue(gender);

                DatabaseReference mobno = users.child(id).child("MobNo");
                mobno.setValue(mobTxt.getText().toString());

                Toast.makeText(getApplicationContext(), "User Update Success", Toast.LENGTH_LONG).show();

            }
        });


    }
}
