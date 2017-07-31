package com.ginvei;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.content.Context;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ListView inventoryList;
    String [] productTitles;
    String [] productDescription;
    ArrayList<InventoryItem> list = new ArrayList<>();


    //int[] imgs = new int[]{R.drawable.google.png, R.drawable.facebook, R.drawable.instagram, R.drawable.twitter};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*Resources res = getResources();*/
       /* productTitles = res.getStringArray(R.array.inventory_products);
        productDescription = res.getStringArray(R.array.product_description);*/

        list.add(new InventoryItem("Google",R.drawable.google,"Google is social Media"));
        list.add(new InventoryItem("Facebook",R.drawable.facebook,"Facebook is Social Media"));
        list.add(new InventoryItem("Twitter",R.drawable.twitter, "Twitter is Social Media"));
        list.add(new InventoryItem("Instagram",R.drawable.instagram, "Instagram is Social Media"));

                 inventoryList = (ListView) findViewById(R.id.inventory_list);
       inventoryList.setAdapter(new MyAdapter(list, this));
        //MyAdapter adapter = new MyAdapter(this, productTitles, imgs, productDescription);
        inventoryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startDetailActivity(i);
           }


    });






}
    public void startDetailActivity(int i) {
        Intent detailActivityIntent=new Intent(this, DetailActivity.class);
        detailActivityIntent.putExtra("name",list.get(i).name);
        detailActivityIntent.putExtra("description",list.get(i).description);
        detailActivityIntent.putExtra("picture_id",list.get(i).picture_id);
        startActivity(detailActivityIntent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        android.app.FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_first_layout) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new ScannerFragment())
                    .commit();
        } else if (id == R.id.nav_second_layout) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new InventoryFragment())
                    .commit();

        } else if (id == R.id.nav_third_layout) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new ShoppingListFragment())
                    .commit();
        } else if (id == R.id.nav_fourth_layout) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new GinveiScannerFragment())
                    .commit();
        } else if (id == R.id.nav_fifth_layout) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new AmazonAlexaFragment())
                    .commit();
        } else if (id == R.id.nav_sixth_layout) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new UserSettingsFragment())
                    .commit();
        } else if (id == R.id.nav_seventh_layout) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new LeaderboardFragment())
                    .commit();
        } else if (id == R.id.nav_eigth_layout) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new FeedbackFragment())
                    .commit();
        } else if (id == R.id.nav_ninth_layout) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new TellFriendFragment())
                    .commit();
        } else if (id == R.id.nav_tenth_layout) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new LogoutFragment())
                    .commit();


        } 

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}