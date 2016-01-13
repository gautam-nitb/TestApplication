package com.gauti.testapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Gauti on 1/11/2016.
 */
public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="products.db";
    private static final String TABLE_PRODUCTS="products";
    private static final String COLUMN_ID="_id";
    private static final String COLUMN_PRODUCTNAME="productName";


    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+ TABLE_PRODUCTS + " ( "
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,  "
                + COLUMN_PRODUCTNAME + " TEXT "
                + ");";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_PRODUCTS);
        onCreate(db);

    }

    // Add a new row to db
    public   void addProduct(Products product){
        ContentValues values=new ContentValues();
        values.put(COLUMN_PRODUCTNAME, product.get_productName());


            SQLiteDatabase db=getWritableDatabase();
            db.insert(TABLE_PRODUCTS, null, values);
            db.close();

        }




    //To delete  a row in table
    public void  deleteProduct(String productName){
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME + "=\"" + productName + "\";");

    }

    // Print out the db  as string
    public  String databaseToString(){
        String dbString="";
        SQLiteDatabase db=getWritableDatabase();
        String query="SELECT * FROM "+ TABLE_PRODUCTS + "";

        // Cursor point to a location in your results

            Cursor c = db.rawQuery(query, null);
            c.moveToFirst();


            while (c.moveToNext()) {
                if (c.getString(c.getColumnIndex("productName")) != null) {
                    dbString += c.getString(c.getColumnIndex("productName"));
                    dbString += "\n";

                }
           }


        db.close();
        return dbString;

    }

}


