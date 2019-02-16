package com.example.dell.messageebox;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class HomePageActivity extends Activity{
    Button hSendLater,hSendNow;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        hSendLater=(Button)findViewById(R.id.HbtnSendLater);
        hSendNow=(Button)findViewById(R.id.HbtnSendNow);
        hSendLater.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                displaysendlater();
            }
        });
        hSendNow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                displaysendnow();
            }
        });
    }

    void displaysendnow(){
        Intent intent = new Intent(HomePageActivity.this,SendNowActivity.class);
        startActivity(intent);
    }
    void displaysendlater(){
        Intent intent = new Intent(HomePageActivity.this,SendLaterActivity.class);
        startActivity(intent);
    }
}
