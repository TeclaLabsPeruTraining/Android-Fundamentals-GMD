package com.gmd.lessons.fragments;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gmd.lessons.fragments.listeners.OnFragmentListener;
import com.gmd.lessons.fragments.views.MessageFragment;

public class FragmentArgActivity extends AppCompatActivity  implements OnFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_arg);
        app();
    }

    private void app() {
        Bundle bundle= new Bundle();
        bundle.putString("MESSAGE", "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería");
        // Create new fragment and transaction
        MessageFragment messageFragment = new MessageFragment();
        messageFragment.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

    // Replace whatever is in the fragment_container view with this fragment,
    // and add the transaction to the back stack
        transaction.replace(R.id.flayContainer, messageFragment);
        //transaction.addToBackStack(null);

    // Commit the transaction
        transaction.commit();
    }
}
