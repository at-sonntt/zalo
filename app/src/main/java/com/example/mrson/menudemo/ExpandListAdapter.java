package com.example.mrson.menudemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrson.menudemo.peoples.CircleImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Tuy on 6/29/2015.
 */

public class ExpandListAdapter extends ArrayAdapter<Group_Expand> {

    private final Context context;
    private final ArrayList<Group_Expand> modelsArrayList;

    public ExpandListAdapter(Context context, ArrayList<Group_Expand> modelsArrayList) {

        super(context, R.layout.list_item, modelsArrayList);

        this.context = context;
        this.modelsArrayList = modelsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater

        View rowView = null;
        if(!modelsArrayList.get(position).isGroupHeader()){
            rowView = inflater.inflate(R.layout.list_item, parent, false);

            // 3. Get icon,title & counter views from the rowView
            CircleImageView imgView = (CircleImageView) rowView.findViewById(R.id.item_icon);
            TextView titleView = (TextView) rowView.findViewById(R.id.item_title);


            // 4. Set the text for textView
            imgView.setImageResource(modelsArrayList.get(position).getIcon());
            titleView.setText(modelsArrayList.get(position).getTitle());

        }
        else{
            rowView = inflater.inflate(R.layout.list_group, parent, false);
            TextView titleView = (TextView) rowView.findViewById(R.id.header);
            titleView.setText(modelsArrayList.get(position).getTitle());

        }

        // 5. retrn rowView
        return rowView;
    }
}
