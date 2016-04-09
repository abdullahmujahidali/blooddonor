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

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class DonarListArray extends ArrayAdapter<String> {
	//Context con;
	
	
	LayoutInflater inflater;
	
    String names;
    String phone;
    
    
    
	ArrayList<String> x;

	public DonarListArray(Context context, ArrayList<String> names) {
		
		super(context,R.layout.activity_donar_list_array,names);
		
		inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		x = names;
	}
	@Override
	 
	public int getCount() {
	 
	return x.size();
	 
	}
	 
	@Override
	 
	public long getItemId(int position) {
	 
	return position;
	 
	}
	@Override
	 
	public View getView(int position, View convertView, ViewGroup parent) {
		
	 
	ViewHolder listViewHolder;
	if(convertView == null){
		 
		listViewHolder = new ViewHolder();
		 
		convertView = inflater.inflate(R.layout.activity_donar_list_array, parent, false);
		 
		listViewHolder.tv1 = (TextView)convertView.findViewById(R.id.textView1);
		 
		listViewHolder.tv2 = (TextView)convertView.findViewById(R.id.textView2);
		
		
		convertView.setTag(listViewHolder);
		 
	}else{
		 
		listViewHolder = (ViewHolder)convertView.getTag();
		 
		}
	    
		listViewHolder.tv1.setText(x.get(position).split("-")[0]);
		listViewHolder.tv2.setText(x.get(position).split("-")[1]);
		
		//listViewHolder.tv1.setText("Name: " + x.get(position).getName());
		 
		//listViewHolder.tv2.setText("Phone: " + x.get(position).getPhone());
		return convertView;
		 
	}
	static class ViewHolder{
	 
	TextView tv1;
	 
	TextView tv2;
	}
}
class Item{
	private String tv1;
	private String tv2;
	
	public Item(String tv1, String tv2){
		this.tv1 = tv1;
		this.tv2 = tv2;
	
}

public String getName() {
	return tv1;
	}
public void setName(String Name) {
	this.tv1 = tv1;
	
	}
public String getPhone() {
	return tv2;
	}
public void setPhone(String Phone) {
	this.tv2 = tv2;
	
	}
}


	
    