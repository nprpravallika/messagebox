package com.example.dell.messageebox;

import android.app.ProgressDialog;
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

public class LoginActivity extends AppCompatActivity {
    private EditText lEmail;
    private EditText lPassword;
    private Button lLogin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lEmail=(EditText)findViewById(R.id.LetEmailAddress);
        lPassword=(EditText)findViewById(R.id.LetPassword);
        lLogin=(Button)findViewById(R.id.LbtnLogin);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        lLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                validate(lEmail.getText().toString(),lPassword.getText().toString());
            }
        });
    }

    private void validate(String UserName,String UserPassword){

        progressDialog.setMessage("Authenticating...");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(UserName,UserPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful()){
                       progressDialog.dismiss();;
                       Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_LONG).show();
                       startActivity(new Intent(LoginActivity.this,HomePageActivity.class));
                   }
                else{
                       progressDialog.dismiss();;
                       Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
                   }
            }
        });
    }
}
