package com.neil.nanohttpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.neil.nanohttpdemo.server.MyServer;
import com.neil.nanohttpdemo.utils.NetworkUtils;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "MainActivity";

    private MyServer mMyServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(LOG_TAG, "onResume");

        try {
            String host = NetworkUtils.getWifiIpAddress(getApplicationContext());
            mMyServer = new MyServer(host, MyServer.PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d(LOG_TAG, "onPause");

        if(mMyServer != null) {
            mMyServer.stop();
        }
    }
}
