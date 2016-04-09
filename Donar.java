package com.example.blooddonarapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Donar extends FragmentPagerAdapter {

	public Donar(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		switch(arg0){
		case 0:
			return new Find_Donar();
		case 1:
			return new Find_BloodBank();
			default:
				break;
		
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 2;
	}

}
