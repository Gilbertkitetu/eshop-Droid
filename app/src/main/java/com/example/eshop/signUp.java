package com.example.eshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signUp extends AppCompatActivity {

    FirebaseAuth mAuth;

    EditText email, password;
    Button signup, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);

        mAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userEmail = email.getText().toString();
                String userPassword = password.getText().toString();
                createUser(userEmail, userPassword);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signUp.this, login.class));
            }
        });
    }
    private void createUser(String userEmail, String userPassword){


//        if(TextUtils.isEmpty((CharSequence) email)){
//            email.setError("Email cannot be empty");
//            email.requestFocus();
//
//        }else if (TextUtils.isEmpty((CharSequence) password)){
//            password.setError("Password cannot be empty");
//            password.requestFocus();
//        }
        //else{
            mAuth.createUserWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(signUp.this, "Account created successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(signUp.this, login.class));
                    }else {
                        Toast.makeText(signUp.this, "Sign Up error:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        //}
    }
}