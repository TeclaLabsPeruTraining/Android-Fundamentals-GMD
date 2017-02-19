package com.gmd.android.fragmentoejemplo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetalleFragment extends Fragment {


    private ListaFragment.FragmentListener mListener;

    public DetalleFragment() {
        // Required empty public constructor
    }


    public static DetalleFragment newInstance(Contacto contacto1) {
        DetalleFragment fragment = new DetalleFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("contacto", contacto1);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        Contacto contacto = (Contacto) bundle.getSerializable("contacto");
        TextView textView = (TextView) view.findViewById(R.id.nombre);
        if (contacto != null) {
            textView.setText(contacto.getNombre());
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ListaFragment.FragmentListener) {
            mListener = (ListaFragment.FragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
