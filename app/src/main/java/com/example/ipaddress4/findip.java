package com.example.ipaddress4;

import android.os.AsyncTask;
import android.util.Log;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.HttpClient;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpGet;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client.DefaultHttpClient;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.EntityUtils;

public class findip extends AsyncTask<Void, Void, String> {
    private static String rett;
    public String doInBackground(Void... urls) {
        String ip = "Empty";

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet("http://wtfismyip.com/text");
            HttpResponse response;

            response = httpclient.execute(httpget);

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                long len = entity.getContentLength();
                if (len != -1 && len < 1024) {
                    String str = EntityUtils.toString(entity);
                    ip = str.replace("\n", "");
                } else {
                    ip = "Response too long or error.";
                }
            } else {
                ip = "Null:" + response.getStatusLine().toString();
            }

        } catch (Exception e) {
            ip = "Error";
        }
        rett=ip;
        return ip;
    }

    protected void onPostExecute(String result) {

        // External IP
        Log.d("ExternalIP", result);
    }
    public static String getip(){

        return rett;
    }
}

