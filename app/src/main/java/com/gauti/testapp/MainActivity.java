package com.gauti.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "App Developed By Gautam Jain", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String[] activities={"Test Service","Test Custom Broadcast","Test Custom ListView","Test SQLite","Test Cam","Test Dynamic ListView","Test Create Notification","act8","act9","act10","act11","act12","act13","act14"};
        ListAdapter items=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,activities);
        ListView list=(ListView) findViewById(R.id.lvMain);
        list.setAdapter(items);

        list.setOnItemClickListener(this);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent;
        switch (position) {

            case 0:
                intent = new Intent(this, ServiceActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(this, BroadcastActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(this, ListActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(this, SQLiteActivity.class);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(this, CamActivity.class);
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(this, DynamicListViewActivity.class);
                startActivity(intent);
                break;
            case 6:
                intent = new Intent(this, NotificationActivity.class);
                startActivity(intent);
                break;

        }
    }
}
