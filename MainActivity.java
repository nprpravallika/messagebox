package com.example.dell.messageebox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mLogin;
    private Button mSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLogin=(Button)findViewById(R.id.mainLogin);
        mSignUp=(Button)findViewById(R.id.mainSignUp);
        mLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                displayLogin();
            }
        });
        mSignUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                displaySignUp();
            }
        });
    }
    private void displayLogin(){
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }
    private void displaySignUp(){
        Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

}

