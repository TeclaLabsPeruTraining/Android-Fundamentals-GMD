package com.gmd.lessons.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gmd.lessons.R;

import java.util.Arrays;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyRecycleAdapter myRecycleAdapter = new MyRecycleAdapter(Arrays.asList(getResources().getStringArray(R.array.lorem)));
        recyclerView.setAdapter(myRecycleAdapter);
    }
}
