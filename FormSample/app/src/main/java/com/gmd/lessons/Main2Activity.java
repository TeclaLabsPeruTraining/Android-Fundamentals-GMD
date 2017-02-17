package com.gmd.lessons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity
implements View.OnClickListener{

    private Button btnMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //inicializar la ui
        btnMe= (Button) findViewById(R.id.btnMe);

        //eventos
        //btnMe.setOnClickListener(this);
        btnMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("CONSOLE", "click Button 2");
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view.getId()== R.id.btnMe){
            Log.v("CONSOLE", "click Button");
        }
    }
}
