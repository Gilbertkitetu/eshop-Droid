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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class login extends AppCompatActivity {

    FirebaseAuth mAuth;

    EditText email, password;
    Button login, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);

        mAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = email.getText().toString().trim();
                String userPassword = password.getText().toString().trim();

                loginUser(userEmail, userPassword);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, signUp.class));
            }
        });
    }
    private void loginUser(String userEmail, String userPassword){
//        String userEmail = email.getText().toString();
//        String userPassword = password.getText().toString();

//        if(TextUtils.isEmpty((CharSequence) email)){
//            email.setError("Email cannot be empty");
//            email.requestFocus();
//
//        }else if (TextUtils.isEmpty((CharSequence) password)){
//            password.setError("Password cannot be empty");
//            password.requestFocus();
//        }
       // else{
            mAuth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(login.this, "Login successful", Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(login.this, MainActivity.class));
                        Intent intent = new Intent(login.this, MainActivity.class);
                        //intent.putExtra("username", userEmail);
                        startActivity(intent);
                    }else{
                        Toast.makeText(login.this, "Login error:"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        //}
    }
}