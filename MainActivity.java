package com.example.blooddonarapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
SharedPreferences sp;
TextView TextView;
public static final String PREFS_NAME = "MyPrefsFile";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		/*requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		//this.getActionBar().setDisplayShowCustomEnabled(true);
		//this.getActionBar().setDisplayShowTitleEnabled(false);
		//LayoutInflater inflator = LayoutInflater.from(this);
        //View v = inflator.inflate(R.layout.activity_main, null);
 
        //Typeface tf = Typeface.createFromAsset(getAssets(),"Fonts/COMIC.TTF");
		
		//((TextView)v.findViewById(R.id.title)).setTypeface(tf);
		//setText(this.getTitle());
		//this.getActionBar().setCustomView(v);
	    sp=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
	    String et1=sp.getString("Key_Name", "");
	     String et2=sp.getString("Key_Phone_No", "");
	     String et3=sp.getString("Key_Email", "");
	    String et4=sp.getString("Key_Area_Code", "");
	    
	    
	    MediaPlayer mpSplash= MediaPlayer.create(this, R.raw.peo);
	    mpSplash.start();
	    ActionBar actionBar = getActionBar();
	    //actionBar.setBackgroundDrawable(new ColorDrawable(Color.RED));
	    actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FA5858"))); //FA5858
		
		Thread logoTimer=new Thread(){
		public void run(){
	    try{
	    	sleep(3000);
	    	SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
	    	//Get "hasLoggedIn" value. If the value doesn't exist yet false is returned
	    	boolean hasLoggedIn = settings.getBoolean("hasLoggedIn", false);

	    	if(hasLoggedIn)
	    	{
	    		Intent i=new Intent(getApplicationContext(),Find.class);
		    	startActivity(i);
	    	    //Go directly to main activity.
	    	}else
	    	{
	    		Intent i=new Intent(getApplicationContext(),Register.class);
		    	startActivity(i);
	    		
	    	}
	    	
			
	    	
	    

	    } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    finally {
	    	
	    }
		}
		};
		logoTimer.start();
	
	}
		

	@Override
	    public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;

		
	}
}