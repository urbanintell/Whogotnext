package com.example.newuser.whogotnext;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class ChooseActivity extends AppCompatActivity {

    List<Event> mList=new ArrayList<Event>();
    SportsListAdapter arrayAdapter=null;
    ListView sportsListView;
    String objectId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        sportsListView=(ListView)findViewById(R.id.sports_list_view);
        objectId= ParseUser.getCurrentUser().getObjectId();

        queryEvents();
        sportsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = parent.getItemAtPosition(position);
                Log.v("HERE ERROR","CLICKED HERE");
                Intent toEventActivity = new Intent(getApplicationContext(), ListOfSessionActivity.class);
                toEventActivity.putExtra("Name", item.toString());
                ParseUser currentUser = ParseUser.getCurrentUser();
                startActivity(toEventActivity);
            }
        });

      
    }



    private void queryEvents() {
        ParseQuery<Event> query = ParseQuery.getQuery("Event");
        query.findInBackground(new FindCallback<Event>() {
            @Override
            public void done(List<Event> objectList, ParseException e) {
                if(e==null){
                  mList=objectList;
                  arrayAdapter=new SportsListAdapter(getApplicationContext(),objectId,mList);
                  sportsListView.setAdapter(arrayAdapter);
                  arrayAdapter.notifyDataSetChanged();

                }
                else{
                    Log.e("Error",e.toString());
                    Toast.makeText(getApplicationContext(),"Error Loading Events",Toast.LENGTH_LONG).show();
                }

            }
        });
    }







}
