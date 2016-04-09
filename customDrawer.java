package com.example.blooddonarapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customDrawer extends ArrayAdapter<objectDrawer> {
	 
    Context mContext;
    int layoutResourceId;
    objectDrawer data[] = null;
 
    public customDrawer(Context mContext, int layoutResourceId, objectDrawer[] data) {
 
        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
 
    	
        View listItem = convertView;
 
        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        listItem = inflater.inflate(layoutResourceId, parent, false);
 
        ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIcon);
        TextView textViewName = (TextView) listItem.findViewById(R.id.textViewName);
        
        objectDrawer folder = data[position];
 
        
        imageViewIcon.setImageResource(folder.icon);
        textViewName.setText(folder.name);
        
        return listItem;
    }
 
}