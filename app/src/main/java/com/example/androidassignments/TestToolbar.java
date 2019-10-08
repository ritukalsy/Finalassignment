package com.example.androidassignments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TestToolbar extends AppCompatActivity {

    private String snackMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toolbar);

        snackMessage = new String();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_one:
                Log.d("Toolbar", "Toolbar action_one is selected");
                View view = findViewById(R.id.action_one);
                if(snackMessage.isEmpty()) {
                    snackMessage = getResources().getText(R.string.toolbar_action_plus).toString();
                }
                Snackbar.make(view, snackMessage, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;

            case R.id.action_two:
                Log.d("Toolbar", "Toolbar action_two is selected");
                onBackClicked();
                break;

                case R.id.action_three:
                Log.d("Toolbar", "Toolbar action_three is selected");
                onShareClicked();
                break;

            case R.id.action_four:
                Log.d("Toolbar", "Toolbar action_four is selected");
                Toast.makeText(this, "Version 1.0 by Ritu Kalsy", Toast.LENGTH_LONG).show();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void onBackClicked() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle(getResources().getText(R.string.do_you_want_to_go_back));

        alertBuilder.setPositiveButton(getResources().getText(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertBuilder.setNegativeButton(getResources().getText(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("CANCEL", "Cancel Clicked");
            }
        });

        AlertDialog dialog = alertBuilder.create();
        dialog.show();
    }

    private void onShareClicked() {
        final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();

        View mView = inflater.inflate(R.layout.dialog_change, null);
        final EditText newSnackMessage = (EditText)mView.findViewById(R.id.snack_text);

        alertBuilder.setView(mView);

        alertBuilder.setPositiveButton(getResources().getText(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if(!newSnackMessage.getText().toString().isEmpty()) {
                    snackMessage = newSnackMessage.getText().toString();
                }
                else {
                    Toast.makeText(TestToolbar.this, getResources().getText(R.string.the_field_is_empty), Toast.LENGTH_LONG).show();
                }
            }
        });

        alertBuilder.setNegativeButton(getResources().getText(R.string.cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d("CANCEL", "Cancel Clicked");
            }
        });
        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.show();
    }

}
