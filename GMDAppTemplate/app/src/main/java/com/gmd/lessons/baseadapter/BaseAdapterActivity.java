package com.gmd.lessons.baseadapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gmd.lessons.R;

import java.util.Arrays;

/**
 * Created by pjohnson on 24/01/17.
 */

public class BaseAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        View headerView = getLayoutInflater().inflate(R.layout.header_title, null);
        ((TextView) headerView.findViewById(R.id.headerTitle)).setText(R.string.baseAdapterTitle);
        final ListView baseAdapterListView = (ListView) findViewById(R.id.listview);
        baseAdapterListView.addHeaderView(headerView);
        baseAdapterListView.setAdapter(new BaseAdapterExample(this, Arrays.asList(getResources().getStringArray(R.array.lorem))));

        baseAdapterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BaseAdapterActivity.this, EjemploActivity.class);
                String item = (String) baseAdapterListView.getItemAtPosition(position);
                intent.putExtra("item", item);
                startActivity(intent);
            }
        });

    }
}
