package com.singh.aakash.dbconnector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Category_Add extends AppCompatActivity {

    String placeId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category__add);

        Intent intent=getIntent();
        placeId=intent.getExtras().getString("placeId");

        final EditText category=(EditText) findViewById(R.id.category_add);

        Button submitCategory=(Button) findViewById(R.id.submitCategory);
        submitCategory.setText("Submit Category");
        submitCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("what is happening", "?");
                String CategoryString=category.getText().toString();

                Log.v("kurt","here");
                InsertCategory insertCategory=new InsertCategory(placeId,CategoryString);
                insertCategory.execute();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_category__add, menu);
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
