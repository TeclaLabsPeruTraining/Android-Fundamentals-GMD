package com.gmd.lessons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        events();
    }

    private void events() {
        findViewById(R.id.lrayRoot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoActivity();
            }
        });
    }

    private void gotoActivity() {
        Intent intent= new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }
}
