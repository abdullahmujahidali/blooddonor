package com.example.blooddonarapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;

public class AlertReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent arg1) {
		createNotification(context,"Times Up","5 seconds has passed","Alert");
		
		// TODO Auto-generated method stub

	}

	private void createNotification(Context context, String msg,
			String msgText, String msgAlert) {
		PendingIntent ni=PendingIntent.getActivity(context, 0, new Intent(context,Reminder.class), 0);
		NotificationCompat.Builder mBuilder=new NotificationCompat.Builder(context).setSmallIcon
				(R.drawable.noti).setContentTitle(msg).setTicker(msgAlert).setContentText(msgText);
		
		mBuilder.setContentIntent(ni);
		mBuilder.setDefaults(NotificationCompat.DEFAULT_SOUND);
		mBuilder.setAutoCancel(true);
		
		NotificationManager mnm=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
		mnm.notify(1,mBuilder.build());
		// TODO Auto-generated method stub
		
	}

}
