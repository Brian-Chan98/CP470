package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME = "MainActivity";
    private Button listItemsButton;
    private Button chatWindowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        listItemsButton = (Button) findViewById(R.id.listItem_Button);
        chatWindowButton = (Button) findViewById(R.id.chatWindow_Button);

        listItemsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListItemsActivity.class);
                startActivityForResult(intent, 10);
            }
        });

        chatWindowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(ACTIVITY_NAME, "User Clicked Start Chat");
                Intent intent = new Intent(MainActivity.this, ChatWindow.class);
                startActivity(intent);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 10 && resultCode == Activity.RESULT_OK){
            String messagePassed = data.getStringExtra("Response");
            Toast.makeText(MainActivity.this, messagePassed, Toast.LENGTH_SHORT).show();
            Log.i(ACTIVITY_NAME, "Returned through OnActivityResult");
        }
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