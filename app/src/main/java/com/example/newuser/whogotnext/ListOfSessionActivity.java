package com.example.newuser.whogotnext;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ListOfSessionActivity extends AppCompatActivity {

    private FloatingActionButton fabButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_events);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fabButton = (FloatingActionButton) findViewById(R.id.fab);

        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent creteSession = new Intent(getApplicationContext(),CreateSessionActivty.class);
                startActivity(creteSession);
            }
        });
    }

}
