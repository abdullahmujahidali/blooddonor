package com.example.blooddonarapp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

public class Click_Photo extends Activity implements OnClickListener {
	private ShareActionProvider myShareActionProvider;
	Bitmap bitmap;
	OutputStream output;
	ImageButton ib;
	ImageView iv;
	TextView tv;
	int REQUEST_CODE=1;
	Uri imageUri = null;
	Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_click__photo);
		ib=(ImageButton)findViewById(R.id.imageButton1);
		iv=(ImageView)findViewById(R.id.imageView1);
		tv=(TextView)findViewById(R.id.textView1);
		tv.setTypeface(Typeface.createFromAsset(getAssets(), "Fonts/ARCENA.ttf"));
		b1=(Button)findViewById(R.id.button1);
		ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.RED));
		ib.setOnClickListener(this);
		/*b1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
			
				// TODO Auto-generated method stub CODENINJA
				shareImage();
			
			}
			private void shareImage() {
				//Intent share = new Intent(Intent.ACTION_SEND);
				 
		        
		        //share.setType("image/*");
		 
		        
		        File filePath = Environment.getExternalStorageDirectory();
		        File dir=new File(filePath.getAbsolutePath()+ "Share Image");
		        dir.mkdirs();
		        File file=new File(dir,"sample_wallpaper.png");
		        try{
		        	Intent share = new Intent(Intent.ACTION_SEND);
		        	share.setType("image/*");
		        	output = new FileOutputStream(file);
		        	bitmap.compress(Bitmap.CompressFormat.PNG, 100, output);
					output.flush();
					output.close();
	 
		        
		        	
		        //File imageFileToShare = new File(imagePath);
		 
		       // Uri uri = Uri.fromFile(imageFileToShare);
		        Uri uri=Uri.fromFile(dir);
		        share.putExtra(Intent.EXTRA_STREAM, uri);
		        //share.putExtra(Intent.EXTRA_STREAM, uri);
		 
		        startActivity(Intent.createChooser(share, "Share Image!"));
		    
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				// TODO Auto-generated method stub
				
			
			}
			});*/
		
		
	}
	@Override
	public void onClick(View arg0) {
		Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		if(i.resolveActivity(getPackageManager())!=null);
		{
			startActivityForResult(i, REQUEST_CODE);
			//startActivityForResult(i, REQ_CAMERA_IMAGE);
		}
		
		// TODO Auto-generated method stub
		
	}


 @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
	    //myImage.png
		getMenuInflater().inflate(R.menu.click__photo, menu);
		
		
		return super.onCreateOptionsMenu(menu);
 }
 
 

	public void onActivityResult(int requestcode,int resultcode,Intent data)
     {
    	 if(requestcode==REQUEST_CODE)
    	 {
    		 if(resultcode==RESULT_OK)
    		 {
    			 Bundle bundle=new Bundle();
    			 bundle=data.getExtras();
    			 Bitmap bm;
    			 bm=(Bitmap)bundle.get("data");
    			 iv.setImageBitmap(bm);
    			 
    			 
    		 }
    	 }
     }
     }

