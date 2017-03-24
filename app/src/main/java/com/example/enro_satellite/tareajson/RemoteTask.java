package com.example.enro_satellite.tareajson;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by enro-satellite on 17/03/17.
 */

public class RemoteTask extends AsyncTask<String, Void, JSONObject> {

    private RemoteTaskCallback callback;

    public RemoteTask(RemoteTaskCallback callback){
        this.callback=callback;
    }


    @Override
    protected JSONObject doInBackground(String... params) {
        JSONObject result = null;

        try {

            URL url =new URL(params[0]);


            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            if(connection.getResponseCode()==HttpURLConnection.HTTP_OK){


                InputStream in = connection.getInputStream();

                BufferedReader br = new BufferedReader(new InputStreamReader(in));

                StringBuilder sb = new StringBuilder();

                String line;

                while((line=br.readLine()) != null){
                    sb.append(line);
                    Log.i("lo que sea ",line);
                }

                result = new JSONObject(sb.toString());

                br.close();
            }


        }
        catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);
        callback.done(jsonObject);
    }

    public interface RemoteTaskCallback{
        void done(JSONObject json);
    }
}
