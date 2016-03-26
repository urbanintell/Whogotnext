package com.example.newuser.whogotnext;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;import java.lang.Override;

/**
 * Created by newuser on 12/4/15.
 */
public class ParseInit extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(this, "ctuz6QDJBBNXRDiSMcbPKvRstVONBhxop5ZUgO0c", "FYfnUGuXNAtfmMzj34TeJLUaBTMbEcoZ3GxF4TCb");
        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
