package com.gauti.testapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DynamicListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView lv;
    EditText inp;
    ArrayList a=new ArrayList<String >();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_list_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Creates a dynamic list in which the data can be added manually.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lv=(ListView) findViewById(R.id.lvDynamic);
        inp=(EditText) findViewById(R.id.etAddToList);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,a);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);



    }

    public  void addToList(View view){
        String newItem=inp.getText().toString();
        a.add(newItem);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String clickeditem=String.valueOf(parent.getItemAtPosition(position));
        Toast.makeText(DynamicListViewActivity.this, clickeditem, Toast.LENGTH_SHORT).show();

    }
}
