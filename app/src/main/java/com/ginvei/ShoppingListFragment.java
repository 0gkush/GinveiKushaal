 package com.ginvei;

import android.support.v4.app.Fragment;
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

public class ShoppingListFragment extends Fragment{
    View myView;
     ListView shoppingList;
     ArrayList<InventoryItem> list = new ArrayList<>();
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.shopping_list,container, false);
        return myView;

    }
     @Override
     public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
         super.onViewCreated(view, savedInstanceState);
         list.add(new InventoryItem("Google",R.drawable.google,"Google is social Media"));
         list.add(new InventoryItem("Facebook",R.drawable.facebook,"Facebook is Social Media"));
         list.add(new InventoryItem("Twitter",R.drawable.twitter, "Twitter is Social Media"));
         list.add(new InventoryItem("Instagram",R.drawable.instagram, "Instagram is Social Media"));

         shoppingList = (ListView) getView().findViewById(R.id.shopping_list);
         shoppingList.setAdapter(new ShoppingListAdapter(list, getContext()));
         //MyAdapter adapter = new MyAdapter(this, productTitles, imgs, productDescription);
         shoppingList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
