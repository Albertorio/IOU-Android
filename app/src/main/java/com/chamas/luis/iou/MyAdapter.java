package com.chamas.luis.iou;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.HashMap;

class MyAdapter extends ArrayAdapter<String> {
    public MyAdapter(Context context, String[] names) {
        super(context,R.layout.custom_row_layout,names);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View theView = inflater.inflate(R.layout.custom_row_layout, parent, false);

        String name = getItem(position);
        TextView nameView = (TextView)theView.findViewById(R.id.PersonNameTextView);

        nameView.setText(name);

//        String price = getItem(position+1);
//        TextView priceView = (TextView) theView.findViewById(R.id.PersonPriceTextView);
//        priceView.setText(price);

        return theView;
    }
}