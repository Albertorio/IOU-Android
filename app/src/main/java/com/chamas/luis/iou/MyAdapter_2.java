package com.chamas.luis.iou;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Luis on 2/14/2015.
 */
public class MyAdapter_2 extends ArrayAdapter<items>{

    private final Context context;
    private final ArrayList<items> itemsArrayList;
    public MyAdapter_2(Context context,  ArrayList<items> itemsArrayList) {
        super(context, R.layout.custom_row_layout, itemsArrayList);
        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.custom_row_layout, parent, false);

        TextView name = (TextView)rowView.findViewById(R.id.PersonNameTextView);
        TextView price = (TextView)rowView.findViewById(R.id.PersonPriceTextView);

        name.setText(itemsArrayList.get(position).getName());
        price.setText(itemsArrayList.get(position).getPrice());

        return rowView;
    }
}
