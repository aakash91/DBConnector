package com.singh.aakash.dbconnector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddaProduct extends AppCompatActivity {

    Product product;
    GreetingClient greetingClient;
    String placeId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adda_product);

        Intent intent=getIntent();
        String category=intent.getExtras().getString("category");
        placeId=intent.getExtras().getString("placeId");
        final TextView cat=(TextView) findViewById(R.id.categoryProduct);
        cat.setText(category);
        final EditText prod=(EditText) findViewById(R.id.productName);
        final EditText desc=(EditText)findViewById(R.id.descriptionProduct);
        final EditText pricee=(EditText) findViewById(R.id.priceProduct);



        Button submitProduct=(Button)findViewById(R.id.submitProduct);
        submitProduct.setText("Submit product");
        submitProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product = new Product(cat.getText().toString(), prod.getText().toString(), desc.getText().toString(), pricee.getText().toString(), placeId);
                Toast toast = Toast.makeText(getApplicationContext(), product.toString(), Toast.LENGTH_LONG);
                toast.show();
                greetingClient = new GreetingClient(product);
                greetingClient.execute();
                //cat.setText("");
                prod.setText("");
                desc.setText("");
                pricee.setText("");
                prod.requestFocus();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_adda_product, menu);
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
