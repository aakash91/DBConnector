package com.singh.aakash.dbconnector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class AdsIntent extends AppCompatActivity {
    List<String> AdList;
    private RecyclerView mRecyclerView;
    private CategoryRecyclerViewHolder AdsViewAdapter;
    String placeId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads_intent);

        Intent intent=getIntent();
        placeId=intent.getExtras().getString("placeId");
       // List<String> AdverList=new ArrayList<>();
        AdList=intent.getStringArrayListExtra("arrayOfAds");
//        for(String s:productList){
//            s=s.replaceAll(",","\n");
//            productsList.add(s);
//        }
        //Log.v("fuck this shit",category);
        mRecyclerView=(RecyclerView)findViewById(R.id.recycler_view_Ads);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdsViewAdapter=new CategoryRecyclerViewHolder(AdList,this);

        mRecyclerView.setAdapter(AdsViewAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ads_intent, menu);
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
