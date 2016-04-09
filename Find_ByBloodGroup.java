package com.example.blooddonarapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

public class Find_ByBloodGroup extends Activity {
	ListView l;
	EditText e1;
	ImageButton ib;
	String s1;
	ArrayAdapter<String> adapter;
	String [] BloodGroup={"O+","O-","A+","A-","A1+","A2+","A1-","A2-","B+","B-",
			"AB+","AB-","A1B+","A2B+","A1B-",
	"A2B-"};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				//WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_find__by_blood_group);
		//setContentView(R.layout.activity_select_city);
		l=(ListView)findViewById(R.id.listView1);
		e1=(EditText)findViewById(R.id.editText1);
		ib=(ImageButton)findViewById(R.id.imageButton1);
		ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FA5858")));
		
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,BloodGroup);
        l.setAdapter(adapter);
        ib.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Find_ByBloodGroup.this,MakeANote.class);
				startActivity(i);
			}
			
		});
	    
        l.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				s1=l.getItemAtPosition(position).toString();
				
				Intent i=new Intent(Find_ByBloodGroup.this,FindByBloodGList.class);
				i.putExtra("bloodg", s1);
				startActivity(i);
				// TODO Auto-generated method stub
				
			}
        	
        });
        
	    e1.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				Find_ByBloodGroup.this.adapter.getFilter().filter(s);
				// TODO Auto-generated method stub
				
			
	}
	    });

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
	  		startActivity(new Intent(this,HelpLine.class));
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