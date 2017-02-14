package com.bx.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by pjohnson on 23/01/17.
 */
public class LoginActivity extends Activity {

    private EditText userNameField;
    private EditText passwordField;
    private final static String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUI();
    }

    private void setUI() {
        userNameField = (EditText) findViewById(R.id.username);
        passwordField = (EditText) findViewById(R.id.password);
        Button button = (Button) findViewById(R.id.loginButton);

        passwordField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    login();
                    return true;
                }
                return false;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        if (isFormValidated()){
            startActivity(new Intent(LoginActivity.this, LandingActivity.class));
        }
    }

    private boolean isFormValidated() {
        if (!isValidEmail()){
            Toast.makeText(this, "Email invalido", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!isValidPassword()){
            Toast.makeText(this, "Contraseña invalida", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean isValidPassword() {
        return !TextUtils.isEmpty(passwordField.getText())
                && passwordField.getText().toString().matches(PASSWORD_REGEX);
    }

    public final boolean isValidEmail() {
        return !TextUtils.isEmpty(userNameField.getText())
                && android.util.Patterns.EMAIL_ADDRESS.matcher(userNameField.getText()).matches();
    }
}
