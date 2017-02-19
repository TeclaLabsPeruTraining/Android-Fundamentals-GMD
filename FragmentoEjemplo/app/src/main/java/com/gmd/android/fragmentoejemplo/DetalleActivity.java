package com.gmd.android.fragmentoejemplo;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity implements ListaFragment.FragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        Contacto contacto = (Contacto) getIntent().getSerializableExtra("contacto");
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.detailContainer, DetalleFragment.newInstance(contacto)).commit();
    }

    @Override
    public void clickContacto(Contacto contacto1) {

    }
}
