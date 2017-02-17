package com.gmd.lessons;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class ItemsEventsActivity extends Activity
implements AdapterView.OnItemSelectedListener{

    private Spinner spLocation;
    private String localidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_events);
        ui();
    }

    private void ui() {
        spLocation =(Spinner)findViewById(R.id.spLocation);
        spLocation.setTag(null);

        spLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long l) {
                if(spLocation.getTag()==null){
                    spLocation.setTag("Lo que sea");
                }else{
                    Log.v("CONSOLE", "spLocation" + adapterView.getAdapter().getItem(position));
                    localidad = adapterView.getAdapter().getItem(position).toString();
                    Toast.makeText(ItemsEventsActivity.this,
                            "Item seleccionado "+localidad,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
