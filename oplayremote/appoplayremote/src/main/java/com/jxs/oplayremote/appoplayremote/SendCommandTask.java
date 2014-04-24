package com.jxs.oplayremote.appoplayremote;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jxs on 4/20/14.
 */
public class SendCommandTask extends AsyncTask<String, Void, Integer> {


    @Override
    protected Integer doInBackground(String... params) {
        try {
            String urlstring = params[0];
            Log.v("url", urlstring);
            URL url = new URL(urlstring);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            Log.v("RESPONSE", String.valueOf(urlConnection.getResponseCode()));
            urlConnection.disconnect();
        }
        catch(MalformedURLException nameOfTheException) {
            Log.v("LOG", "malformed URL");
        }
        catch(IOException nameOfTheException) {
            Log.v("LOG", "IO error");
        }
        return 0;
    }
}
