package com.gmd.lessons.arrayAdapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.gmd.lessons.R;

import java.util.Arrays;

/**
 * Created by pjohnson on 24/01/17.
 */

public class ArrayAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        View headerView = getLayoutInflater().inflate(R.layout.header_title, null);
        ((TextView) headerView.findViewById(R.id.headerTitle)).setText(R.string.arrayAdapterTitle);
        ListView arrayAdapterListView = (ListView) findViewById(R.id.listview);
        arrayAdapterListView.addHeaderView(headerView);
        arrayAdapterListView.setAdapter(new ArrayAdapterExample(this, R.layout.item_adapter, R.id.text,
                Arrays.asList(getResources().getStringArray(R.array.lorem))));

    }
}
