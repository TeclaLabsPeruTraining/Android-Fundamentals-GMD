package com.gmd.lessons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.gmd.lessons.model.User;

public class ReceiveActivity extends AppCompatActivity {

    private static final String TAG = "ReceiveActivity";
    private int userId;
    private String userName;
    private User user;
    private String[] days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        validateExtras();

        populate();
    }

    private void populate() {

        Log.v(TAG, " userId "+userId);
        Log.v(TAG, " userName "+userName);
        Log.v(TAG, " user "+user.toString());

        for (String string:days) {
            Log.v(TAG, " days "+string);
        }

        TextView tviMessage= (TextView) findViewById(R.id.tviMessage);
        tviMessage.append("userId "+userId+"\n");
        tviMessage.append("userName "+userName+"\n");
        tviMessage.append("user "+user.toString()+"\n");

    }

    private void validateExtras() {
        if(getIntent()!=null && getIntent().getExtras()!=null){
            Bundle bundle= getIntent().getExtras();
            userId= bundle.getInt("USERID");
            userName= bundle.getString("USERNAME");
            user= (User) bundle.getSerializable("USER");
            days=  bundle.getStringArray("DAYS");
        }
    }
}
