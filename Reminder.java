package com.example.blooddonarapp;

import java.util.GregorianCalendar;

import android.os.Bundle;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.view.WindowManager;
import android.widget.TextView;

public class Reminder extends Activity {
	boolean isNotificActive=false;
	NotificationManager nm;
	int NotifyID=33;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reminder);
        ActionBar actionBar = getActionBar();
	    
	    actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FA5858")));

	return;
	}
		
	
	public void showNotification(View view){
		NotificationCompat.Builder notificBuilder=new
				NotificationCompat.Builder(Reminder.this).setContentTitle
				 ("Reminder").setContentText("Donate Blood").setTicker
				 ("Alert New Message").setSmallIcon(R.drawable.noti);
		Intent i=new Intent(this,MoreNotification.class);
		TaskStackBuilder tStackBuilder=TaskStackBuilder.create(this);
		 tStackBuilder.addParentStack(MoreNotification.class);
		 tStackBuilder.addNextIntent(i);
		 PendingIntent pending=tStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
		 notificBuilder.setContentIntent(pending);
		 
		 nm=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
		 nm.notify(NotifyID,notificBuilder.build());
		 
		 isNotificActive=true;
		
	}
     public void stopNotification(View view){
    	 if(isNotificActive){
    			nm.cancel(NotifyID);
    	 }
		
	}
     public void setAlarm(View view){
    	 Long alertTime=new GregorianCalendar().getTimeInMillis()+5*1000;
    	 Intent ai=new Intent(Reminder.this,AlertReceiver.class);
    	 AlarmManager am=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
    	 am.set(AlarmManager.RTC_WAKEUP, alertTime, PendingIntent.getBroadcast(this, 
    			 1, ai, PendingIntent.FLAG_UPDATE_CURRENT));
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


}