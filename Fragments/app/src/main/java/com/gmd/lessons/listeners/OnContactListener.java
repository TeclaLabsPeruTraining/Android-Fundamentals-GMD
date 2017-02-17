package com.gmd.lessons.listeners;


import com.gmd.lessons.model.ContactEntity;

/**
 * Created by eduardomedina on 31/01/17.
 */
public interface OnContactListener {

    void onSendMessage(String msg);
    void selectedItemContact(ContactEntity contactEntity);
    void renderFirst(ContactEntity contactEntity);
}
