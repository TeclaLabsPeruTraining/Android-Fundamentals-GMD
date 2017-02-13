package com.gmd.lessons.baseadapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmd.lessons.R;

import java.util.List;

/**
 * Created by pjohnson on 24/01/17.
 */

public class BaseAdapterExample extends BaseAdapter {

    private final List<String> mItems;
    private final LayoutInflater mInflater;
    private final Drawable starOn;

    public BaseAdapterExample(Context context, List<String> items) {
        mItems = items;
        mInflater = LayoutInflater.from(context);
        starOn = context.getResources().getDrawable(android.R.drawable.star_big_on);
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.item_adapter, null);
        TextView titleView = (TextView) convertView.findViewById(R.id.text);
        titleView.setText(mItems.get(position));
        final ImageView imageView = (ImageView) convertView.findViewById(R.id.itemImage);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageDrawable(starOn);
            }
        });
        return convertView;
    }
}
