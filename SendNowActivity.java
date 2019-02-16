package com.example.dell.messageebox;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class SendNowActivity extends Activity implements OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_now);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);
        findViewById(R.id.HbtnSendNow).setOnClickListener(this);
    }

    public void onClick(View v) {
        String phoneNumber = ((EditText)
                findViewById(R.id.HetMobileNumber)).getText().toString();
        String sms = ((EditText)
                findViewById(R.id.HmtMessage)).getText().toString();
        try {
            SmsManager.getDefault().sendTextMessage(phoneNumber, null, sms , null, null);
            displaysendnow();
        } catch (Exception e) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            AlertDialog dialog = alertDialogBuilder.create();
            dialog.setMessage(e.getMessage());
            dialog.show();
        }
    }
    void displaysendnow(){
        Intent intent = new Intent(SendNowActivity.this,OutputActivity.class);
        startActivity(intent);
    }
}
