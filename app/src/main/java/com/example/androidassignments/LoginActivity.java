package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME = "LoginActivity";
    public static final String EMAIL = "EMAIL";
    private EditText email;
    private Button loginButton;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        email = (EditText) findViewById(R.id.emailEditText);
        loginButton = (Button) findViewById(R.id.button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveEmail();
            }
        });
        loadEmail();
    }

    public void saveEmail() {
        SharedPreferences sharedPreferences = getSharedPreferences(ACTIVITY_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(EMAIL, email.getText().toString());
        editor.commit();

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void loadEmail() {
        SharedPreferences sharedPreferences = getSharedPreferences(ACTIVITY_NAME, MODE_PRIVATE);
        text = sharedPreferences.getString(EMAIL, "email@domain.com");
        email.setText(text);
    }

    public void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME, "in onResume()");
    }

    public void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME, "in onStart()");
    }

    public void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME, "in onPause()");
    }

    public void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME, "in onStop()");
    }

    public void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "in onDestroy()");
    }
}