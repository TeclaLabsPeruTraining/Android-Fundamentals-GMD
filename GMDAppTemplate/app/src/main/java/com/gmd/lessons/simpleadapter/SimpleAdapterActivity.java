package com.gmd.lessons.simpleadapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.gmd.lessons.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pjohnson on 24/01/17.
 */

public class SimpleAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        View headerView = getLayoutInflater().inflate(R.layout.header_title, null);
        ((TextView) headerView.findViewById(R.id.headerTitle)).setText(R.string.simpleAdapterTitle);
        ListView simpleAdapterListView = (ListView) findViewById(R.id.listview);
        simpleAdapterListView.addHeaderView(headerView);

        // create the grid item mapping
        String[] from = new String[]{"col1", "col2"};
        int[] to = new int[]{R.id.country, R.id.capital};
        String[] col1Values = getResources().getStringArray(R.array.countries);
        String[] col2Values = getResources().getStringArray(R.array.capitals);

        // prepare the list of all records
        List<HashMap<String, String>> fillMaps = new ArrayList<>();
        for (int i = 0; i < col1Values.length; i++) {
            HashMap<String, String> map = new HashMap<>();

            map.put("col1", col1Values[i]);
            map.put("col2", col2Values[i]);

            fillMaps.add(map);
        }
        SimpleAdapterExample simpleAdapterExample = new SimpleAdapterExample(this, fillMaps, R.layout.item_countries, from, to);
        simpleAdapterListView.setAdapter(simpleAdapterExample);


    }
}
