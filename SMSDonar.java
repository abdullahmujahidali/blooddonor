package com.example.blooddonarapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SMSDonar extends Activity {
	Button b1;
	EditText e1;
    String s1;
    Intent i;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_smsdonar);
		ActionBar actionBar = getActionBar();
	    //actionBar.setBackgroundDrawable(new ColorDrawable(Color.RED));
	    actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FA5858"))); //FA5858
		i=getIntent();
		s1=i.getStringExtra("c1");
		b1 = (Button)findViewById(R.id.button1);
        
        e1 = (EditText) findViewById(R.id.editText1);
        b1.setOnClickListener(new OnClickListener(){
        	
           
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				sendSMS();
			}
        });
    }

    public void sendSMS() {
        
        String smsMessage = e1.getText().toString();
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("s1", null, smsMessage, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.",
                    Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),
                    "Sending SMS failed.",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    	
	}

}