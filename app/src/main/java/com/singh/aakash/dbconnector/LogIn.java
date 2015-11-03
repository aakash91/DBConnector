package com.singh.aakash.dbconnector;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {
    DBForLogin dbForLogin;
//    public static final String PREFS_NAME = "MyPrefsFile";
//    SharedPreferences settings = getSharedPreferences(LogIn.PREFS_NAME, 0); // 0 - for private mode
//    SharedPreferences.Editor editor = settings.edit();
    String username;
    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
//        editor.putBoolean("hasLoggedIn", false);
//
//// Commit the edits!
//        editor.commit();
        //SharedPreferences settings = getSharedPreferences(MainActivity.PREFS_NAME, 0);
//Get "hasLoggedIn" value. If the value doesn't exist yet false is returned
        //boolean hasLoggedIn = settings.getBoolean("hasLoggedIn", false);
        //Log.v("shit", hasLoggedIn + "");



        SharedPreferences sharedPref= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        boolean hasLoggedIn=sharedPref.getBoolean("hasLoggedIn",false);
//
        if(hasLoggedIn)
        {
            dbForLogin=new DBForLogin(LogIn.this,sharedPref.getString("username",""),sharedPref.getString("pwd",""));
            dbForLogin.execute();

            finish();
        }

        final EditText login=(EditText) findViewById(R.id.username);
        final EditText pwd=(EditText) findViewById(R.id.pwd);
        //username=login.getText().toString();
        //password=pwd.getText().toString();
        final Button Login=(Button) findViewById(R.id.Login);
        Login.setText("Log In");
        TextView contactUs=(TextView) findViewById(R.id.contactus);
        contactUs.setText("    Contact Us At 07755966911 to register your business    ");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            dbForLogin=new DBForLogin(LogIn.this,login.getText().toString(),pwd.getText().toString());
                username=login.getText().toString();
                password=pwd.getText().toString();

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
