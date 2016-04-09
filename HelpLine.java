package com.example.blooddonarapp;

import android.net.Uri;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HelpLine extends Activity implements OnClickListener {
	Button b1;
	Button b2;
	Button b3;
	Button b4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_help_line);
		ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.RED));
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		b3=(Button)findViewById(R.id.button3);
		b4=(Button)findViewById(R.id.button4);

		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);

		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater=getMenuInflater();
		// Inflate the menu; this adds items to the action bar if it is present.
		menuInflater.inflate(R.menu.option_menu,menu);
		
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
	   	 int id=item.getItemId();
	   	switch(id){
	  	 case R.id.item1:
	  		 startActivity(new Intent(this,About.class));
	  		return true;
	  	 case R.id.item2:
	  		startActivity(new Intent(this,Click_Photo.class));
	  		return true;
	  	 case R.id.item3:
	  		startActivity(new Intent(this,Reminder.class));
	  		return true;
	  	case R.id.item4:
	  		startActivity(new Intent(this,InviteFriend.class));
	 	     return true;
	  	case R.id.item5:
	  		startActivity(new Intent(this,HelpLine.class));
	  		return true;
	   	 }
			return super.onOptionsItemSelected(item);
		}

	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.button1:
		Intent callIntent=new Intent(Intent.ACTION_CALL);
		callIntent.setData(Uri.parse("tel: +917961907766"));
		startActivity(callIntent);
		break;
		case R.id.button2:
	     Intent dialin=new Intent(Intent.ACTION_CALL);
	     dialin.setData(Uri.parse("tel: 108"));
	     startActivity(dialin);
		case R.id.button3:
			Intent in=new Intent(Intent.ACTION_CALL);
			in.setData(Uri.parse("tel: +91 11 23716441"));
			startActivity(in);
			break;
		case R.id.button4:
			Intent makein=new Intent(Intent.ACTION_CALL);
			makein.setData(Uri.parse("tel: +91-2040098584 "));
			startActivity(makein);
			break;

		// TODO Auto-generated method stub
		
	}

	}}
