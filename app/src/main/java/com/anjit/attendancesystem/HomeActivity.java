package com.anjit.attendancesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity  {

    private FirebaseAuth firebaseAuth;
    Button logoutbtn;
   private CardView addStudent;
    private TextView textViewUserEmail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        addStudent = (CardView) findViewById(R.id.addStudent);

//        firebaseAuth= FirebaseAuth.getInstance();
//        if(firebaseAuth.getCurrentUser() == null){
//            startActivity(new Intent(this,SplashActivity.class));
//        }
//        FirebaseUser user= firebaseAuth.getCurrentUser();
//        textViewUserEmail= findViewById(R.id.editTextEmail);
//
//        textViewUserEmail.setText(user.getEmail());
//
//
//        logoutbtn=findViewById(R.id.logout);
//
//
//        logoutbtn.setOnClickListener(this);

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),StudentActivity.class));
            }
        });





    }

//    @Override
//    public void onClick(View v) {
//
//        if(v==logoutbtn){
//            firebaseAuth.signOut();
//            finish();
//            startActivity(new Intent(this,SplashActivity.class));
//        }
//
//    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_item,menu);
//        return true;
//    }





}
