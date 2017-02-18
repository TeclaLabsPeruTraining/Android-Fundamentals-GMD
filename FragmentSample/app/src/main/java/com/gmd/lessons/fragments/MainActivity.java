package com.gmd.lessons.fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ui();
    }

    private void ui() {
        findViewById(R.id.btnArg).setOnClickListener(this);
        findViewById(R.id.btnBasic).setOnClickListener(this);
        findViewById(R.id.btnCommunication).setOnClickListener(this);
        findViewById(R.id.btnStack).setOnClickListener(this);
        findViewById(R.id.btnDynamics).setOnClickListener(this);
        findViewById(R.id.btnCards).setOnClickListener(this);
    }

    private void gotoActivities(Class<?> activity){
        Intent intent= new Intent(this,activity);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnArg:
                gotoActivities(FragmentArgActivity.class);
                break;
            case R.id.btnBasic:
                gotoActivities(BasicFragmentActivity.class);
                break;
            case R.id.btnCommunication:
                gotoActivities(CommunicatingFragmentActivity.class);
                break;
            case R.id.btnStack:
                gotoActivities(FragmentStackActivity.class);
                break;
            case R.id.btnDynamics:
                gotoActivities(DynamicFragmentActivity.class);
                break;
            case R.id.btnCards:
                gotoActivities(CardsActivity.class);
                break;
        }
    }
}
