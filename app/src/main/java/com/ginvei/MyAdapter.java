package com.ginvei;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kushaal on 7/30/17.
 */

public class MyAdapter extends BaseAdapter {
    ArrayList<InventoryItem> mArrayList;
    Context mContext;
    public MyAdapter(ArrayList<InventoryItem> inventoryList,Context context) {
        this.mArrayList = inventoryList;
        mContext=context;
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View list_item=view;
        if(list_item==null){
            list_item= LayoutInflater.from(mContext).inflate(R.layout.demo1,null);
        }
        TextView name=(TextView)list_item.findViewById(R.id.text1) ;
        name.setText(mArrayList.get(i).name);
        ImageView image=(ImageView)list_item.findViewById(R.id.icon);
        image.setImageResource(mArrayList.get(i).picture_id);
        return list_item;
    }
}
