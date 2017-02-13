package com.gmd.lessons.cursoradapter;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.gmd.lessons.R;


/**
 * Created by pjohnson on 24/01/17.
 */

public class CursorAdapterActivity extends AppCompatActivity {

    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;
    private ListView cursorAdapterListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        View headerView = getLayoutInflater().inflate(R.layout.header_title, null);
        ((TextView) headerView.findViewById(R.id.headerTitle)).setText(R.string.cursorAdapterTitle);
        cursorAdapterListView = (ListView) findViewById(R.id.listview);
        cursorAdapterListView.addHeaderView(headerView);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_READ_CONTACTS);
        } else {
            mostrarContactos();
        }

    }

    private void mostrarContactos() {
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        cursorAdapterListView.setAdapter(new CursorAdapterExample(this, cur, true));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted
                mostrarContactos();
            }
        }
    }
}
