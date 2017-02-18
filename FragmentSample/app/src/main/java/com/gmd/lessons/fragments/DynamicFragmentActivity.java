package com.gmd.lessons.fragments;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gmd.lessons.fragments.listeners.OnFragmentListener;
import com.gmd.lessons.fragments.views.AFragment;

public class DynamicFragmentActivity extends AppCompatActivity implements OnFragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);
        addFragment();
    }

    private void addFragment() {

        AFragment newFragment = new AFragment();
        Bundle args = new Bundle();
        args.putInt("POSITION", 1);
        args.putString("NAME", "MyFragment");
        newFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flayContainer, newFragment);
        //transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }
}
