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

public class FindByCity extends Activity {
	
	ListView l;
	EditText e1;
	ImageButton ib;
	String s1;
	ArrayAdapter<String> adapter;
	
	String [] City={"Hyderabad","Visakhapatnam","Vijayawada","Guntur","Warangal","Nellore",
			"Kurnool","Kadapa","Rajahmundry","Kakinada","Port Blair","Papumpare"
	,"Changlang","Lohit","West Siang","Tirap","East Siang","Kurung Kumey","West Kameng","Upper Subansiri",
	"Lower Subansiri","East Kameng","Lower Dibang Valley","Tawang","Upper Siang","Anjaw","Dibang Valley"
	,"Guwahati","Silchar","Dibrugarh","Nagaon","Patna","Gaya","Bhagalpur","Muzaffarpur","Biharsharif","Darbhanga","Purnia","Arrah"
	,"Begusarai","Katihar","Chandigarh","Raipur","Bhilai Nagar","Korba"
	,"Bilaspur","Durg","Rajnandgaon","Raigarh","Jagdalpur"
	,"Ambikapur","Silvassa","Delhi","Kirari Suleman Nagar"
	,"NDMC","Karawal Nagar","Nangloi Jat","Bhalswa Jahangir Pur","Sultan Pur Majra","Hastsal","Deoli","Dallo Pura","Goa",
	"Ahmedabad","Surat","Vadodara","Rajkot","Bhavnagar","Jamnagar","Junagadh","Gandhidham","Nadiad","Gandhinagar","Faridabad","Gurgaon","Rohtak","Hisar"
	,"Panipat","Karnal","Sonipat","Yamunanagar","Panchkula","Bhiwani","Shimla","Dharamshala"," Srinagar","Jammu","Anantnag"
	,"Dhanbad","Ranchi","Jamshedpur","Bokaro Steel","Mango","Deoghar","Adityapur","Hazaribag","Chas"
	,"Giridih","Bangalore","Hubli and Dharwad","Mysore","Gulbarga","Mangalore","Belgaum","Davanagere","Bellary","Bijapur","Shimoga",
	"Thiruvananthapuram","Kochi","Kozhikode","Kollam","Thrissur","Alappuzha","Palakkad"
	,"Lakshadweep","Jhansi","Indore","Bhopal","Gwalior","Jabalpur","Ujjain",
	"Dewas","Satna","Sagar","Ratlam","Rewa","Mumbai","Pune","Nagpur","Thane","Pimpri and Chinchwad",
			"Nashik","Kalyan and Dombivali","Vasai Virar","Aurangabad","Navi Mumbai","Imphal","Shillong",
	"Aizawl","Dimapur","Bhubaneswar","Cuttack","Brahmapur Town","Raurkela","Puri Town","Sambalpur","Baleshwar","Baripada","Bhadrak","Ludhiana",
			"Amritsar","Jalandhar","Patiala","Bathinda","Hoshiarpur","Batala","Moga","Pathankot","Mohali","Ozhukarai","Puducherry","Jaipur","Jodhpur",
		"Kota","Bikaner","Ajmer","Udaipur","Bhilwara","Alwar","Bharatpur","Sikar","Gangtok","Chennai","Coimbatore","Madurai",
		"Tiruchirappalli","Salem","Tirunelveli","Ambattur","Tiruppur","Avadi","Tiruvottiyur",
		"Hyderabad","Nizamabad","Ramagundam","Khammam","Mahbubnagar","Nalgonda","Adilabad"
				,"Suryapet","Agartala","Lucknow","Kanpur","Ghaziabad","Agra",
						"Meerut","Varanasi","Allahabad","Bareilly","Moradabad","Aligarh"
		,"Dehradun","Hardwar","Haldwani and Kathgodam","Rudrapur","Kashipur",
		"Roorkee","Kolkata","Haora","Durgapur","Asansol","Siliguri","Maheshtala"
		,"Rajpur Sonarpur","South Dum Dum","Rajarhat Gopalpur","Bhatpara"};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				//WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_find_by_city);
		l=(ListView)findViewById(R.id.listView1);
		e1=(EditText)findViewById(R.id.editText1);
		ib=(ImageButton)findViewById(R.id.imageButton1);
		ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FA5858")));
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,City);
        l.setAdapter(adapter);
        ib.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(FindByCity.this,MakeANote.class);
				startActivity(i);
			}
			
		});
	    
        l.setOnItemClickListener(new OnItemClickListener(){
        	@Override
        	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        		s1=l.getItemAtPosition(position).toString();
        		Intent in=new Intent(FindByCity.this,FindByCitylist.class);
        		in.putExtra("city", s1);
        		startActivity(in);
        		
        		
        		// TODO Auto-generated method stub
        		
        	}
        });

			

	   // l.setAdapter(adapter);
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
				FindByCity.this.adapter.getFilter().filter(s);
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
  		startActivity(new Intent(this,Click_Photo.class));
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
