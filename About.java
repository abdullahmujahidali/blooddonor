package com.example.blooddonarapp;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.widget.TextView;

public class About extends Activity {
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
        tv=(TextView)findViewById(R.id.textView1);
        tv.setTypeface(Typeface.createFromAsset(getAssets(), "Fonts/ALGER.TTF"));

        tv.setMovementMethod(new ScrollingMovementMethod());


	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about, menu);
		return true;
	}
}
