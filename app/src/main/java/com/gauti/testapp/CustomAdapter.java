package com.gauti.testapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Gauti on 1/11/2016.
 */
public class CustomAdapter extends ArrayAdapter<String> {
    public CustomAdapter(Context context, String[] diffItems) {
        super(context,R.layout.custom_row ,diffItems);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater gautamInflater=LayoutInflater.from(getContext());
        View CustomView =gautamInflater.inflate(R.layout.custom_row, parent, false);

        String singleItem=getItem(position);
        TextView text=(TextView) CustomView.findViewById(R.id.tvListText);
        ImageView image=(ImageView) CustomView.findViewById(R.id.ivListImage);

        text.setText(singleItem);
        image.setImageResource(R.drawable.ic_launcher);


        return CustomView;
        //return super.getView(position, convertView, parent);



    }
}
