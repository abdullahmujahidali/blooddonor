package com.example.blooddonarapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

public class OptionMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_option_menu);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.option_menu, menu);
		return true;
	
	}
	@Override 
    public boolean onOptionsItemSelected(MenuItem item){
   	 int id=item.getItemId();
   	switch(id){
  	 case R.id.item1:
  		return true;
  	 case R.id.item2:
  		return true;
  	 case R.id.item3:
  		return true;
  	case R.id.item4:
 	     return true;
  	case R.id.item5:
  		return true;
   	}
		return super.onOptionsItemSelected(item);
	}

}

