package com.gmd.lessons.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gmd.lessons.fragments.listeners.OnFragmentListener;
import com.gmd.lessons.fragments.views.AFragment;

public class BasicFragmentActivity extends AppCompatActivity implements OnFragmentListener {

    private AFragment aFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_fragment);

        app();
    }

    private void app() {
        FragmentManager fragmentManager= getSupportFragmentManager();
        aFragment= (AFragment) fragmentManager.findFragmentById(R.id.fragment);
    }
}
