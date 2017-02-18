package com.gmd.lessons.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gmd.lessons.fragments.listeners.OnFragmentListener;
import com.gmd.lessons.fragments.views.AFragment;
import com.gmd.lessons.fragments.views.BFragment;
import com.gmd.lessons.fragments.views.CFragment;

public class FragmentStackActivity extends AppCompatActivity implements OnFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_stack);
        app();
    }

    private void app() {
        // Create new fragment and transaction
        AFragment aFragment = new AFragment();
        BFragment bFragment= new BFragment();
        CFragment cFragment= new CFragment();

        addFragment(aFragment);
        addFragment(bFragment);
        addFragment(cFragment);

    }
    private void addFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.flayContainer, fragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
