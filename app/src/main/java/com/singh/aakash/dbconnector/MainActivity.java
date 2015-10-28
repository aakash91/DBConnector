package com.singh.aakash.dbconnector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String placeId="ChIJBbLl2j_BwjsRG5iLmvhVGi8";          //this you get after logging in
    Product product;
    GreetingClient greetingClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText cat=(EditText) findViewById(R.id.category);
        final EditText prod=(EditText) findViewById(R.id.product);
        final EditText desc=(EditText)findViewById(R.id.description);
        final EditText pricee=(EditText) findViewById(R.id.price);

        Button submit=(Button)findViewById(R.id.submit);
        submit.setText("Submit product");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product=new Product(cat.getText().toString(),prod.getText().toString(),desc.getText().toString(), pricee.getText().toString(),placeId);
                Toast toast=Toast.makeText(getApplicationContext(),product.toString(),Toast.LENGTH_LONG);
                toast.show();
                greetingClient=new GreetingClient(product);
                greetingClient.execute();

            }
        });

        Button getCategories=(Button)findViewById(R.id.getCategories);
        getCategories.setText("What does this shop sell");
        getCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectToDB connectToDB=new ConnectToDB(MainActivity.this,placeId);
                connectToDB.execute();
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
