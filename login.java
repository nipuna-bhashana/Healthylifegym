package com.example.chabha.healthylifegym;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class login extends AppCompatActivity {

    private Button signUpBtn;
    private Button signInBtn;
    private EditText userName;
    DatabaseReference child;

    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final DatabaseReference users = firebaseDatabase.getReference("Users");

        signUpBtn= (Button) findViewById(R.id.signup);
        signInBtn= (Button) findViewById(R.id.signIn);
        userName= (EditText) findViewById(R.id.uName);

        // child = users.child(userName.getText().toString());

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),signup.class);//go to login form
                startActivity(i);
            }
        });

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                users.addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(DataSnapshot dataSnapshot) {
                       Map<String, String> map = (Map<String, String>) dataSnapshot.child(userName.getText().toString()).getValue();
                      try {

                          String mob = map.get("MobNo");
                          String name = map.get("Name");

                          if (mob != null) {
                              //admin
                              if (mob.equals("713882364")){
                                  Intent i = new Intent(getApplicationContext(), MainUi.class);//go to mainui form
                                  startActivity(i);
                                  //coach
                              }else if(mob.equals("715257415")){
                                  Intent i = new Intent(getApplicationContext(), createShedule.class);//go to create shedule form
                                  startActivity(i);
                                //users
                              }else {
                                  Toast.makeText(getApplicationContext(), "Welcome " + name + " !!!", Toast.LENGTH_LONG).show();
                                  Intent i = new Intent(getApplicationContext(), ViewShedule.class);//go to login form
                                  Bundle bundle=new Bundle();
                                  bundle.putString("ID",userName.getText().toString());
                                  i.putExtras(bundle);
                                  startActivity(i);
                              }
                          }
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
    }
}
