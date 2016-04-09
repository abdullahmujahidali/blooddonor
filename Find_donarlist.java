package com.example.blooddonarapp;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class Find_donarlist extends Activity {
	ListView list;
	FindArray fa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find_donarlist);
		ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FA5858")));
		list= (ListView)findViewById(R.id.listView1);
		LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.find_donarlistheader, list,
                false);
        list.addHeaderView(header, null, false);
        fa=new FindArray(this);
        list.setAdapter(fa);
        list.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
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



