package com.anjit.attendancesystem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "RegisterActivity";
    private FirebaseAuth mAuth;
    private Button buttonSignUp;
    private EditText signUpEmail,signUpPassword,signUpConfirmPassword;
    private TextView textViewSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        //Initialize Button
        buttonSignUp = findViewById(R.id.btnSignUp);
        signUpEmail = findViewById(R.id.editTextEmail);
        signUpPassword = findViewById(R.id.editTextPassword);
        signUpConfirmPassword = findViewById(R.id.editTextConfirmPassword);

        //Initialize TextView
        textViewSignIn = findViewById(R.id.textViewSignIn);

        textViewSignIn.setOnClickListener(this);

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email= signUpEmail.getText().toString().trim();
                String pass = signUpPassword.getText().toString().trim();
                String c_pass = signUpConfirmPassword.getText().toString().trim();

                //check for email password confirmation

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(RegisterActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    Toast.makeText(RegisterActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(pass.length()<8){
                    Toast.makeText(RegisterActivity.this, "Password is too short", Toast.LENGTH_SHORT).show();

                }
                if(TextUtils.isEmpty(c_pass)){
                    Toast.makeText(RegisterActivity.this, "Please enter confirm password", Toast.LENGTH_SHORT).show();
                    return;
                }

                //check if the password and confirm password match
                if(pass.equals(c_pass)){


                    createAccount(email,pass);  //create account firebase
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Passwords do not match !", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    public void createAccount(String email,String password){
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            Log.d(TAG, "createUserWithEmail:success");

                            Toast.makeText(RegisterActivity.this,"Sign Up Successful",Toast.LENGTH_SHORT);
                            startActivity(new Intent(getApplicationContext(), SplashActivity.class));
                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // ...
                    }
                });
    }


    @Override
    public void onClick(View v) {

        if(v == textViewSignIn){

            Intent intent = new Intent(this, SplashActivity.class);
            startActivity(intent);
        }
    }
}
