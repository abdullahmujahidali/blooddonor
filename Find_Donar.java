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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Find_Donar extends Fragment implements OnClickListener {
	Button b1,b2,b3;
	Spinner sp,sp1;
	String[] BloodGroup={"O+","O-","A+","A-","A1+","A2+","A1-","A2-","B+","B-","AB+","AB-","A1B+","A2B+","A1B-",
	"A2B-"};
	String [] City={"Adilabad","Adityapur","Agartala",
			"Agra","Ahmedabad","Aizawl","Ajmer","Alappuzha","Aligarh"
			,"Allahabad","Alwar","Ambattur","Ambikapur","Amritsar","Anantnag",
			"Anjaw","Arrah","Asansol","Aurangabad","Avadi","Baleshwar","Bangalore",
			"Bareilly","Baripada","Batala","Bathinda","Begusarai","Belgaum","Bellary","Bhadrak",
			"Bhagalpur","Bhalswa Jahangir Pur","Bharatpur","Bhatpara","Bhavnagar","Bhilai Nagar",
			"Bhilwara","Bhiwani","Bhopal","Bhubaneswar","Biharsharif","Bijapur","Bikaner","Bilaspur",
			"Bokaro Steel","Brahmapur Town","Chandigarh","Changlang","Chas","Chennai","Coimbatore",
			"Cuttack","Dallo Pura","Darbhanga","Davanagere","Dehradun","Delhi","Deoghar","Deoli","Dewas"
			,"Dhanbad","Dharamshala","Dibang Valley","Dibrugarh","Dimapur","Durg","Durgapur","East Kameng"
			,"East Siang","Faridabad","Gandhidham","Gandhinagar","Gangtok","Gaya","Ghaziabad","Giridih",
			"Goa","Gulbarga","Guntur","Gurgaon","Guwahati","Gwalior","Haldwani and Kathgodam","Haora",
			"Hardwar","Hastsal","Hazaribag","Hisar","Hoshiarpur","Hubli and Dharwad","Hyderabad","Hyderabad"
			,"Imphal","Indore","Jabalpur","Jagdalpur","Jaipur","Jalandhar","Jammu","Jamnagar","Jamshedpur"
			,"Jhansi","Jodhpur","Junagadh","Kadapa","Kakinada","Kalyan and Dombivali","Kanpur",
			"Karawal Nagar","Karnal","Kashipur","Katihar","Khammam","Kirari Suleman Nagar","Kochi",
			"Kolkata","Kollam","Korba","Kota","Kozhikode","Kurnool","Kurung Kumey","Lakshadweep","Lohit"
			,"Lower Dibang Valley","Lower Subansiri","Lucknow","Ludhiana","Madurai","Mahbubnagar",
			"Maheshtala","Mangalore","Mango","Meerut","Moga","Mohali","Moradabad","Mumbai","Muzaffarpur"
			,"Mysore","NDMC","Nadiad","Nagaon","Nagpur","Nalgonda","Nangloi Jat","Nashik","Navi Mumbai",
			"Nellore","Nizamabad","Ozhukarai","Palakkad","Panchkula","Panipat","Papumpare","Pathankot"
			,"Patiala","Patna","Pimpri and Chinchwad","Port Blair","Puducherry","Pune","Puri Town","Purnia"
			,"Raigarh","Raipur","Rajahmundry","Rajarhat Gopalpur","Rajkot","Rajnandgaon","Rajpur Sonarpur",
			"Ramagundam","Ranchi","Ratlam","Raurkela","Rewa","Rohtak","Roorkee","Rudrapur","Sagar","Salem",
			"Sambalpur","Satna","Shillong","Shimla","Sri Nagar","Shimoga","Sikar","Silchar","Siliguri",
			"Silvassa","Sonipat","South Dum Dum","Sultan Pur Majra","Surat","Suryapet","Tawang","Thane",
			"Thiruvananthapuram","Thrissur","Tirap","Tiruchirappalli","Tirunelveli","Tiruppur","Tiruvottiyur","Udaipur","Ujjain"
			,"Upper Siang","Upper Subansiri",
			"Vadodara","Varanasi","Vasai Virar","Vijayawada",
			"Visakhapatnam","Warangal","West Kameng","West Siang","Yamunanagar"};
	
	String s1,s2;
	TextView t1;
	
	@Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
	      Bundle savedInstanceState) {
		View rootView=inflater.inflate(R.layout.find_donar, container, false);
		b1=(Button)rootView.findViewById(R.id.button1);
		b2=(Button)rootView.findViewById(R.id.button2);
		b3=(Button)rootView.findViewById(R.id.button3);
		sp=(Spinner)rootView.findViewById(R.id.spinner1);
		sp1=(Spinner)rootView.findViewById(R.id.spinner2);
		t1=(TextView)rootView.findViewById(R.id.textView1);
		t1.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "Fonts/ARCENA.ttf"));
		ActionBar actionBar = getActivity().getActionBar();
	    //actionBar.setBackgroundDrawable(new ColorDrawable(Color.RED));
	    actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FA5858")));
		ArrayAdapter<String> aa= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,BloodGroup);
	    aa.setDropDownViewResource(android.R.layout.simple_spinner_item);
	    sp.setAdapter(aa);
	    sp.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				s1=parent.getItemAtPosition(position).toString().trim();
				Toast.makeText(getActivity(), "Selected Blood Group: " + s1, Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
	    	
	    });
	    ArrayAdapter<String> bb= new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,City);
	    bb.setDropDownViewResource(android.R.layout.simple_spinner_item);
	    sp1.setAdapter(bb);
	    sp1.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				s2=parent.getItemAtPosition(position).toString().trim();
				Toast.makeText(getActivity(), "Selected City:" +s2, Toast.LENGTH_SHORT).show();
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
	    	
	    });

		      b1.setOnClickListener(this);
		
		       b2.setOnClickListener(this);
		      // b3.setOnClickListener(this);
		       
		       b3.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					Intent intent=new Intent((getActivity().getBaseContext()),FindByBloodnCity.class);
					intent.putExtra("s1", s1);
					intent.putExtra("s2", s2);
					startActivity(intent);
					
					// TODO Auto-generated method stub
					
				}
		    	   
		       });
			return rootView;
			
			
	}



	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.button1:
			Intent i=new Intent((getActivity().getBaseContext()), SelectCity.class);
			startActivity(i);
			break;
		case R.id.button2:
			Intent in=new Intent((getActivity().getBaseContext()),Find_ByBloodGroup.class);
			startActivity(in);
			break;
		/*case R.id.button3:
			
			Intent intent=new Intent((getActivity().getBaseContext()),FindByBloodnCity.class);
			intent.putExtra("Blood", s1);
			intent.putExtra("City", s2);
			startActivity(intent);
			break;*/
			
		 
		}
		
		// TODO Auto-generated method stub
		
	}

}
