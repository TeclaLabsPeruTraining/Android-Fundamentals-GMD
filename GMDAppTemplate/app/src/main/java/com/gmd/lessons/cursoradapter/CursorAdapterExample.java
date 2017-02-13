package com.gmd.lessons.cursoradapter;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmd.lessons.R;


/**
 * Created by pjohnson on 25/01/17.
 */

public class CursorAdapterExample extends CursorAdapter {

    public CursorAdapterExample(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView contactNameView = (TextView) view.findViewById(R.id.contactName);
        TextView contactPhoneView = (TextView) view.findViewById(R.id.contactPhone);

        contactNameView.setText(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
        if (Integer.parseInt(cursor.getString(
                cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
            String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            ContentResolver cr = context.getContentResolver();
            Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                    new String[]{id}, null);
            pCur.moveToFirst();
            contactPhoneView.setText(pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
            pCur.close();
        }
    }
}
