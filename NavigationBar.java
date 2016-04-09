package com.example.blooddonarapp;


import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

public class NavigationBar extends Activity {
	DrawerLayout dl;
	ListView lv;
	ActionBarDrawerToggle dt;
	
	CharSequence mDrawerTitle;
    CharSequence mTitle;
	CustomDrawerAdapter adapter;

	List<DrawerItem> dataList;
   // @Override
	//public void onCreate(Bundle savedInstanceState){
    protected void onCreateDrawer(){
	   //super.onCreate(savedInstanceState);
		//this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				//WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_navigation_bar);
		//onCreateDrawer();
		dataList = new ArrayList<DrawerItem>();
		mTitle = mDrawerTitle = getTitle();
		dl = (DrawerLayout) findViewById(R.id.drawer_layout);
		lv= (ListView) findViewById(R.id.left_drawer);
		ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.RED));

		dl.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		dataList.add(new DrawerItem("Email", R.drawable.ic_action_email));
		dataList.add(new DrawerItem("Manage Donation Records", R.drawable.ic_action_labels));
		dataList.add(new DrawerItem("Gallery",R.drawable.ic_adb_black_24dp));
		dataList.add(new DrawerItem("Exit",R.drawable.ic_adb_black_24dp));
		adapter = new CustomDrawerAdapter(this, R.layout.custom_drawer_item,
				dataList);


		lv.setAdapter(adapter);

		lv.setOnItemClickListener(new DrawerItemClickListener());

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		dt= new ActionBarDrawerToggle(this, dl,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}
		};

		dl.setDrawerListener(dt);

		
		//if (savedInstanceState==null) {
			//SelectItem(0);
		}

	//}


	

	private void SelectItem(int position) {
		Fragment fragment = null;
		Bundle args = new Bundle();
		//int position =lv.getSelectedItemPosition();
		switch (position) {
		case 0:
			fragment = new FragmentOne();
			args.putString(FragmentOne.ITEM_NAME, dataList.get(position)
					.getItemName());
			args.putInt(FragmentOne.IMAGE_RESOURCE_ID, dataList.get(position)
					.getImgResID());
			break;
		case 1:
			fragment = new FragmentTwo();
			args.putString(FragmentTwo.ITEM_NAME, dataList.get(position)
					.getItemName());
			args.putInt(FragmentTwo.IMAGE_RESOURCE_ID, dataList.get(position)
					.getImgResID());
			break;
		case 2:
			fragment = new FragmentThree();
			args.putString(FragmentThree.ITEM_NAME, dataList.get(position)
					.getItemName());
			args.putInt(FragmentThree.IMAGE_RESOURCE_ID, dataList.get(position)
					.getImgResID());
			break;
		case 3:
			fragment = new FragmentFour();
			this.finish();
		    Intent intent = new Intent(Intent.ACTION_MAIN);
		    intent.addCategory(Intent.CATEGORY_HOME);
		    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		    startActivity(intent);
			break;

		default:
			break;
		}

		fragment.setArguments(args);
		FragmentManager frgManager = getFragmentManager();
		frgManager.beginTransaction().replace(R.id.content_frame, fragment)
				.commit();

		lv.setItemChecked(position, true);
		setTitle(dataList.get(position).getItemName());
		dl.closeDrawer(lv);

	}
	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	//@Override
	protected void onPostCreate(){
		
	//protected void onPostCreate(Bundle savedInstanceState) {
		//super.onPostCreate(savedInstanceState);
		super.onPostCreate(null);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		dt.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggles
		dt.onConfigurationChanged(newConfig);
	}




	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// The action bar home/up action should open or close the drawer.
				// ActionBarDrawerToggle will take care of this.
				if (dt.onOptionsItemSelected(item)) {
					return true;
				}

				return false;
			}

			public class DrawerItemClickListener implements
					ListView.OnItemClickListener {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position,
						long id) {
					SelectItem(position);

				}

				public void onPostCreate(Bundle savedInstanceState) {
					// TODO Auto-generated method stub
					
				}
			}

}
