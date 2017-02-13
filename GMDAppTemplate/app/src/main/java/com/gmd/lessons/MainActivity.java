package com.gmd.lessons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.examplesList);

//        String[] examples = getResources().getStringArray(R.array.examples);
//        int itemLayout = R.layout.item_example_list;
//        int textViewLayout = R.id.exampleTitle;
//        ArrayAdapter examplesAdapter = new ArrayAdapter<>(this, itemLayout, textViewLayout, examples);
//        listView.setAdapter(examplesAdapter);

        listView.setAdapter(new ArrayAdapter<>(this, R.layout.item_example_list,
                R.id.exampleTitle, getResources().getStringArray(R.array.examples)));

        final String[] activities = getResources().getStringArray(R.array.activities);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    Class<?> cls = Class.forName(MainActivity.this.getPackageName() + activities[position]);
                    Intent intent = new Intent(MainActivity.this, cls);
                    startActivity(intent);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
