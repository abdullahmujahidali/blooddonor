package com.example.blooddonarapp;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MakeANote extends Activity {
	EditText e1;
	Button b1,b2;
	TextView t1;
	String path=Environment.getExternalStorageDirectory().getAbsolutePath()+ "/makeanote";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_make_anote);
		ActionBar actionBar = getActionBar();
	    //actionBar.setBackgroundDrawable(new ColorDrawable(Color.RED));
	    actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FA5858"))); //FA5858
		
		e1=(EditText)findViewById(R.id.editText1);
		t1=(TextView)findViewById(R.id.textView1);
		t1.setTypeface(Typeface.createFromAsset(getAssets(), "Fonts/ARCENA.ttf"));
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		
		File dir=new File(path);
		dir.mkdirs();
	}
	public void button1(View view)
	{
		File file=new File(path + "/saveFile.txt");
		String [] saveText=String.valueOf(e1.getText()).split(System.getProperty("line.separator"));
		e1.setText("");
		Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
		Save(file,saveText);
	}
	public void button2(View viw)
	{
		File file=new File(path + "/saveFile.txt");
		String [] loadText=Load(file);
		String finalString="";
		for(int i=0; i<loadText.length;i++)
		{
			finalString += loadText[i] + System.getProperty("line.separator"); 
		}
		t1.setText(finalString);
		
		
	}
	
	private void Save(File file, String[] data) {
		 FileOutputStream fos = null;
	        try
	        {
	            fos = new FileOutputStream(file);
	        }
	        catch (FileNotFoundException e) {e.printStackTrace();}
	        try
	        {
	            try
	            {
	                for (int i = 0; i<data.length; i++)
	                {
	                    fos.write(data[i].getBytes());
	                    if (i < data.length-1)
	                    {
	                        fos.write("\n".getBytes());
	                    }
	                }
	            }
	            catch (IOException e) {e.printStackTrace();}
	        }
	        finally
	        {
	            try
	            {
	                fos.close();
	            }
	            catch (IOException e) {e.printStackTrace();}
	        }
	    }
		// TODO Auto-generated method stub
		
	
	private String[] Load(File file) {

        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(file);
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String test;
        int anzahl=0;
        try
        {
            while ((test=br.readLine()) != null)
            {
                anzahl++;
            }
        }
        catch (IOException e) {e.printStackTrace();}

        try
        {
            fis.getChannel().position(0);
        }
        catch (IOException e) {e.printStackTrace();}

        String[] array = new String[anzahl];

        String line;
        int i = 0;
        try
        {
            while((line=br.readLine())!=null)
            {
                array[i] = line;
                i++;
            }
        }
        catch (IOException e) {e.printStackTrace();}
        return array;
   
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