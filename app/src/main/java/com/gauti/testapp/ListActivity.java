package com.gauti.testapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Creates a custom defined List.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String[] diffItems={"item1","item2","item3","item4","item5","item6","item7","item8","item9"};
        ListAdapter items=new CustomAdapter(this, diffItems);
        ListView testlist=(ListView) findViewById(R.id.lvList);
        testlist.setAdapter(items);

        testlist.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String clickeditem=String.valueOf(parent.getItemAtPosition(position));
        Toast.makeText(ListActivity.this, clickeditem, Toast.LENGTH_SHORT).show();
    }
}
