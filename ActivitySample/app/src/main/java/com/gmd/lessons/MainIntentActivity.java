package com.gmd.lessons;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gmd.lessons.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainIntentActivity extends AppCompatActivity {


    private User user;
    private String[] days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_intent);
        app();
        events();
    }

    private void app() {
        user= new User();
        user.setId(100);
        user.setDni("40898479");
        user.setName("Eduardo");
        user.setLastName("Medina");

        days= new String[]{"Lunes","Martes","Miercoles","Jueves","Viernes"};
    }

    private void events() {

        findViewById(R.id.btnSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoReceiveActitity();
            }
        });
    }

    private void gotoReceiveActitity() {

        Intent intent= new Intent(this, ReceiveActivity.class);

        Bundle bundle= new Bundle();
        bundle.putSerializable("USER",user);
        bundle.putInt("USERID",user.getId());
        bundle.putString("DNI",user.getDni());
        bundle.putString("USERNAME",user.getName());
        bundle.putStringArray("DAYS",days);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
