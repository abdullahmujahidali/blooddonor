package com.example.blooddonarapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentTwo extends Fragment implements OnClickListener {
	ListView lv;
	EditText et1,et2;
	Button b1;
	

	public static final String ITEM_NAME = null;
	public static final String IMAGE_RESOURCE_ID = null;
	String[] SavedFiles;

	
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
	    setHasOptionsMenu(true);
	    View fragmentTwoView=inflater.inflate(R.layout.fragmenttwo,container,false);
	    lv=(ListView)fragmentTwoView.findViewById(R.id.listView1);
	    et1=(EditText)fragmentTwoView.findViewById(R.id.editText1);
	    et2=(EditText)fragmentTwoView.findViewById(R.id.editText2);
	    b1=(Button)fragmentTwoView.findViewById(R.id.button1);
	    
	    final ArrayList<String> recordlist=new ArrayList<String>();
	    final ArrayAdapter<String> aa;
	    aa=new ArrayAdapter<String>(fragmentTwoView.getContext(),android.R.layout.simple_list_item_1,recordlist);
	    lv.setAdapter(aa);
	   
	    ShowSavedFiles();
	    b1.setOnClickListener(new Button.OnClickListener(){
	    	@Override
	    	   public void onClick(View arg0) {
    
	/*public void onClick(View arg0) {
		
		/recordlist.add(0,et1.getText().toString());
		aa.notifyDataSetChanged();
		et1.setText("");
		// TODO Auto-generated method stub
		
	}
});*/
	    	String fileName = et1.getText().toString();
	        String content = et2.getText().toString();
	        
	        FileOutputStream fos;
	        try {
	         fos =  getActivity().getApplicationContext().openFileOutput(fileName, Context.MODE_PRIVATE);
	         fos.write(content.getBytes());
	         fos.close();
	         
	         Toast.makeText(
	           FragmentTwo.this.getActivity(),
	           fileName + " saved",
	           Toast.LENGTH_LONG).show();
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	           } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	           }
	           
	           ShowSavedFiles();
	           
	          }});
	           
	           lv.setOnItemClickListener(listSavedFilesOnItemClickListener);
			return fragmentTwoView;
	           
	          }
		
		void ShowSavedFiles() {
			SavedFiles = getActivity().getApplicationContext().fileList();
		    ArrayAdapter<String> adapter
		    = new ArrayAdapter<String>(FragmentTwo.this.getActivity(),
		      android.R.layout.simple_list_item_1,
		      SavedFiles);

		    lv.setAdapter(adapter);
		   }
		  
		   OnItemClickListener listSavedFilesOnItemClickListener
		   = new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				 String clickedFile = (String) parent.getItemAtPosition(position);
				    OpenFileDialog(clickedFile);
				   }
				// TODO Auto-generated method stub
				
			}
			// TODO Auto-generated method stub
			
		   ;

		   
		    
		    
		    void OpenFileDialog(String file){
		     
		     //Read file in Internal Storage
		     FileInputStream fis;
		     String content = "";
		     try {
		      fis = getActivity().getApplicationContext().openFileInput(file);
		      byte[] input = new byte[fis.available()];
		      while (fis.read(input) != -1) {}
		      content += new String(input);
		     } catch (FileNotFoundException e) {
		      e.printStackTrace();
		     } catch (IOException e) {
		      e.printStackTrace(); 
		     }
		     
		     //Create a custom Dialog
		     AlertDialog.Builder fileDialog
		     = new AlertDialog.Builder(FragmentTwo.this.getActivity());
		     fileDialog.setTitle(file);
		     
		     TextView textContent = new TextView(FragmentTwo.this.getActivity());
		     textContent.setText(content);
		        LayoutParams textViewLayoutParams
		         = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		        textContent.setLayoutParams(textViewLayoutParams);
		       
		        fileDialog.setView(textContent);
		       
		        fileDialog.setPositiveButton("OK", null);
		       
		        fileDialog.show();
		    }
		 

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		
	    }

		}
	


	