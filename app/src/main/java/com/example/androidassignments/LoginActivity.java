package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME = "LoginActivity";
    static final String LOGIN_EMAIL = "loginEmail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.i(ACTIVITY_NAME, "In onCreate()");

        final SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        final EditText loginEditText = (EditText) findViewById(R.id.loginEdit);
        final Button loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginId = String.valueOf(loginEditText.getText());

                if(loginId.length() == 0) {
                    Toast.makeText(LoginActivity.this, R.string.login_id_is_empty, Toast.LENGTH_LONG).show();
                }
                else {
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString(LOGIN_EMAIL, loginId);
                    editor.commit();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        String savedLoginId = sharedPref.getString(LOGIN_EMAIL, "");
        if(!(savedLoginId == "")) {
            savedLoginId = sharedPref.getString(LOGIN_EMAIL, "");
            loginEditText.setText(savedLoginId);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }
}
