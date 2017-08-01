 package com.ginvei;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

 /**
 * Created by kushaal on 7/16/17.
 */

public class InventoryFragment extends Fragment{
     ListView inventoryList;
     ArrayList<InventoryItem> list = new ArrayList<>();
     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
         // Inflate the layout for this fragment
         return inflater.inflate(R.layout.inventory, container, false);
     }

     /**
      * Called immediately after {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
      * has returned, but before any saved state has been restored in to the view.
      * This gives subclasses a chance to initialize themselves once
      * they know their view hierarchy has been completely created.  The fragment's
      * view hierarchy is not however attached to its parent at this point.
      *
      * @param view               The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
      * @param savedInstanceState If non-null, this fragment is being re-constructed
      */
     @Override
     public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
         super.onViewCreated(view, savedInstanceState);
         list.add(new InventoryItem("Google",R.drawable.google,"Google is social Media"));
         list.add(new InventoryItem("Facebook",R.drawable.facebook,"Facebook is Social Media"));
         list.add(new InventoryItem("Twitter",R.drawable.twitter, "Twitter is Social Media"));
         list.add(new InventoryItem("Instagram",R.drawable.instagram, "Instagram is Social Media"));

         inventoryList = (ListView) getView().findViewById(R.id.inventory_list);
         inventoryList.setAdapter(new MyAdapter(list, getContext()));
         //MyAdapter adapter = new MyAdapter(this, productTitles, imgs, productDescription);
         inventoryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 startDetailActivity(i);
             }


         });
     }
     public void startDetailActivity(int i) {
         Intent detailActivityIntent=new Intent(getContext(), DetailActivity.class);
         detailActivityIntent.putExtra("name",list.get(i).name);
         detailActivityIntent.putExtra("description",list.get(i).description);
         detailActivityIntent.putExtra("picture_id",list.get(i).picture_id);
         startActivity(detailActivityIntent);
     }
}
