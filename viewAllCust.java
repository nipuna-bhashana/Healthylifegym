package com.example.chabha.healthylifegym;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.R.layout;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class viewAllCust extends AppCompatActivity {

    private Button btn;
    private ListView lv;
    private ArrayList<String> details =new ArrayList<>();
    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
//    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_cust);
         DatabaseReference users = firebaseDatabase.getReference("Users");
//
        lv= (ListView) findViewById(R.id.listv);
        btn= (Button) findViewById(R.id.viewAll);

        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, layout.simple_list_item_1,details);
        lv.setAdapter(arrayAdapter);


        users.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                details.add(dataSnapshot.getValue(String.class));
               // details.add(value);
               // arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
