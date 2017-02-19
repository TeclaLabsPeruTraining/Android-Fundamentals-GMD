package com.gmd.android.fragmentoejemplo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ListaFragment.FragmentListener {


    private boolean isTablet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.listContainer, ListaFragment.newInstance()).commit();
        if (findViewById(R.id.detailContainer) != null) {
            isTablet = true;
        }

        if (isTablet) {
            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
            ft2.add(R.id.detailContainer, DetalleFragment.newInstance(null)).commit();
        }

    }

    @Override
    public void clickContacto(Contacto contacto1) {
        if (isTablet) {
            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
            ft2.replace(R.id.detailContainer, DetalleFragment.newInstance(contacto1)).commit();
        } else {
            Intent intent = new Intent(this, DetalleActivity.class);
            intent.putExtra("contacto", contacto1);
            startActivity(intent);
        }
    }

    @Override
    public void borrarContacto() {
        //implemento
    }
}
