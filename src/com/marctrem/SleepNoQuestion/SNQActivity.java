package com.marctrem.SleepNoQuestion;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.os.IPowerManager;
import android.os.ServiceManager;


public class SNQActivity extends Activity {

    static final String LOG_TAG = "SNQActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void turnOffAction(View view) {
        Log.d(LOG_TAG, "Going down!");
        try {
            IPowerManager pm = IPowerManager.Stub.asInterface(ServiceManager.getService(Context.POWER_SERVICE));
            pm.shutdown(false, false);
        } catch (Exception e) {
            Log.e(LOG_TAG, "Failed to go down!");
            e.printStackTrace();
        }
    }
}
