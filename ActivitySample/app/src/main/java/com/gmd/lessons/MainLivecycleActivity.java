package com.gmd.lessons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainLivecycleActivity extends AppCompatActivity {

    private static final String TAG = "MainLivecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_livecycle);

        Log.v(TAG, "onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.v(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.v(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.v(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.v(TAG, "onDestroy()");
    }
}
