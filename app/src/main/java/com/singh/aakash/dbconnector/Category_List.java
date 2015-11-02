package com.singh.aakash.dbconnector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

public class Category_List extends AppCompatActivity {
    List<String> categories;
    private RecyclerView mRecyclerView;
    private CategoryRecyclerViewHolder categoryRecyclerViewHolder;
    private String placeId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category__list);

        Intent intent=getIntent();
        categories=intent.getStringArrayListExtra("arrayOfCats");
        placeId=intent.getExtras().getString("placeId");
        mRecyclerView=(RecyclerView)findViewById(R.id.recycler_view_cat_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoryRecyclerViewHolder=new CategoryRecyclerViewHolder(categories,this);

        mRecyclerView.setAdapter(categoryRecyclerViewHolder);
        mRecyclerView.addOnItemTouchListener(new CategoryRecyclerItemClickListener(this, mRecyclerView, new CategoryRecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Log.v("Fuck", "fucked");
                //Toast.makeText(MainActivity.this, "Zor se daba bhosadi k", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(getApplicationContext(), Products_List.class);
//                intent.putExtra("category", categoryRecyclerViewHolder.getCategoryPosition(position));
//                startActivity(intent);
                //ConnectToDB connectToDB=new ConnectToDB(MainActivity.this);
                //connectToDB.execute();
                Intent intent=new Intent(Category_List.this,AddaProduct.class);
                intent.putExtra("placeId",placeId);
                intent.putExtra("category", categoryRecyclerViewHolder.getCategoryPosition(position));
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                //Log.v("Fuck", "fuck");
                //Toast.makeText(Category_intent.this, "Fuck u", Toast.LENGTH_SHORT).show();

            }
        }));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_category__list, menu);
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
