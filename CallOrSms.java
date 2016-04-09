package com.example.blooddonarapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony.Sms;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class CallOrSms extends Activity implements OnClickListener {
	ImageButton ib1,ib2;
	TextView tv1,tv2;
	String c1;
	Intent i;
	String st;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_call_or_sms);
		ActionBar actionBar = getActionBar();
	    //actionBar.setBackgroundDrawable(new ColorDrawable(Color.RED));
	    actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FA5858")));
	    i=getIntent();
		c1=i.getStringExtra("s1");
	    //FA5858
		
		ib1=(ImageButton)findViewById(R.id.imageButton1);
		ib2=(ImageButton)findViewById(R.id.imageButton3);
		tv1=(TextView)findViewById(R.id.textView1);
		tv2=(TextView)findViewById(R.id.textView2);
        ib2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i =new Intent(CallOrSms.this,SMSDonar.class);
		           i.putExtra("c1", c1);
		           startActivity(i);
			}
			
		});
		
		ib1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				 i=getIntent();
				  c1=i.getStringExtra("s1");
				Intent callIntent=new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:"+ c1));
				startActivity(callIntent);
			}
			
				// TODO Auto-generated method stub
				
			
		});}


	@Override
	public void onClick(View v) {
		
		// TODO Auto-generated method stub
		
	}}
		

