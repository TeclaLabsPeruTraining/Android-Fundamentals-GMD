package com.gmd.lessons.viewholder;

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

public class ViewHolderExample extends BaseAdapter {

    private final List<String> mItems;
    private final LayoutInflater mInflater;
    private final Drawable starOn;

    public ViewHolderExample(Context context, List<String> items) {
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
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_adapter, null);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) convertView.findViewById(R.id.text);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.itemImage);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(mItems.get(position));
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ImageView) view).setImageDrawable(starOn);
            }
        });
        return convertView;
    }

    static class ViewHolder {
        TextView textView;
        ImageView imageView;
    }
}
