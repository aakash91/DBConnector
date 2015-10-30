package com.singh.aakash.dbconnector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Advertisements extends AppCompatActivity {

    String placeId;
    String AdString;
    InsertAds insertAds;
    String shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisements);

        Intent intent=getIntent();
        placeId=intent.getExtras().getString("placeId");

        final EditText Ads=(EditText) findViewById(R.id.AdContent);
        final EditText shopName=(EditText) findViewById(R.id.shopName);

        Button submitAd=(Button) findViewById(R.id.submitMyAd);
        submitAd.setText("Submit Adverstisment");
        submitAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("what is happening","?");
                AdString=Ads.getText().toString();
                shop=shopName.getText().toString();
                Log.v("what",AdString+" "+shop);
                insertAds=new InsertAds(placeId,AdString,shop);
                insertAds.execute();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_advertisements, menu);
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
}
