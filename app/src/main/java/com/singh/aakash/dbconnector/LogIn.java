package com.singh.aakash.dbconnector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        final EditText login=(EditText) findViewById(R.id.username);
        final EditText pwd=(EditText) findViewById(R.id.pwd);
        final Button Login=(Button) findViewById(R.id.Login);

        TextView contactUs=(TextView)findViewById(R.id.contactus);
        contactUs.setText("    Contact Us At 07755966911 to register your business    ");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            DBForLogin dbForLogin=new DBForLogin(LogIn.this,login.getText().toString(),pwd.getText().toString());
                dbForLogin.execute();

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log_in, menu);
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
