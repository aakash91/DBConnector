package com.singh.aakash.dbconnector;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //String placeId="ChIJBbLl2j_BwjsRG5iLmvhVGi8";          //this you get after logging in
    //String placeId="ChIJowDzbsPDwjsRJyiD-7Q_0HY";
    String placeId;
    Product product;
    GreetingClient greetingClient;

    //public static final String PREFS_NAME = "MyPrefsFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        placeId=intent.getExtras().getString("placeId");

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        //SharedPreferences.Editor editor = settings.edit();
        sharedPref.edit().putBoolean("hasLoggedIn", true).commit();
        sharedPref.edit().putString("username", intent.getExtras().getString("username")).commit();
        sharedPref.edit().putString("pwd", intent.getExtras().getString("pwd")).commit();


//Set "hasLoggedIn" to true
        //editor.putBoolean("hasLoggedIn", true);

// Commit the edits!
        ///editor.commit();


        final TextView business_name=(TextView) findViewById(R.id.business_name);
        business_name.setText(intent.getExtras().getString("username"));
//        final EditText cat=(EditText) findViewById(R.id.category);
//        final EditText prod=(EditText) findViewById(R.id.product);
//        final EditText desc=(EditText)findViewById(R.id.description);
//        final EditText pricee=(EditText) findViewById(R.id.price);
//
//        Button submit=(Button)findViewById(R.id.submit);
//        submit.setText("Submit product");
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                product = new Product(cat.getText().toString(), prod.getText().toString(), desc.getText().toString(), pricee.getText().toString(), placeId);
//                Toast toast = Toast.makeText(getApplicationContext(), product.toString(), Toast.LENGTH_LONG);
//                toast.show();
//                greetingClient = new GreetingClient(product);
//                greetingClient.execute();
//                cat.setText("");
//                prod.setText("");
//                desc.setText("");
//                pricee.setText("");
//                cat.requestFocus();
//
//            }
//        });

        Button getCategories=(Button)findViewById(R.id.getCategories);
        getCategories.setText("My Products List");
        getCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectToDB connectToDB = new ConnectToDB(MainActivity.this, placeId);
                connectToDB.execute();

            }
        });

        Button submitAd=(Button)findViewById(R.id.submitAds);
        submitAd.setText("Publish an Ad");
        submitAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Advertisements.class);
                intent.putExtra("placeId", placeId);
                startActivity(intent);
            }
        });

        Button AdList=(Button)findViewById(R.id.AdList);
        AdList.setText("My AdList");
        AdList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBForAds dbForAds = new DBForAds(MainActivity.this, placeId);
                dbForAds.execute();
            }
        });


        Button AddCategory=(Button) findViewById(R.id.addCategory);
        AddCategory.setText("Add a new Category");
        AddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Category_Add.class);
                intent.putExtra("placeId",placeId);
                startActivity(intent);
            }
        });

        Button AddProduct=(Button)findViewById(R.id.addProductToCategory);
        AddProduct.setText("Add Product");
        AddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,Category_List.class);
//                intent.putExtra("placeId", placeId);
//                startActivity(intent);
                ConnectForCat connectForCat=new ConnectForCat(MainActivity.this,placeId);
                connectForCat.execute();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
