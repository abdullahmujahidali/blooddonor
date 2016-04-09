package com.example.blooddonarapp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.blooddonarapp.NavigationBar.DrawerItemClickListener;


import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class DonarsList extends Activity implements OnItemClickListener, AbsListView.OnScrollListener {
	DrawerLayout dl;
	ListView lv;
	ActionBarDrawerToggle dt;
	
	CharSequence mDrawerTitle;
    CharSequence mTitle;
	CustomDrawerAdapter adapter;

	List<DrawerItem> dataList;
	int pos;
	String [] listad;
	Context con;
    
    String[] NAME;
    String[] PHONE_NUMBER;
    String c1;
    
    InputStream is=null;
    String result=null;
    String line=null;
    String incoming_json;
    ArrayAdapter<String> ar;
    ArrayList<String> names=new ArrayList<String>();
    Intent i;
    ImageButton ib,ib1,ib2;
    ListView list;
    DonarListArray dla ;
    String s1;
    String st;
    private int lastTopValue = 0;
    private ImageView backgroundImage;


    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_donars_list);
        //super.onCreateDrawer();


        
        
        ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FA5858")));
		ib=(ImageButton)findViewById(R.id.imageButton1);
		
    
            
	ib.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(DonarsList.this,MakeANote.class);
				startActivity(i);
			}
		});
	 LayoutInflater inflater = getLayoutInflater();
     ViewGroup header = (ViewGroup) inflater.inflate(R.layout.framelayout, list, false);
     list.addHeaderView(header, null, false);

     // we take the background image and button reference from the header
     backgroundImage = (ImageView) header.findViewById(R.id.imageView1);
     list.setOnScrollListener(this);
			
		list=(ListView)findViewById(R.id.listView1);
		list.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				TextView tv2=(TextView)view.findViewById(R.id.textView2);
				s1=tv2.getText().toString();
				Toast.makeText(DonarsList.this,s1, Toast.LENGTH_SHORT).show();
				//s1=(String)parent.getItemAtPosition(position);
				
	          Intent i =new Intent(DonarsList.this,CallOrSms.class);
	           i.putExtra("s1", s1);
	           startActivity(i);
	            
				
				// TODO Auto-generated method stub
				
			}});
		i=getIntent();
		c1=i.getStringExtra("city");
        new json().execute();
    }
    class json extends AsyncTask<Void, Void, Void> {
		ProgressDialog dialog;
	    int code;
	@Override
	protected void onPreExecute() {
	super.onPreExecute();
	dialog=new ProgressDialog(DonarsList.this);
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
	for(int i=0;i<names.size();i++)
	{
			Log.d("hhhhhhhhhh",names.get(i));
	}	list= (ListView)findViewById(R.id.listView1);
		//dla=new DonarListArray(DonarsList.this,NAME,PHONE_NUMBER);
		  dla = new DonarListArray(DonarsList.this,names);
		  list.setAdapter(dla);
		
		}catch(Exception e)
		{
		e.printStackTrace();
		}
		}


		private ArrayList<String> selectdata() {
			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			 nameValuePairs.add(new BasicNameValuePair("c1",c1));
	         
	         
		  try
		      {
		HttpClient httpclient = new DefaultHttpClient();
		        HttpPost httppost = new HttpPost("http://www.studentspro.in/blood_donar/blooddonard.php");
		
		        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"utf-8"));
		        HttpResponse response = httpclient.execute(httppost);
		        HttpEntity entity = response.getEntity();
		        result = EntityUtils.toString(entity);
		        Log.e("pass 2", "connection success "+result);
		        
		       
		}
		      catch(Exception e)
		{
		          Log.e("Fail 1", e.toString());
		        //Toast.makeText(getActivity().this, "Invalid IP Address",
		//Toast.LENGTH_LONG).show();
		}

		    

		     try
		      {

		     JSONArray jArray = new JSONArray(result);

		     for(int i=0; i<jArray.length();i++)
		     {
		     JSONObject json = jArray.getJSONObject(i);
		       //id=Integer.parseInt((json.getString("id")));
		      // name=json.getString("name");
		        names.add(json.getString("NAME")+"-"+json.getString("PHONE_NUMBER"));
		          
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
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		Rect rect = new Rect();
        backgroundImage.getLocalVisibleRect(rect);
        if (lastTopValue != rect.top) {
            lastTopValue = rect.top;
            backgroundImage.setY((float) (rect.top / 2.0));
        }
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onScrollStateChanged(AbsListView arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

}
			


		