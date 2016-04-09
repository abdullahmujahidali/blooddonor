package com.example.blooddonarapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ViewFlipper;

public class FragmentThree extends Fragment {
	
	
	ViewFlipper viewFlipper;
	ImageButton Next, Previous;
	public static final String ITEM_NAME = null;
	public static final String IMAGE_RESOURCE_ID = null;

	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
	    setHasOptionsMenu(true);
	    View view=inflater.inflate(R.layout.fragmentthree,container,false);
        viewFlipper = (ViewFlipper) view.findViewById(R.id.viewFlipper1);
        
        Next = (ImageButton) view.findViewById(R.id.imageButton1);
        Previous = (ImageButton) view.findViewById(R.id.imageButton2);
        
        Next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewFlipper.showNext();
				// TODO Auto-generated method stub
				
			}
		});
        Previous.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				viewFlipper.showPrevious();
				// TODO Auto-generated method stub
				
			}
		});
		return view;
	}
		
	}


