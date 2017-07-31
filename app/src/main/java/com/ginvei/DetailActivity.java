package com.ginvei;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by kushaal on 7/30/17.
 */

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if(getIntent()!=null){
            //Extracting the value sent from MainActivity
            String name=getIntent().getStringExtra("name");
            String description=getIntent().getStringExtra("description");

            // Since picture_id is an integer, hence we need an int to recieve it and a default value, -1 in this case
            int picture_id=getIntent().getIntExtra("picture_id",-1);


            TextView text_name=(TextView)findViewById(R.id.name);
            text_name.setText(name);

            TextView text_description=(TextView)findViewById(R.id.description);
            text_description.setText(description);


            // Setting the image view
            ImageView image=(ImageView)findViewById(R.id.image);
            image.setImageResource(picture_id);
        }
    }
}
