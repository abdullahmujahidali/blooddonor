package com.example.blooddonarapp;

import java.util.List;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.app.ActionBar;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class InviteFriend extends Activity implements OnClickListener {
private static final int PICK_CONTACT=1;

	EditText e1,e2;
	TextView t1,t2;
	Button b1,b2;
public static final String SMS_REPORT="com.example.sendsms.sms_report";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_invite_friend);
        ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.RED));
        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.editText2);
        t1=(TextView)findViewById(R.id.textView1);
        t1.setTypeface(Typeface.createFromAsset(getAssets(), "Fonts/ARJULIAN.ttf"));
        t2=(TextView)findViewById(R.id.textView2);
        t2.setTypeface(Typeface.createFromAsset(getAssets(), "Fonts/ARJULIAN.ttf"));
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(bu1);
        
        String p=PreferenceManager.getDefaultSharedPreferences(this).getString("phone", " ");
        String m=PreferenceManager.getDefaultSharedPreferences(this).getString("message", "");
        
        e1.setText(p);
        e2.setText(m);
        
        sendMess(p, m);
        
    }

   OnClickListener bu1=new OnClickListener() {
	   @Override
	   public void onClick(View arg0) {
		   Intent in =new Intent(Intent.ACTION_PICK,ContactsContract.Contacts.CONTENT_URI);
		   startActivityForResult(in,PICK_CONTACT);
	   }
   };




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
    protected void onActivityResult(int requestCode,int resultCode,Intent data  )
{
	super.onActivityResult(requestCode,resultCode,data);
	String phonenumber="";
	//switch(requestCode)
	if(resultCode != RESULT_CANCELED){
		if(requestCode==PICK_CONTACT){
	
	//case PICK_CONTACT:
		boolean hasPH=false;
		Cursor cursor = managedQuery(data.getData(),null,null,null,null);
		while(cursor.moveToNext())
		{
			String contactId=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
			String name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
			String hasPhone= cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
			
			if(hasPhone.equalsIgnoreCase("1"))
			{
				hasPH=true;
			}
			ContentResolver resolvr = getContentResolver();
			Cursor phones=resolvr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
					null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId,
	                 null, null);
			while(phones.moveToNext())
			{
				phonenumber=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
			}
			phones.close();
			}
		//break;
			
		}
	e1.setText(phonenumber);		
	}
}

	@Override
	public void onClick(View v) {
		String p=e1.getText().toString();
		String message=e2.getText().toString();
		sendMess(p,message);
		// TODO Auto-generated method stub
		
	}
	
	private void sendMess(String p, String m) {
		if(TextUtils.isEmpty(e1.getText()))
		{
			Toast.makeText(this, "Please enter Phone", Toast.LENGTH_LONG).show();
			return;
		}
		if(TextUtils.isEmpty(e2.getText()))
		{
			Toast.makeText(this, "Please enter Message", Toast.LENGTH_LONG).show();
			return;
		}
		b1.setEnabled(false);
		
		SmsManager sm1=SmsManager.getDefault();
		List<String> messages=sm1.divideMessage(e2.getText().toString());
		String phone=e1.getText().toString();
		for(String eachmessage:messages)
		{
			PendingIntent p1=PendingIntent.getBroadcast(this, 0, new Intent(SMS_REPORT), 0);
			
			sm1.sendTextMessage(phone, null, eachmessage, p1, null);
		}
			registerReceiver(br1,new IntentFilter(SMS_REPORT));
		}
		BroadcastReceiver br1=new BroadcastReceiver(){

			@Override
			public void onReceive(Context arg0, Intent arg1) {
				String message=null;
				boolean error=true;
				
				switch(getResultCode())
				{// TODO Auto-generated method stub
				case Activity.RESULT_OK:
					error=false;
					message="SMS Sent";
					break;
					
				case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
					message="SMS Sent";
					break;
					
				case SmsManager.RESULT_ERROR_NO_SERVICE:
					message="No network coverage";
					break;
					
				case SmsManager.RESULT_ERROR_NULL_PDU:
					message="Data not fount";
					break;
					
				case SmsManager.RESULT_ERROR_RADIO_OFF:
					message="Phone in Airplane mode";
					break;
					
			}
				t1.setText(message);
				t1.setTextColor(error? Color.RED:Color.GREEN);
				
				b1.setEnabled(true);
			
			
		}
		
		// TODO Auto-generated method stub
		
		};
 
}