package com.bx.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ui();
    }

    private void ui() {
        findViewById(R.id.btnClick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoBasicEvents();
            }
        });

        findViewById(R.id.btnItems).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoItemsEvents();
            }
        });

        findViewById(R.id.btnKeyboard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoKeyboardEvents();
            }
        });
    }

    private void gotoBasicEvents() {
        startActivity(new Intent(this, BasicEventsActivity.class));
    }

    private void gotoItemsEvents() {
        startActivity(new Intent(this, ItemsEventsActivity.class));
    }

    private void gotoKeyboardEvents() {
        startActivity(new Intent(this, KeyboardEventsActivity.class));
    }

    public void goToLogin(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
