package com.example.blooddonarapp;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentOne extends Fragment implements OnClickListener {
	EditText e1,e2,e3;
	TextView t1;
	Button b1;
	public static final String ITEM_NAME = null;
	public static String IMAGE_RESOURCE_ID=null;

	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
	    setHasOptionsMenu(true);
	    View fragmentOneView=inflater.inflate(R.layout.fragmentone,container,false);
	    
	    e1 = (EditText) fragmentOneView.findViewById(R.id.editText1);
	    e2 = (EditText) fragmentOneView.findViewById(R.id.edittext2);
	    e3= (EditText) fragmentOneView.findViewById(R.id.edittext3);
	    t1= (TextView) fragmentOneView.findViewById(R.id.textview1);
	    //t1.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "Fonts/FTLTLT.TTF"));
	    b1 = (Button) fragmentOneView.findViewById(R.id.button1);
	    b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sendEmail();
				e1.setText("");
                e2.setText("");
                e3.setText("");
     }

			private void sendEmail() {
				String[] recipients = {e1.getText().toString()};
			    Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
			    email.setType("message/rfc822");
			    email.putExtra(Intent.EXTRA_EMAIL, recipients);
		        email.putExtra(Intent.EXTRA_SUBJECT, e2.getText().toString());
		        email.putExtra(Intent.EXTRA_TEXT, e3.getText().toString());

		        try {
		        	startActivity(Intent.createChooser(email, "Choose an email client from..."));
		        } catch (android.content.ActivityNotFoundException ex) {
		        	 Toast.makeText(FragmentOne.this.getActivity(), "No email clients installed on device!", Toast.LENGTH_LONG).show();
		        }
		        	      }
			
				// TODO Auto-generated method stub

				// TODO Auto-generated method stub
				
			
     });
		return fragmentOneView;

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	}

		

        	
