package com.example.blooddonarapp;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FindByBloodGroupArray extends ArrayAdapter<String> {
	View cview;
    TextView tv1,tv2;
    Context con;
   ArrayList<String> x,y;

	public FindByBloodGroupArray(Context context, ArrayList<String>arr) {
		super(context, R.layout.findbybloodgrouparray,arr);
		con=context;
		x=arr;
		// TODO Auto-generated constructor stub
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflator=(LayoutInflater)con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		cview=inflator.inflate(R.layout.findbybloodgrouparray, null);
		tv1=(TextView)cview.findViewById(R.id.textView1);
		tv2=(TextView)cview.findViewById(R.id.textView2);
		tv1.setText(x.get(position).split("-")[0]);
		tv2.setText(x.get(position).split("-")[1]);
	
		
		return cview;
	}

}



