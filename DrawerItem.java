package com.example.blooddonarapp;

public class DrawerItem {
	String ItemName;
	int imgResID;

	public DrawerItem(String itemName, int imgResID) {
		super();
		ItemName = itemName;
		this.imgResID = imgResID;

		// TODO Auto-generated constructor stub
	}

	public String getItemName() {
		// TODO Auto-generated method stub
		return ItemName;

	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public int getImgResID() {
		// TODO Auto-generated method stub
		return imgResID;
	}
	public void setImgResID(int imgResID) {
		this.imgResID = imgResID;
	}
   
}
