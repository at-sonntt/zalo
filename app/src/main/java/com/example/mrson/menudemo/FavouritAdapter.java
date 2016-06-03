package com.example.mrson.menudemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mrson.menudemo.peoples.CircleImageView;

import java.util.ArrayList;
import java.util.logging.Filter;

/**
 * Created by Tuy on 7/2/2015.
 */
public class FavouritAdapter extends ArrayAdapter<Favourit> implements Filterable {
    private final Context context;
    public ArrayList<Favourit> modelsArrayList;
    public ArrayList<Favourit> orig;

    public FavouritAdapter(Context context, ArrayList<Favourit> modelsArrayList) {

        super(context, R.layout.list_item, modelsArrayList);

        this.context = context;
        this.modelsArrayList = modelsArrayList;
//        this.modelsArrayList = new ArrayList<Favourit>();
//        this.modelsArrayList.addAll(modelsArrayList);
        this.orig = new ArrayList<Favourit>();
        this.orig.addAll(modelsArrayList);
    }

    public android.widget.Filter getFilter() {

        return new android.widget.Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                constraint = constraint.toString().toLowerCase();

                FilterResults result = new FilterResults();


                try {
                    if (constraint != null && constraint.toString().length() > 0) {
                        ArrayList<Favourit> founded = new ArrayList<Favourit>();
                        for (Favourit item : modelsArrayList) {
                            if (item.getTitle().toString().toLowerCase().contains(constraint)) {

                                founded.add(item);

                            }
                        }

                        result.values = founded;
                        result.count = founded.size();

                    } else {
                        result.values = orig;
                        result.count = orig.size();


                    }
                } catch (Exception e) {
                    result.values = null;
                    result.count = 0;
                }
                return result;

            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                modelsArrayList.clear();

                try {
                    modelsArrayList.addAll((ArrayList<Favourit>) results.values);
                } catch (Exception e) {
                    modelsArrayList.clear();
                }

                notifyDataSetChanged();
            }
        };
    }

    //    public void notifyDataSetChanged() {
//        super.notifyDataSetChanged();
//    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater

        View rowView = null;
//        Log.d("size----->", String.valueOf(modelsArrayList.size()));
//        Log.d("----->", String.valueOf(modelsArrayList.get(position)));
        if (!modelsArrayList.get(position).isGroupHeader()) {
            rowView = inflater.inflate(R.layout.list_item, parent, false);

            // 3. Get icon,title & counter views from the rowView
            CircleImageView imgView = (CircleImageView) rowView.findViewById(R.id.item_icon);
            TextView titleView = (TextView) rowView.findViewById(R.id.item_title);


            // 4. Set the text for textView
            imgView.setImageResource(modelsArrayList.get(position).getIcon());
            titleView.setText(modelsArrayList.get(position).getTitle());

        } else {
            rowView = inflater.inflate(R.layout.list_group, parent, false);
            TextView titleView = (TextView) rowView.findViewById(R.id.header);
            titleView.setText(modelsArrayList.get(position).getTitle());

        }

        // 5. retrn rowView
        return rowView;
    }
}
