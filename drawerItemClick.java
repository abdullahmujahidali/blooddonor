package com.example.blooddonarapp;

import java.util.List;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.app.ActionBar;
import android.app.Activity;
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

/*public class drawerItemClick implements ListView.OnItemClickListener {
	FragmentManager getFragmentManager;

	

    
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectItem(position);
    }
    

 
private void selectItem(int position) {
    
     Fragment fragment = null;
    
    switch (position) {
    case 0:
        fragment = new FragmentOne();
        break;
    case 1:
        fragment = new FragmentTwo();
        break;
    case 2:
        fragment = new FragmentThree();
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
    
    if (fragment != null) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
 
        mDrawerList.setItemChecked(position, true);
        mDrawerList.setSelection(position);
        getActionBar().setTitle(mNavigationDrawerItemTitles[position]);
        mDrawerLayout.closeDrawer(mDrawerList);
        
    } else {
        Log.e("MainActivity", "Error in creating fragment");
    }
}
*/