package com.gmd.lessons;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class FourthActivity extends AppCompatActivity {

    private static final String TAG = "FourthActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        events();
    }

    private void events() {
        findViewById(R.id.lrayRoot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //close();
            }
        });
    }

    private void close() {
       finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //close();
        //clearNavigation();
    }


    private void clearNavigation(){
        Intent nextScreen = new Intent(this, MainActivity.class);
        nextScreen.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(nextScreen);
        ActivityCompat.finishAffinity(this);
    }
}
