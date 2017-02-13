package com.gmd.lessons.viewholder;

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

public class ViewHolderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        View headerView = getLayoutInflater().inflate(R.layout.header_title, null);
        ((TextView) headerView.findViewById(R.id.headerTitle)).setText(R.string.viewHolderTitle);
        ListView viewHolderListView = (ListView) findViewById(R.id.listview);
        viewHolderListView.addHeaderView(headerView);
        viewHolderListView.setAdapter(new ViewHolderExample(this, Arrays.asList(getResources().getStringArray(R.array.lorem))));

    }
}
