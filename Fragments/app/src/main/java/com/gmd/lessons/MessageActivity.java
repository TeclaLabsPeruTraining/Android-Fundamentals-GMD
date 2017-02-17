package com.gmd.lessons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gmd.lessons.fragments.AddMessageFragment;
import com.gmd.lessons.fragments.MessagesFragment;
import com.gmd.lessons.listeners.OnMessageListener;


public class MessageActivity extends AppCompatActivity implements OnMessageListener {

    private AddMessageFragment addMessageFragment;
    private MessagesFragment messagesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ui();
    }

    private void ui() {
        addMessageFragment= (AddMessageFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentAddMessage);
        messagesFragment= (MessagesFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentMessages);
    }

    @Override
    public void recibiryEnviardesdeFragment(String message) {
        messagesFragment.mostrarMensaje(message);
    }
}
