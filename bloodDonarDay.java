package com.example.blooddonarapp;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class bloodDonarDay extends Fragment {
	
	TextView tv,tv1;
	ScrollView s1;
	@Override
    public View onCreateView(LayoutInflater inflater, 
    ViewGroup container, Bundle savedInstanceState) {
		Log.d("Fragment 2", "onCreateView");
		View view=inflater.inflate(R.layout.blooddonarday, container, false);
		tv=(TextView)view.findViewById(R.id.textview1);
		tv1=(TextView)view.findViewById(R.id.textView2);
		s1=(ScrollView)view.findViewById(R.id.scrollView1);
		
		//tv.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "Fonts/ARCENA.ttf"));
		tv1.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "Fonts/ARCENA.ttf"));
        //---Inflate the layout for this fragment---
        return inflater.inflate(
            R.layout.blooddonarday, container, false);
    }
    



}
