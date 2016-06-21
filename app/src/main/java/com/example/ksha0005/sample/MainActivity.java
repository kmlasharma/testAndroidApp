package com.example.ksha0005.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {

    public EditText username;
    public EditText password;
    public Button login;
    public TextView loginLockedTV;
    public TextView attemptsLeftTV;
    public TextView numberOfRemainingLoginAttemptsTV;
    public static String USERNAME = "admin";
    public static String PASSWORD = "Admin";
    int numberOfRemainingLoginAttempts = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupVariables();
    }

    public void authenticateLogin(View view) {

        if (checkLogin(username.getText().toString(), username.getText().toString()))
        {
            Toast.makeText(getApplicationContext(), getString(R.string.successfulLoginIn), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, WelcomeActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(getApplicationContext(), getString(R.string.failedLoginIn),
                    Toast.LENGTH_SHORT).show();
            numberOfRemainingLoginAttempts = updateAttempt(numberOfRemainingLoginAttempts);
            attemptsLeftTV.setVisibility(View.VISIBLE);
            numberOfRemainingLoginAttemptsTV.setVisibility(View.VISIBLE);
            numberOfRemainingLoginAttemptsTV.setText(Integer.toString(numberOfRemainingLoginAttempts));

            if (checkAttempt(numberOfRemainingLoginAttempts))
            {
                openPopUp();
                login.setEnabled(false);
                loginLockedTV.setVisibility(View.VISIBLE);
                loginLockedTV.setBackgroundColor(Color.RED);
                loginLockedTV.setText(R.string.lockedLabel);
            }
        }
    }



    public void setupVariables() {
        username = (EditText) findViewById(R.id.usernameET);
        password = (EditText) findViewById(R.id.passwordET);
        login = (Button) findViewById(R.id.loginBtn);
        loginLockedTV = (TextView) findViewById(R.id.loginLockedTV);
        attemptsLeftTV = (TextView) findViewById(R.id.attemptsLeftTV);
        numberOfRemainingLoginAttemptsTV = (TextView) findViewById(R.id.numberOfRemainingLoginAttemptsTV);
        numberOfRemainingLoginAttemptsTV.setText(Integer.toString(numberOfRemainingLoginAttempts));
    }

    public void openPopUp() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(R.string.outOfAttemptsLabel);

        alertDialogBuilder.setPositiveButton(R.string.posOption, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(MainActivity.this,R.string.positveMessage,Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    public int updateAttempt(int attempt) {
        attempt--;
        return attempt;
    }

    public boolean checkAttempt(int attempt) {
        return (attempt == 0);
    }

    public boolean checkLogin(String name, String password) {
        if (name.equals(USERNAME) && password.equals(PASSWORD))
            return true;
        return false;
    }


}