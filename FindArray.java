package com.example.blooddonarapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FindArray extends ArrayAdapter<String> {
	String [] list;
    TextView tv1,tv2;
    Context con;

	public FindArray(Context context) {
		super(context,R.layout.findarray);
		con=context;
		// TODO Auto-generated constructor stub
	}
@Override
public View getView(int position,View convertView,ViewGroup parent){
	LayoutInflater inflater=LayoutInflater.from(getContext());
	View view=inflater.inflate(R.layout.activity_donar_list_array, parent,false);
	
	String singleItem=getItem(position);
	tv1=(TextView)view.findViewById(R.id.textView1);
	tv2=(TextView)view.findViewById(R.id.textView2);
	tv1.setText(singleItem);
	tv2.setText(singleItem);
	return view;
	
}

}
