package com.example.blooddonarapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class NavigationDrawr extends Activity {
	private String[] mNavigationDrawerItemTitles;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navigation_drawr);
		mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		objectDrawer[] drawerItem = new objectDrawer[4];
		 
		drawerItem[0] = new objectDrawer(R.drawable.ic_action_email, "Email");
		drawerItem[1] = new objectDrawer(R.drawable.ic_action_labels, "Manage Record");
		drawerItem[2] = new objectDrawer(R.drawable.ic_adb_black_24dp, "Gallery");
		drawerItem[0] = new objectDrawer(R.drawable.ic_keyboard_arrow_right_black_24dp, "Exit");
		customDrawer adapter = new customDrawer(this, R.layout.listview_itemrow, drawerItem);
		mDrawerList.setAdapter(adapter);


	}

}
