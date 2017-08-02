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
 * Created by theseus on 2/8/17.
 */

public class ShoppingListAdapter extends BaseAdapter {
    ArrayList<InventoryItem> mArrayList;
    Context mContext;
    public ShoppingListAdapter(ArrayList<InventoryItem> inventoryList,Context context) {
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
            list_item= LayoutInflater.from(mContext).inflate(R.layout.inventory_row,null);
        }
        TextView name=(TextView)list_item.findViewById(R.id.text1) ;
        name.setText(mArrayList.get(i).name);
        ImageView image=(ImageView)list_item.findViewById(R.id.icon);
        image.setImageResource(mArrayList.get(i).picture_id);
        return list_item;
    }
}
