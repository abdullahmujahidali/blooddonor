package com.example.blooddonarapp;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText; 
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toolbar;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Register extends Activity implements OnClickListener, OnItemSelectedListener{
	String[] BloodGroup={	"","O+","O-","A+","A-","A1+","A2+","A1-","A2-","B+","B-","AB+","AB-","A1B+","A2B+","A1B-",
	"A2B-"};
		String[] State={ "","Andhra Pradesh","Andaman and Nicobar Island","Arunachal Pradesh","Assam","Bihar",
				"Chandigarh","Chattisgarh","Dadar and Nagar Haveli","Delhi","Goa","Gujarat","Haryana",
				"Himachal Pradesh","Jammu & Kashmir","Jharkhand","Karnataka","Kerala",
				"Lakshadweep","MadhyaPradesh","Maharashtra","Manipur","Meghalaya","Mizoram",
				"Nagaland","Orissa","Punjab","Puducherry","Rajasthan","Sikkim",
	"Tamil Nadu","Tilangana","Tripura","Uttar Pradesh","Uttrakhand","West Bengal" };
		
		final Context context = this;
	TextView t1,t2,t3,t4;
	EditText e1,e2,e3,e4;
	Button b1;
	String Incoming_json;
	String name,phone,email,area;
	String url;
	InputStream is=null;
	
	String result=null;
	String line=null;
	
	
	
	private static final Pattern NAME_PATTERN = Pattern
			.compile("^[a-zA-Z ]+$"); /*("[a-zA-Z0-9]{1,250}");*/
	private static final Pattern EMAIL_PATTERN = Pattern
			.compile("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+");
	private static final Pattern PHONE_PATTERN=Pattern.compile("\\d{10}"); //1}-\\d{10
	private static final Pattern AREA_PATTERN=Pattern.compile("\\d{6}");
	String MyPREFERENCES = "MyPrefs" ;
	String Name = "nameKey";
    String Phone = "phoneKey";
	String Email = "emailKey";
	String Area = "areaKey";
    SharedPreferences sp;
    String s1,s2,s3;
    Spinner sp1,sp2,sp3;
    public static final String PREFS_NAME = "MyPrefsFile";
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_register);
		boolean abc=isNetworkAvailable();
		if(abc==false)
		
			{
				
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

					// set title
					alertDialogBuilder.setTitle("Check Internet connection");

					// set dialog message
					alertDialogBuilder
						.setMessage("No internet connectivity!")
						.setCancelable(false)
						.setPositiveButton("back",new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,int id) {
								// if this button is clicked, close
								// current activity
								Register.this.finish();
							}
						  });
						
					
						

						// create alert dialog
						AlertDialog alertDialog = alertDialogBuilder.create();

						// show it
						alertDialog.show();
					}
		e1=(EditText)findViewById(R.id.editText1);
		e1.setCursorVisible(true);
		e2=(EditText)findViewById(R.id.editText2);
		e2.setCursorVisible(true);
	    e3=(EditText)findViewById(R.id.editText3);
	    e3.setCursorVisible(true);
		e4=(EditText)findViewById(R.id.editText4);
		e4.setCursorVisible(true);
		t1=(TextView)findViewById(R.id.textView1);
		t1.setShadowLayer(30, 2, 2, Color.CYAN);
		t1.setTypeface(Typeface.createFromAsset(getAssets(), "Fonts/ARCENA.ttf"));
		t2=(TextView)findViewById(R.id.textView2);
		t2.setTypeface(Typeface.createFromAsset(getAssets(), "Fonts/CASTELAR.TTF"));
		t3=(TextView)findViewById(R.id.textView3);
		t3.setTypeface(Typeface.createFromAsset(getAssets(), "Fonts/CASTELAR.TTF"));
		t4=(TextView)findViewById(R.id.textView4);
		t4.setTypeface(Typeface.createFromAsset(getAssets(), "Fonts/CASTELAR.TTF"));
		sp1=(Spinner)findViewById(R.id.spinner1);
		sp2=(Spinner)findViewById(R.id.spinner2);
        sp3=(Spinner)findViewById(R.id.spinner3);
		
		
		b1=(Button)findViewById(R.id.button1); 
		b1.setTypeface(Typeface.createFromAsset(getAssets(), "Fonts/ARCENA.ttf"));
		ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FA5858")));
		
		b1.setOnClickListener(this);
		ArrayAdapter<String> aa=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,BloodGroup);
		aa.setDropDownViewResource(android.R.layout.simple_spinner_item);
		sp1.setAdapter(aa);
		sp1.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
			 
				s1=parent.getItemAtPosition(position).toString();
				Toast.makeText(Register.this, "Selected Blood Group: " + s1, Toast.LENGTH_SHORT).show();
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		ArrayAdapter<String> bb=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,State);
		bb.setDropDownViewResource(android.R.layout.simple_spinner_item);
		sp2.setAdapter(bb);
		sp2.setOnItemSelectedListener(this);
		
		
		
	}
	private boolean isNetworkAvailable() {
		 ConnectivityManager connectivityManager 
         = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
   NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
   return activeNetworkInfo != null && activeNetworkInfo.isConnected();

		// TODO Auto-generated method stub
		
	}
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
	  {
		 
        s2=parent.getItemAtPosition(position).toString();
		Toast.makeText(this, "Selected State:" + s2, Toast.LENGTH_SHORT).show();
		

		
		if(s2.contentEquals("Andhra Pradesh")){
			List<String> City=new ArrayList<String>();
			City.add("Hyderabad");
					City.add("Visakhapatnam");
					City.add("Vijayawada");
					City.add("Guntur");
					City.add("Warangal");
					City.add("Nellore");
					City.add("Kurnool");
					City.add("Kadapa");
					City.add("Rajahmundry");
					City.add("Kakinada");
			ArrayAdapter<String> cc=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc.notifyDataSetChanged();
			sp3.setAdapter(cc);
			
		}
		if(s2.contentEquals("Andaman and Nicobar Island")){
			List<String> City=new ArrayList<String>();
			City.add("Port Blair");
			ArrayAdapter<String> cc2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc2.notifyDataSetChanged();
			sp3.setAdapter(cc2);
		}
		if(s2.contentEquals("Arunachal Pradesh")){
			List<String> City=new ArrayList<String>();
			City.add("Papumpare");
					City.add("Changlang");
					City.add("Lohit");
					City.add("West Siang");
					City.add("Tirap");
					City.add("East Siang");
					City.add("Kurung Kumey");
					City.add("West Kameng");
					City.add("Upper Subansiri");
					City.add("Lower Subansiri");
					City.add("East Kameng");
					City.add("Lower Dibang Valley");
					City.add("Tawang");
					City.add("Upper Siang");
					City.add("Anjaw");
					City.add("Dibang Valley");
			ArrayAdapter<String> cc3=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc3.notifyDataSetChanged();
			sp3.setAdapter(cc3);
		}
		if(s2.contentEquals("Assam")){
			List<String> City=new ArrayList<String>();
			City.add("Guwahati");
			City.add("Silchar");
			City.add("Dibrugarh");
			City.add("Nagaon"); 
			ArrayAdapter<String> cc23=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc23.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc23.notifyDataSetChanged();
			sp3.setAdapter(cc23);
}
		if(s2.contentEquals("Bihar")){
			List<String> City=new ArrayList<String>();
			City.add("Patna");
			City.add("Gaya");
			City.add("Bhagalpur");
			City.add("Muzaffarpur");
			City.add("Biharsharif");
			City.add("Darbhanga");
			City.add("Purnia");
			City.add("Arrah");
			City.add("Begusarai");
			City.add("Katihar");
			ArrayAdapter<String> cc24=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc24.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc24.notifyDataSetChanged();
			sp3.setAdapter(cc24);
}
		if(s2.contentEquals("Chandigarh")){
			List<String> City=new ArrayList<String>();
			City.add("Chandigarh");
			ArrayAdapter<String> cc4=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc4.notifyDataSetChanged();
			sp3.setAdapter(cc4);
		}
		if(s2.contentEquals("Chattisgarh")){
			List<String> City=new ArrayList<String>();
			City.add("Raipur");
					City.add("Bhilai Nagar");
					City.add("Korba");
					City.add("Bilaspur");
					City.add("Durg");
					City.add("Rajnandgaon");
					City.add("Raigarh");
					City.add("Jagdalpur");
					City.add("Ambikapur");
			ArrayAdapter<String> cc5=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc5.notifyDataSetChanged();
			sp3.setAdapter(cc5);
		}
		if(s2.contentEquals("Dadar and Nagar Haveli")){
			List<String> City=new ArrayList<String>();
			City.add("Silvassa");
			ArrayAdapter<String> cc6=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc6.notifyDataSetChanged();
			sp3.setAdapter(cc6);
		}
		if(s2.contentEquals("Delhi")){        
			List<String> City=new ArrayList<String>();
			City.add("Delhi");
			City.add("Kirari Suleman Nagar");
			City.add("NDMC");
			City.add("Karawal Nagar");
			City.add("Nangloi Jat");
			City.add("Bhalswa Jahangir Pur");
			City.add("Sultan Pur Majra");
			City.add("Hastsal");
			City.add("Deoli");
			City.add("Dallo Pura");
			ArrayAdapter<String> cc7=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc7.notifyDataSetChanged();
			sp3.setAdapter(cc7);
		}
		if(s2.contentEquals("Goa")){
			List<String> City=new ArrayList<String>();
			City.add("Goa");
			ArrayAdapter<String> cc8=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc8.notifyDataSetChanged();
			sp3.setAdapter(cc8);
		}
		if(s2.contentEquals("Gujarat")){
			List<String> City=new ArrayList<String>();
			City.add("Ahmedabad");
					City.add("Surat");
					City.add("Vadodara");
					City.add("Rajkot");
					City.add("Bhavnagar");
					City.add("Jamnagar");
					City.add("Junagadh");
					City.add("Gandhidham");
					City.add("Nadiad");
					City.add("Gandhinagar");
			ArrayAdapter<String> cc9=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc9.notifyDataSetChanged();
			sp3.setAdapter(cc9);
		}
		if(s2.contentEquals("Haryana")){
			List<String> City=new ArrayList<String>();
			City.add("Faridabad");
			City.add("Gurgaon");
			City.add("Rohtak");
			City.add("Hisar");
			City.add("Panipat");
			City.add("Karnal");
			City.add("Sonipat");
			City.add("Yamunanagar");
			City.add("Panchkula");
			City.add("Bhiwani");
			ArrayAdapter<String> cc10=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc10.notifyDataSetChanged();
			sp3.setAdapter(cc10);
		}
		if(s2.contentEquals("Himachal Pradesh")){
			List<String> City=new ArrayList<String>();
			City.add("Shimla");
			City.add("Dharamshala");
			ArrayAdapter<String> cc15=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc15.notifyDataSetChanged();
			sp3.setAdapter(cc15);
		}
		if(s2.contentEquals("Jammu & Kashmir")){
			List<String> City=new ArrayList<String>();
			City.add(" Srinagar");
			City.add("Jammu");
			City.add("Anantnag");
			ArrayAdapter<String> cc11=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc11.notifyDataSetChanged();
			sp3.setAdapter(cc11);
		}
		if(s2.contentEquals("Jharkhand")){
			List<String> City=new ArrayList<String>();
			City.add("Dhanbad");
			City.add("Ranchi");
			City.add("Jamshedpur");
			City.add("Bokaro Steel");
			City.add("Mango");
			City.add("Deoghar");
			City.add("Adityapur");
			City.add("Hazaribag");
			City.add("Chas");
			City.add("Giridih");
			ArrayAdapter<String> cc12=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc12.notifyDataSetChanged();
			sp3.setAdapter(cc12);
		}
		if(s2.contentEquals("Karnataka")){
			List<String> City=new ArrayList<String>();
			City.add("Bangalore");
			City.add("Hubli and Dharwad");
			City.add("Mysore");
			City.add("Gulbarga");
			City.add("Mangalore");
			City.add("Belgaum");
			City.add("Davanagere");
			City.add("Bellary");
			City.add("Bijapur");
			City.add("Shimoga");
			ArrayAdapter<String> cc13=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc13.notifyDataSetChanged();
			sp3.setAdapter(cc13);
		}
		if(s2.contentEquals("Kerala")){
			List<String> City=new ArrayList<String>();
			City.add("Thiruvananthapuram");
			City.add("Kochi");
			City.add("Kozhikode");
			City.add("Kollam");
			City.add("Thrissur");
			City.add("Alappuzha");
			City.add("Palakkad");
			ArrayAdapter<String> cc14=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc14.notifyDataSetChanged();
			sp3.setAdapter(cc14);
		}
		if(s2.contentEquals("Lakshadweep")){
			List<String> City=new ArrayList<String>();
			City.add("Lakshadweep");
			ArrayAdapter<String> cc16=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc16.notifyDataSetChanged();
			sp3.setAdapter(cc16);
		}
		if(s2.contentEquals("Madhya Pradesh")){
			List<String> City=new ArrayList<String>();
			City.add("Indore");
			City.add("Bhopal");
			City.add("Gwalior");
			City.add("Jabalpur");
			City.add("Ujjain");
			City.add("Dewas");
			City.add("Satna");
			City.add("Sagar");
			City.add("Ratlam");
			City.add("Rewa");
			ArrayAdapter<String> cc17=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc17.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc17.notifyDataSetChanged();
			sp3.setAdapter(cc17);
		}
		if(s2.contentEquals("Maharashtra")){
			List<String> City=new ArrayList<String>();
			City.add("Mumbai");
			City.add("Pune");
			City.add("Nagpur");
			City.add("Thane");
			City.add("Pimpri and Chinchwad");
			City.add("Nashik");
			City.add("Kalyan and Dombivali");
			City.add("Vasai Virar");
			City.add("Aurangabad");
			City.add("Navi Mumbai");
			ArrayAdapter<String> cc18=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc18.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc18.notifyDataSetChanged();
			sp3.setAdapter(cc18);
}
		if(s2.contentEquals("Manipur")){
			List<String> City=new ArrayList<String>();
			City.add("Imphal");
			ArrayAdapter<String> cc19=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc19.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc19.notifyDataSetChanged();
			sp3.setAdapter(cc19);
		}
		if(s2.contentEquals("Meghalaya")){
			List<String> City=new ArrayList<String>();
			City.add("Shillong");
			ArrayAdapter<String> cc20=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc20.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc20.notifyDataSetChanged();
			sp3.setAdapter(cc20);
		}
		if(s2.contentEquals("Mizoram")){
			List<String> City=new ArrayList<String>();
			City.add("Aizawl");
			ArrayAdapter<String> cc21=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc21.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc21.notifyDataSetChanged();
			sp3.setAdapter(cc21);
		}
		if(s2.contentEquals("Nagaland")){
			List<String> City=new ArrayList<String>();
			City.add("Dimapur");
			ArrayAdapter<String> cc22=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc22.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc22.notifyDataSetChanged();
			sp3.setAdapter(cc22);
		}
		if(s2.contentEquals("Orissa")){
			List<String> City=new ArrayList<String>();
			City.add("Bhubaneswar");
			City.add("Cuttack");
			City.add("Brahmapur Town");
			City.add("Raurkela");
			City.add("Puri Town");
			City.add("Sambalpur");
			City.add("Baleshwar");
			City.add("Baripada");
			City.add("Bhadrak");
			ArrayAdapter<String> cc25=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc25.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc25.notifyDataSetChanged();
			sp3.setAdapter(cc25);
}
		if(s2.contentEquals("Punjab")){
			List<String> City=new ArrayList<String>();
			City.add("Ludhiana");
			City.add("Amritsar");
			City.add("Jalandhar");
			City.add("Patiala");
			City.add("Bathinda");
			City.add("Hoshiarpur");
			City.add("Batala"); 
			City.add("Moga");
			City.add("Pathankot");
			City.add("Mohali");
			ArrayAdapter<String> cc26=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc26.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc26.notifyDataSetChanged();
			sp3.setAdapter(cc26);
}
		if(s2.contentEquals("Puducherry")){
			List<String> City=new ArrayList<String>();
			City.add("Ozhukarai");
			City.add("Puducherry");
			ArrayAdapter<String> cc27=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc27.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc27.notifyDataSetChanged();
			sp3.setAdapter(cc27);
}
		if(s2.contentEquals("Rajasthan")){
			List<String> City=new ArrayList<String>();
			City.add("Jaipur");
			City.add("Jodhpur");
			City.add("Kota");
			City.add("Bikaner");
			City.add("Ajmer");
			City.add("Udaipur");
			City.add("Bhilwara");
			City.add("Alwar");
			City.add("Bharatpur");
			City.add("Sikar");
			ArrayAdapter<String> cc28=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc28.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc28.notifyDataSetChanged();
			sp3.setAdapter(cc28);
}
		if(s2.contentEquals("Sikkim")){
			List<String> City=new ArrayList<String>();
			City.add("Gangtok");
			ArrayAdapter<String> cc29=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc29.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc29.notifyDataSetChanged();
			sp3.setAdapter(cc29);
}
		if(s2.contentEquals("Tamil Nadu")){
			List<String> City=new ArrayList<String>();
			City.add("Chennai");
			City.add("Coimbatore");
			City.add("Madurai");
			City.add("Tiruchirappalli");
			City.add("Salem");
			City.add("Tirunelveli");
			City.add("Ambattur");
			City.add("Tiruppur");
			City.add("Avadi");
			City.add("Tiruvottiyur");
			ArrayAdapter<String> cc30=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc30.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc30.notifyDataSetChanged();
			sp3.setAdapter(cc30);
}
		if(s2.contentEquals("Tilangana")){
			List<String> City=new ArrayList<String>();
			City.add("Hyderabad");
			City.add("Nizamabad");
			City.add("Ramagundam");
			City.add("Khammam");
			City.add("Mahbubnagar");
			City.add("Nalgonda");
			City.add("Adilabad");
			City.add("Suryapet");
			ArrayAdapter<String> cc31=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc31.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc31.notifyDataSetChanged();
			sp3.setAdapter(cc31);
}
		if(s2.contentEquals("Tripura")){
			List<String> City=new ArrayList<String>();
			City.add("Agartala");
			ArrayAdapter<String> cc32=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc32.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc32.notifyDataSetChanged();
			sp3.setAdapter(cc32);
}
		if(s2.contentEquals("Uttar Pradesh")){
			List<String> City=new ArrayList<String>();
			City.add("Lucknow");
			City.add("Kanpur");
			City.add("Ghaziabad");
			City.add("Agra");
			City.add("Meerut");
			City.add("Varanasi");
			City.add("Allahabad");
			City.add("Bareilly");
			City.add("Moradabad");
			City.add("Aligarh");
			City.add("Jhansi");
			ArrayAdapter<String> cc33=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc33.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc33.notifyDataSetChanged();
			sp3.setAdapter(cc33);
}
		if(s2.contentEquals("Uttrakhand")){
			List<String> City=new ArrayList<String>();
			City.add("Dehradun");
			City.add("Hardwar");
			City.add("Haldwani and Kathgodam");
			City.add("Rudrapur");
			City.add("Kashipur");
			City.add("Roorkee ");
			ArrayAdapter<String> cc34=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc34.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc34.notifyDataSetChanged();
			sp3.setAdapter(cc34);
}
		if(s2.contentEquals("West Bengal")){
			List<String> City=new ArrayList<String>();
			City.add("Kolkata");
			City.add("Haora");
			City.add("Durgapur");
			City.add("Asansol");
			City.add("Siliguri");
			City.add("Maheshtala");
			City.add("Rajpur Sonarpur");
			City.add("South Dum Dum");
			City.add("Rajarhat Gopalpur");
			City.add("Bhatpara");
			ArrayAdapter<String> cc=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,City);
			cc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			cc.notifyDataSetChanged();
			sp3.setAdapter(cc);

		}
		//s3=parent.getItemAtPosition(position).toString();
		}
	}
		// TODO Auto-generated method stub
		
		
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
		
	 
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater=getMenuInflater();
		
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
	public void onClick(View arg0) {
		 name=e1.getText().toString();
         phone=e2.getText().toString();
         email=e3.getText().toString();
         area=e4.getText().toString();
         //s1=sp1.getSelectedItem().toString();
         //s2=sp2.getSelectedItem().toString();
         s3=sp3.getSelectedItem().toString().trim();
      
         url="http://www.studentspro.in/blood_donar/Registeration.php";
         
         new json().execute();
		
		String n=e1.getText().toString();
		String p=e2.getText().toString();
		String e=e3.getText().toString();
		String a=e4.getText().toString();
		SharedPreferences settings = getSharedPreferences(Register.PREFS_NAME, 0); // 0 - for private mode
		SharedPreferences.Editor edit = settings.edit();
		edit.putBoolean("hasLoggedIn", true);
		//sp=PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		//SharedPreferences.Editor edit=sp.edit();
		edit.putString(Name,n);
		edit.putString(Phone, p);
		edit.putString(Email, e);
		edit.putString(Area,a);
		
		edit.commit();
		
		 
		
		
		if (n.equals("") || p.equals("")
				|| e.equals("")) {
			if (n.equals("")) {
				Toast.makeText(Register.this, "ENTER NAME",
						Toast.LENGTH_SHORT).show();

			}
			if(p.equals("")) {
				Toast.makeText(Register.this, "ENTER PHONE NUMBER",
						Toast.LENGTH_SHORT).show();

			}
			if (e.equals("")) {
				Toast.makeText(Register.this, "ENTER EMAIL ID",
						Toast.LENGTH_SHORT).show();

			}
		   if(a.equals(""))
		{
		      Toast.makeText(Register.this, "ENTER AREA CODE", Toast.LENGTH_SHORT).show();
		}
		} else {
			
		
			if (!CheckName(n)) {
				Toast.makeText(Register.this, "ENTER VALID NAME",
						Toast.LENGTH_LONG).show();
			}
			if (!CheckPhone(p)) {
				Toast.makeText(Register.this, "ENTER VALID PHONE",
						Toast.LENGTH_LONG).show();
			}
			if (!CheckEmail(e)) {
				Toast.makeText(Register.this, "ENTER VALID EMAIL ID",
						Toast.LENGTH_LONG).show();
			}
			if (!CheckArea(a)) {
				Toast.makeText(Register.this, "ENTER VALID AREA CODE",
						Toast.LENGTH_LONG).show();
			
			}else{
				Intent i = new Intent(this, Find.class);
				i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			     startActivity(i);
			     finish();
			}
			}
		

	}
	private boolean CheckName(String n) {

		return NAME_PATTERN.matcher(n).matches();
	}
	private boolean CheckPhone(String p) {

		return PHONE_PATTERN.matcher(p).matches();
	}

	private boolean CheckEmail(String e) {

		return EMAIL_PATTERN.matcher(e).matches();
	}
	private boolean CheckArea(String a) {

		return AREA_PATTERN.matcher(a).matches();
	}
	/*@Override
	public void onResume(){
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
	    boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_started), false);
	    if(!previouslyStarted) {
	        SharedPreferences.Editor edit = prefs.edit();
	        edit.putBoolean(getString(R.string.pref_previously_started), Boolean.TRUE);
	        edit.commit();
	        showHelp();
	    }
	}*/
		
	class json extends AsyncTask<Void, Void, Void>
    {
        ProgressDialog dialog;
                int code;
        @Override
        protected void onPostExecute(Void result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            
            
            try{
            	
            	dialog.dismiss();
            JSONObject json_data = new JSONObject(Incoming_json);
                        code=Integer.parseInt(json_data.getString("code"));
            
                         if(code==1)
                         {
                      Toast.makeText(getBaseContext(), "Inserted Successfully",
                   Toast.LENGTH_LONG).show();
                         }
                          else
                           {
                 Toast.makeText(getBaseContext(), "Sorry, Try Again",Toast.LENGTH_LONG).show();
                            }
                                
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            
            
            
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            dialog=new ProgressDialog(Register.this);
            dialog.setCancelable(false);
            dialog.setMessage("Loading .  .  .");
            dialog.show();
            
        }

        @Override
        protected Void doInBackground(Void... params) {
            // TODO Auto-generated method stub
            Incoming_json = getjson();
            
            return null;
            
        }
        
    }
    
    public String getjson()
    {
        
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
         
          nameValuePairs.add(new BasicNameValuePair("name",name));
          nameValuePairs.add(new BasicNameValuePair("phone",phone));
          nameValuePairs.add(new BasicNameValuePair("email",email));
          nameValuePairs.add(new BasicNameValuePair("area",area));
          nameValuePairs.add(new BasicNameValuePair("s1",s1));
          nameValuePairs.add(new BasicNameValuePair("s2",s2));
          nameValuePairs.add(new BasicNameValuePair("s3",s3));
          
          StringBuilder sb = new StringBuilder();
           try
           {
               HttpClient httpclient = new DefaultHttpClient();
               HttpPost httppost = new HttpPost(url);
              
               httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"utf-8"));
               
               HttpResponse response = httpclient.execute(httppost); 
               HttpEntity entity = response.getEntity();
               is = entity.getContent();
               Log.e("pass 1", "connection success ");
        }
           catch(Exception e)
        {
               Log.e("Fail 1", e.toString());
               Toast.makeText(getApplicationContext(), "Invalid IP Address",
                Toast.LENGTH_LONG).show();
        }     
           
           try
           {
               BufferedReader reader = new BufferedReader
                (new InputStreamReader(is,"iso-8859-1"),8);
               
               while ((line = reader.readLine()) != null)
           {
                   sb.append(line + "\n");
               }
               is.close();
               result = sb.toString();
           Log.e("pass 2", "connection success ");
        }
           catch(Exception e)
        {
               Log.e("Fail 2", e.toString());
        }
            return sb.toString();     
              }



        
    }