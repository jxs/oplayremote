package com.jxs.oplayremote.appoplayremote;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainScreen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the main_screen; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void sendCommand(View view) {
        String command = view.getTag().toString();
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        Log.v("OplayIP", sharedPref .getString("oplayIP", ""));
        String oplayAddress = "http://".concat(sharedPref.getString("oplayIP", "")).concat("/cgi-bin/cmd.cgi?").concat(command);
        new SendCommandTask().execute(oplayAddress);
    }
}
