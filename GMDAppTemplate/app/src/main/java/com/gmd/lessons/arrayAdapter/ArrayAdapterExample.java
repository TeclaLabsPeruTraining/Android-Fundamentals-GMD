package com.gmd.lessons.arrayAdapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by pjohnson on 25/01/17.
 */

public class ArrayAdapterExample extends ArrayAdapter<String> {
    public ArrayAdapterExample(Context context, int resource, int textViewResourceId, List<String> objects) {
        super(context, resource, textViewResourceId, objects);
    }
}
