package com.singh.aakash.dbconnector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class Category_intent extends AppCompatActivity {
    List<String> categories;
    private RecyclerView mRecyclerView;
    private CategoryRecyclerViewHolder categoryRecyclerViewHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_intent);

        Intent intent=getIntent();
        categories=intent.getStringArrayListExtra("arrayOfCats");
        mRecyclerView=(RecyclerView)findViewById(R.id.recycler_view_cat);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoryRecyclerViewHolder=new CategoryRecyclerViewHolder(categories,this);

        mRecyclerView.setAdapter(categoryRecyclerViewHolder);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_category_intent, menu);
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
