package com.anjit.attendancesystem;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SplashActivity extends AppCompatActivity {

//    String TAG ="ANJIT";
////    private ImageButton btRegister;
////    private Button btLogin;
////    private TextView tvLogin;
////    private EditText loginEmail,loginPassword;
////    private ProgressDialog progressDialog;
////    private FirebaseAuth firebaseAuth;
//
//    Button login;
//    EditText username;
//    EditText password;
//    String uid;
//    String upass;
//    DatabaseReference rootRef;
//    DatabaseReference AdminRef;
//    DatabaseReference teacherRef;
//    DatabaseReference studentRef;

    private ImageView logo;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo = (ImageView) findViewById(R.id.logo);
        tv = (TextView) findViewById(R.id.tv);


        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); /// to delete from the stack
            }
        },5000);


        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mysplashanimation);
        logo.startAnimation(myanim);
        tv.startAnimation(myanim);

//        btRegister  = findViewById(R.id.btRegister);
//        btLogin = findViewById(R.id.btLogin);
//
//        tvLogin     = findViewById(R.id.tvLogin);
//
//        loginEmail = findViewById(R.id.editTextEmail);
//        loginPassword= findViewById(R.id.editTextPassword);
//
//
//        firebaseAuth=FirebaseAuth.getInstance();
//
//        progressDialog=new ProgressDialog(this);
//        btRegister.setOnClickListener(this);
//        btLogin.setOnClickListener(this);




//        login = findViewById(R.id.btLogin);
//        username =findViewById(R.id.editTextUsername);
//        password =findViewById(R.id.editTextPassword);
//        rootRef = FirebaseDatabase.getInstance().getReference();
//        AdminRef = rootRef.child("Admins");
//        studentRef =rootRef.child("Students");
//        teacherRef =rootRef.child ("Teachers");
//
//        create_admin();

    }

//    private void userLogin() {
//        String email = loginEmail.getText().toString().trim();
//        String password = loginPassword.getText().toString().trim();
//
//        if (TextUtils.isEmpty(email)) {
//            //email is empty
//            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if (TextUtils.isEmpty(password)) {
//            //password is empty
//            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        //if validation are okay
//        progressDialog.setMessage("Logging user...");
//        progressDialog.show();
//
//        firebaseAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        progressDialog.dismiss();
//
//                        if (task.isSuccessful()) {
//                            finish();
//                            startActivity(new Intent(getApplicationContext(), AdminActivity.class));
//                        }
//                    }
//                });
//    }
//
//
//
//
//
//
//
  //  @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    public void onClick(View v) {
////            if (v==btLogin){
////                userLogin();
////            }
////
////        if (v==btRegister){
////            Intent intent   = new Intent(SplashActivity.this,RegisterActivity.class);
////            Pair[] pairs    = new Pair[1];
////            pairs[0] = new Pair<View,String>(tvLogin,"tvLogin");
////            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this,pairs);
////            startActivity(intent,activityOptions.toBundle());
////        }
//    }
//
//    public void onLogin(View v){
//        uid = username.getText().toString();
//        upass= password.getText().toString();
//        try {
//            Log.d(TAG,"Inside try !!");
//
//            AdminRef.addListenerForSingleValueEvent(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot snapshot) {
//                    if (snapshot.hasChild(uid)) {
//                        if(snapshot.child(uid).getValue().equals(upass)) {
//
//                            Intent intent = new Intent(getApplicationContext(), AdminActivity.class);
//                            intent.putExtra("UID", uid);
//                            startActivity(intent);
//                        }else{
//                            Log.d(TAG, snapshot.child(uid).getValue(String.class));
//                            Toast.makeText(getApplicationContext(),"Incorrect Password !!",Toast.LENGTH_LONG).show();
//
//                        }
//
//
//
//                    }else{
//                        teacherRef.addListenerForSingleValueEvent(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(DataSnapshot snapshot) {
//                                if (snapshot.hasChild(uid)) {
//                                    if(snapshot.child(uid).child("pass").getValue().toString().contains(upass)) {
//
//
//                                        Log.d(TAG, "User  Found" +snapshot.child(uid).child("pass").getValue());
//                                        Intent intent = new Intent(getApplicationContext(), TeacherActivity.class);
//                                        intent.putExtra("UID", uid);
//                                        startActivity(intent);
//                                    }else{
//
//                                        Log.d(TAG,""+snapshot.child(uid).child("pass").getValue());
//                                        Toast.makeText(getApplicationContext(),"Incorrect Password !!",Toast.LENGTH_LONG).show();
//
//                                    }
//
//
//
//
//
//                                }else{
//                                    studentRef.addListenerForSingleValueEvent(new ValueEventListener() {
//                                        @Override
//                                        public void onDataChange(DataSnapshot snapshot) {
//                                            if (snapshot.hasChild(uid)) {
//                                                if(snapshot.child(uid).getValue().toString().contains(upass)) {
//                                                    Intent intent = new Intent(getApplicationContext(), StudentActivity.class);
//                                                    intent.putExtra("UID", uid);
//                                                    startActivity(intent);
//
//
//
//                                                }else{
//                                                    Toast.makeText(getApplicationContext(),"Incorrect Password !!",Toast.LENGTH_LONG).show();
//
//                                                }
//
//
//
//                                            }else{
//                                                Toast.makeText(getApplicationContext(),"Incorrect Username.",Toast.LENGTH_LONG).show();
//
//                                                Log.d(TAG,"No USername Found");
//                                            }
//                                        }
//
//                                        @Override
//                                        public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                                        }
//                                    });
//
//
//                                }
//                            }
//
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                            }
//                        });
//
//
//                    }
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
//        } catch( Exception e){
//            Log.d(TAG,"Databse Error");
//            Toast.makeText(this.getApplicationContext(),"Can't Connect To Database",Toast.LENGTH_LONG).show();
//            //this.finish();
//            //System.exit(0);
//        }
//
//
//
//
//    }
//
//
//    public void create_admin(){
//        try {
//
//            rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot snapshot) {
//                    if (snapshot.hasChild("Admins")) {
//
//                    } else {
//                        AdminRef.child("admin").setValue("1234");
//
//
//
//                    }
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
//        } catch( Exception e){
//            Toast.makeText(this.getApplicationContext(),"Can't Connect To Database",Toast.LENGTH_LONG).show();
//            this.finish();
//            System.exit(0);
//        }
//    }
}
