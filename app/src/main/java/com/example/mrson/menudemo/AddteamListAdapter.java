package com.example.mrson.menudemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mrson.menudemo.peoples.CircleImageView;

import java.util.ArrayList;

import static com.example.mrson.menudemo.R.layout.list_item;

/**
 * Created by Tuy on 7/8/2015.
 */
public class AddteamListAdapter extends ArrayAdapter<Model_addteam> {

    private final Context context;
    private final ArrayList<Model_addteam> modelsArrayList;
    public ArrayList<Model_addteam> orig;

    public AddteamListAdapter(Context context, ArrayList<Model_addteam> modelsArrayList) {

        super(context, R.layout.addteam_listview_item, modelsArrayList);

        this.context = context;
        this.modelsArrayList = modelsArrayList;
        this.orig = new ArrayList<Model_addteam>();
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
                        ArrayList<Model_addteam> founded = new ArrayList<Model_addteam>();
                        for (Model_addteam item : modelsArrayList) {
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
                    modelsArrayList.addAll((ArrayList<Model_addteam>) results.values);
                } catch (Exception e) {
                    modelsArrayList.clear();
                }

                notifyDataSetChanged();
            }
        };
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater

        View rowView = null;
        if (!modelsArrayList.get(position).isGroupHeader()) {
            rowView = inflater.inflate(R.layout.addteam_listview_item, parent, false);

            // 3. Get icon,title & counter views from the rowView
            CircleImageView imgView = (CircleImageView) rowView.findViewById(R.id.item_icon);
            TextView titleView = (TextView) rowView.findViewById(R.id.item_title);
            final CheckBox checkBox = (CheckBox) rowView.findViewById(R.id.checkbox);

            // 4. Set the text for textView
            imgView.setImageResource(modelsArrayList.get(position).getIcon());
            titleView.setText(modelsArrayList.get(position).getTitle());
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (checkBox.isChecked()) {
                        // View v = v.getParent();
                        modelsArrayList.get(position).setCheck(true);
                        //Toast.makeText(context, String.valueOf(modelsArrayList.get(position).isCheck()), Toast.LENGTH_SHORT).show();
                    } else {
                        modelsArrayList.get(position).setCheck(false);
                    }
                }
            });


        } else {
            rowView = inflater.inflate(R.layout.list_group, parent, false);
            TextView titleView = (TextView) rowView.findViewById(R.id.header);
            titleView.setText(modelsArrayList.get(position).getTitle());

        }

        // 5. retrn rowView
        return rowView;
    }
}
