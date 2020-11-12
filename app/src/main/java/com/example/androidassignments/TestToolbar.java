package com.example.androidassignments;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TestToolbar extends AppCompatActivity {
    protected String snackText = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toolbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Floating Action Button option selected", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.toolbar_menu, m);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem mi){
        final EditText changeSnack = new EditText(TestToolbar.this);

        switch(mi.getItemId())
        {
            case R.id.one:
                Log.d("Toolbar", "Option 1 selected");
                if (snackText == "") {
                    Snackbar.make(this.findViewById(android.R.id.content), "Option 1 selected", Snackbar.LENGTH_SHORT).show();
                } else {
                    Snackbar.make(this.findViewById(android.R.id.content), snackText, Snackbar.LENGTH_SHORT).show();
                }
            break;
            case R.id.two:
                Log.d("Toolbar", "Option 2 selected");
                AlertDialog.Builder builder = new AlertDialog.Builder(TestToolbar.this);
                builder.setTitle(R.string.GoBack);
                // Add the buttons
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        finish();
                    }
                });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
                // Create the AlertDialog
                AlertDialog dialog = builder.create();
                dialog.show();

                break;
            case R.id.three:
                Log.d("Toolbar", "Option 3 selected");
                AlertDialog.Builder builder1 = new AlertDialog.Builder(TestToolbar.this);
                LayoutInflater inflater = TestToolbar.this.getLayoutInflater();
                builder1.setView(inflater.inflate(R.layout.activity_test_toolbar, null));
                builder1.setTitle(R.string.ChangeSnack);

                builder1.setView(changeSnack);
                builder1.setIcon(R.drawable.trophy);

                builder1.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // User clicked OK button
                        snackText = changeSnack.getText().toString();
                    }
                });
                builder1.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // User cancelled the dialog
                    }
                });
                // Create the AlertDialog
                AlertDialog dialog1 = builder1.create();
                dialog1.show();
            break;
            case R.id.about:
                Toast.makeText(this, "version 1.0, by Brian Chan", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}