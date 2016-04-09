package com.example.blooddonarapp;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class FindBloodTestArray extends ArrayAdapter<String> {
	View cview;
    TextView tv1,tv2;
    Context con;
   ArrayList<String> x,y;
    public FindBloodTestArray(Context context,ArrayList<String> arr) {
		super(context, R.layout.findbloodtestarray,arr);
		con=context;
		x=arr;
    }

	@Override
	public View getView(int position,View convertView,ViewGroup parent){
		LayoutInflater inflater=(LayoutInflater)con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		cview=inflater.inflate(R.layout.findbloodtestarray, null);
		
		String singleItem=getItem(position);
		tv1=(TextView)cview.findViewById(R.id.textView1);
		tv2=(TextView)cview.findViewById(R.id.textView2);
		tv1.setText(x.get(position).split("-")[0]);
		tv2.setText(x.get(position).split("-")[1]);
		return cview;
}

	@Override
	public int getCount()
	{
	   return x.size();
	}
}
	/*@Override
	public String getItem (int pos){
	     return x.get(pos);
	}
}
*/

