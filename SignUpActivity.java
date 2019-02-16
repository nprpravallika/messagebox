package com.example.dell.messageebox;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    private EditText userEmail,userPassword;
    private Button sSignUp;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firebaseAuth=FirebaseAuth.getInstance();
       userEmail=(EditText)findViewById(R.id.SetEmailAddress);
        userPassword=(EditText)findViewById(R.id.SetPassword);
        sSignUp=(Button)findViewById(R.id.SbtnSignUp);
        sSignUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                 if(validate()){
                    String user_email = userEmail.getText().toString().trim();
                    String user_password = userPassword.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, "Registration Successful", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(SignUpActivity.this, HomePageActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(SignUpActivity.this, "Registration Failed", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
    }
    private Boolean validate(){
        Boolean result=false;
        String password=userPassword.getText().toString();
        String email=userEmail.getText().toString();
        if(password.isEmpty()||email.isEmpty()){
            Toast.makeText(SignUpActivity.this,"Please enter all details",Toast.LENGTH_LONG).show();
        }
        else{
            result=true;
        }
        return result;
    }
}
