package org.codeforcoffee.littlebitscloudbitremote;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by codeforcoffee on 8/8/16.
 */
public class HttpTask extends AsyncTask<String, Void, JSONObject> implements ITaskInterface {

    private OkHttpClient mHttpClient = new OkHttpClient();
    private Request mRequest;
    private Response mResponse;

    private final String TAG = "HttpTask";

    @Override
    protected JSONObject doInBackground(String... urls) {
        mRequest = new Request.Builder().url(urls[0]).build();
        try {
            mResponse = mHttpClient.newCall(mRequest).execute();
            return new JSONObject(mResponse.body().string());
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(JSONObject json) {
        onTaskComplete(json);
    }

    @Override
    public void onTaskComplete(Object obj) {
        Log.i(TAG, obj.toString());
    }

    @Override
    public void onError(Object obj) {
        Log.i(TAG, obj.toString());
    }
}