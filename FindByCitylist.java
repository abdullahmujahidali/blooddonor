package com.example.blooddonarapp;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import com.example.blooddonarapp.DonarsList.json;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class FindByCitylist extends Activity {
	int pos;
	String [] listad;
	Context con;
	String c1;
    Intent in;
    
    String name;
    String phone;
    InputStream is=null;
    String result=null;
    String line=null;
    String incoming_json;
    ArrayAdapter<String> ar;
    ArrayList<String> names=new ArrayList<String>();
     
	ListView list;
    FindByCityArray fbc ;
    ImageButton ib;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_find_by_citylist);
		ib=(ImageButton)findViewById(R.id.imageButton1);
		ib.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(FindByCitylist.this,MakeANote.class);
				startActivity(i);
			}
			
		});
		ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FA5858")));
		in=getIntent();
		c1=in.getStringExtra("city");
		 new json().execute();
	}
	 class json extends AsyncTask<Void, Void, Void> {
			ProgressDialog dialog;
		    int code;
		    @Override
			protected void onPreExecute() {
			super.onPreExecute();
			dialog=new ProgressDialog(FindByCitylist.this);
			dialog.setCancelable(false);
			dialog.setMessage("Loading .  .  .");
			dialog.show();
			}

			@Override
			protected Void doInBackground(Void... params) {
				names=selectdata();
				return null;
			
			}
			@Override
			protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			dialog.dismiss();
			try{
				Toast.makeText(getApplicationContext(), names.get(0),Toast.LENGTH_LONG).show();
			Log.d("hhhhhhhhhh",names.get(0));
			list= (ListView)findViewById(R.id.listView1);
			  fbc = new FindByCityArray(FindByCitylist.this,names);
			  list.setAdapter(fbc);
			
			}catch(Exception e)
			{
			e.printStackTrace();
			}
			}

			private ArrayList<String> selectdata() {
				// TODO Auto-generated method stub
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("c1",c1));
		         // nameValuePairs.add(new BasicNameValuePair("name",name));
		         // nameValuePairs.add(new BasicNameValuePair("phone",phone));
			  try
			      {
			HttpClient httpclient = new DefaultHttpClient();
			        HttpPost httppost = new HttpPost("http://www.studentspro.in/blood_donar/bloodbanks.php");
			
			        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"utf-8"));
			        HttpResponse response = httpclient.execute(httppost);
			        HttpEntity entity = response.getEntity();
			        is = entity.getContent();
			        Log.e("pass 1", "connection success ");
			}
			      catch(Exception e)
			{
			          Log.e("Fail 1", e.toString());
			        //Toast.makeText(getActivity().this, "Invalid IP Address",
			//Toast.LENGTH_LONG).show();
			}

			      try
			      {
			           BufferedReader reader = new BufferedReader(new
			InputStreamReader(is,"iso-8859-1"),8);
			              StringBuilder sb = new StringBuilder();
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

			     try
			      {

			     JSONArray jArray = new JSONArray(result);

			     for(int i=0; i<jArray.length();i++)
			     {
			     JSONObject json = jArray.getJSONObject(i);
			       //id=Integer.parseInt((json.getString("id")));
			      // name=json.getString("name");
			        names.add(json.getString("blood_banks")+"-"+json.getString("phone_numbers"));
			          //names.add((json.getString("phone_numbers")));

			         }

			      }
			      catch(Exception e)
			      {
			          Log.e("Fail 3", e.toString());
			      }
			     return names;
			  
			}
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
   