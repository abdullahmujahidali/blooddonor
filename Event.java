package com.example.blooddonarapp;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Fragment;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Event extends Fragment implements OnClickListener {
	ImageView stop,start,clock;
	Button showNotificationBut,stopNotificationBut,alert;
	NotificationManager nm;
	boolean isNotificActive=false;
	int NotifyID=33;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, 
		    ViewGroup container, Bundle savedInstanceState) {
		Log.d("Fragment 1", "onCreateView");
		View view=inflater.inflate(R.layout.event, container, false);
		
		
		stop=(ImageView)view.findViewById(R.id.imageView1);
		start=(ImageView)view.findViewById(R.id.imageView2);
		clock=(ImageView)view.findViewById(R.id.imageView3);
		showNotificationBut=(Button)view.findViewById(R.id.button1);
		stopNotificationBut=(Button)view.findViewById(R.id.button2);
	    alert=(Button)view.findViewById(R.id.button3);
	    return inflater.inflate(
	            R.layout.event, container, false);
	    //return view;
	};
		/*View.OnClickListener handler=new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				switch(view.getId()){
				case R.id.button1:
					showNotification(view);
					break;
					
				case R.id.button2:
					stopNotification(view);
					break;
				case R.id.button3:
					setAlarm(view);
					break;
				}
				// TODO Auto-generated method stub
				
			

	

	}
			
		*/
	     
	     	
	
   public void showNotification(View view){
	
	NotificationCompat.Builder notificBuilder=new
			NotificationCompat.Builder(this.getActivity()).setContentTitle
			 ("Reminder").setContentText("Donate Blood").setTicker
			 ("Alert New Message").setSmallIcon(R.drawable.noti);
	Intent i=new Intent(this.getActivity(),MoreNotification.class);
	TaskStackBuilder tStackBuilder=TaskStackBuilder.create(this.getActivity());
	 tStackBuilder.addParentStack(MoreNotification.class);
	 tStackBuilder.addNextIntent(i);
	 PendingIntent pending=tStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
	 notificBuilder.setContentIntent(pending);
	 
	 nm=(NotificationManager)getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
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
	 Intent ai=new Intent(this.getActivity(),AlertReceiver.class);
	 AlarmManager am=(AlarmManager)getActivity().getSystemService(Context.ALARM_SERVICE);
	 am.set(AlarmManager.RTC_WAKEUP, alertTime, PendingIntent.getBroadcast(this.getActivity(), 
			 1, ai, PendingIntent.FLAG_UPDATE_CURRENT));
 }





 

	
	 @Override
	    public void onAttach(Activity activity) {
	        super.onAttach(activity);
	        Log.d("Fragment 1", "onAttach");
	    }
	    
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        Log.d("Fragment 1", "onCreate");
	    }

	    @Override
	    public void onActivityCreated(Bundle savedInstanceState) {
	        super.onActivityCreated(savedInstanceState);
	        Log.d("Fragment 1", "onActivityCreated");
	    }

	    @Override
	    public void onStart() {
	        super.onStart();
	        Log.d("Fragment 1", "onStart");
	    }

	    @Override
	    public void onResume() {
	        super.onResume();
	        Log.d("Fragment 1", "onResume");
	    }

	    @Override
	    public void onPause() {
	        super.onPause();
	        Log.d("Fragment 1", "onPause");
	    }
	    
	    @Override
	    public void onStop() {
	        super.onStop();
	        Log.d("Fragment 1", "onStop");
	    }
	    
	    @Override
	    public void onDestroyView() {
	        super.onDestroyView();
	        Log.d("Fragment 1", "onDestroyView");
	    }

	    @Override
	    public void onDestroy() {
	        super.onDestroy();
	        Log.d("Fragment 1", "onDestroy");
	    }
	    
	    @Override
	    public void onDetach() {
	        super.onDetach();
	        Log.d("Fragment 1", "onDetach");
	    }

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
	}

	// TODO Auto-generated method stub
	

