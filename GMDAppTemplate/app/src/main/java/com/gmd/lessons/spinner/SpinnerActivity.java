package com.gmd.lessons.spinner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.gmd.lessons.R;


/**
 * Created by pjohnson on 25/01/17.
 */

public class SpinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        final Spinner dropDownSpinner = (Spinner) findViewById(R.id.dropDownSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropDownSpinner.setAdapter(adapter);
        dropDownSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SpinnerActivity.this, dropDownSpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(SpinnerActivity.this, "Nada fue seleccionado", Toast.LENGTH_SHORT).show();

            }
        });


        Spinner dialogSpinner = (Spinner) findViewById(R.id.dialogSpinner);
        dialogSpinner.setAdapter(adapter);
    }

    //para el placeholder http://stackoverflow.com/questions/867518/how-to-make-an-android-spinner-with-initial-text-select-one
}
