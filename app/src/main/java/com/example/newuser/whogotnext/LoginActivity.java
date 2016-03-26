package com.example.newuser.whogotnext;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;
import com.parse.ParseUser;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {



    // UI references.
    private EditText userName;
    private EditText passwordText;
    private Button logInButton;
    private TextView signUpText;
    private LoginButton faceBookButton;
    String name;
    String email;
    ParseUser parseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set up the login form.
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);
//        faceBookButton = (LoginButton) findViewById(R.id.facebook_login_button);


        // Set up the login form.
        userName = (EditText) findViewById(R.id.userName);
//        populateAutoComplete();
        passwordText = (EditText) findViewById(R.id.input_password);
        logInButton = (Button)findViewById(R.id.button_login);
        signUpText = (TextView)findViewById(R.id.link_signup);

        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });

    }


    public void signUp(){
        Intent signUpIntent = new Intent(getApplicationContext(), SignUpActivity.class);
        startActivity(signUpIntent);
    }




}

