package com.gauti.testapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLiteActivity extends AppCompatActivity {

    EditText inp;
    TextView out;
    MyDBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Adds and Deletes data to database, which is saved even after the app is closed.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inp=(EditText) findViewById(R.id.editText);
        out=(TextView) findViewById(R.id.tvDisplay);
        dbHandler=new MyDBHandler(this,null,null,1);
        printDatabase();



    }

    public void addButtonClicked(View view){
        Products product = new Products(inp.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }

    public  void  deleteButtonClicked(View view){
        String inputText=inp.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();

    }

    public void printDatabase(){
        String dbString=dbHandler.databaseToString();
        out.setText(dbString);
        inp.setText("");
    }



}
