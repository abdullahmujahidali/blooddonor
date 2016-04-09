package com.example.blooddonarapp;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AnalogClock;
import android.widget.Button;

public class Find_BloodBank extends Fragment implements OnClickListener {
     Button b1,b2;
	@Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
		View heapView=inflater.inflate(R.layout.find_bloodbank, container,false);
		b1=(Button)heapView.findViewById(R.id.button1);
		b1.setOnClickListener(this);
        b2=(Button)heapView.findViewById(R.id.button2);
		b2.setOnClickListener(this);
		ActionBar actionBar = getActivity().getActionBar();
	    //actionBar.setBackgroundDrawable(new ColorDrawable(Color.RED));
	    actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FA5858")));
				
			
			return heapView;
}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case(R.id.button1):
		Intent i=new Intent((getActivity().getBaseContext()),FindByCity.class);
		startActivity(i);
		break;
		case(R.id.button2):
			Intent j=new Intent((getActivity().getBaseContext()),FindBloodTestCenters.class);
		startActivity(j);
			break;
			default:
				break;
		// TODO Auto-generated method stub
		
	}
	}}
