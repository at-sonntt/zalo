package com.example.mrson.menudemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mrson.menudemo.peoples.CircleImageView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by Tuy on 7/2/2015.
 */
public class TeamAdapter extends BaseAdapter {
    Context m_context;
    ArrayList<Team> arrayList;
    Team friend;
    public ArrayList<Team> orig;


    public TeamAdapter(Context context, ArrayList<Team> peo_ple) {
        this.m_context = context;
        this.arrayList = peo_ple;
        this.orig = new ArrayList<Team>();
        this.orig.addAll(peo_ple);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Team getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    Button bntfl;

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;

        if (convertView == null) {

            convertView = LayoutInflater.from(m_context).inflate(R.layout.team_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.l1 = (RelativeLayout) convertView.findViewById(R.id.layout1);
            viewHolder.l2 = (RelativeLayout) convertView.findViewById(R.id.layout2);
            viewHolder.l3 = (RelativeLayout) convertView.findViewById(R.id.layout3);
            viewHolder.l1_img1 = (CircleImageView) convertView.findViewById(R.id.l1_img1);
            viewHolder.l1_img2 = (CircleImageView) convertView.findViewById(R.id.l1_img2);
            viewHolder.l2_img1 = (CircleImageView) convertView.findViewById(R.id.l2_img1);
            viewHolder.l2_img2 = (CircleImageView) convertView.findViewById(R.id.l2_img2);
            viewHolder.l2_img3 = (CircleImageView) convertView.findViewById(R.id.l2_img3);
            viewHolder.l3_img1 = (CircleImageView) convertView.findViewById(R.id.l3_img1);
            viewHolder.l3_img2 = (CircleImageView) convertView.findViewById(R.id.l3_img2);
            viewHolder.l3_img3 = (CircleImageView) convertView.findViewById(R.id.l3_img3);
            viewHolder.l3_img4 = (CircleImageView) convertView.findViewById(R.id.l3_img4);
            viewHolder.txt_name = (TextView) convertView.findViewById(R.id.text);


            convertView.setTag(viewHolder);


        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }

        setValue(viewHolder, position);

        return convertView;
    }

    public android.widget.Filter getFilter() {

        return new android.widget.Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                constraint = constraint.toString().toLowerCase();

                FilterResults result = new FilterResults();


                try {
                    if (constraint != null && constraint.toString().length() > 0) {
                        ArrayList<Team> founded = new ArrayList<Team>();
                        for (Team item : arrayList) {
                            if (item.getName().toString().toLowerCase().contains(constraint)) {

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

                arrayList.clear();

                try {
                    arrayList.addAll((ArrayList<Team>) results.values);
                } catch (Exception e) {
                    arrayList.clear();
                }

                notifyDataSetChanged();
            }
        };
    }

    private static class ViewHolder {
        RelativeLayout l1;
        RelativeLayout l2;
        RelativeLayout l3;
        CircleImageView l1_img1;
        CircleImageView l1_img2;
        CircleImageView l2_img1;
        CircleImageView l2_img2;
        CircleImageView l2_img3;
        CircleImageView l3_img1;
        CircleImageView l3_img2;
        CircleImageView l3_img3;
        CircleImageView l3_img4;

        TextView txt_name;


    }

    private String encode(String a) {
        try {
            a = URLEncoder.encode(a, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return a;
    }

    private void setValue(final ViewHolder holder, final int position) {
        friend = getItem(position);

        // Get your images from their files
        if (friend.getType() == 2) {
            holder.l1.setVisibility(View.VISIBLE);
            holder.l2.setVisibility(View.INVISIBLE);
            holder.l3.setVisibility(View.INVISIBLE);
            holder.l1_img1.setImageResource(friend.getLogo().get(0));
            holder.l1_img2.setImageResource(friend.getLogo().get(1));
            holder.txt_name.setText(friend.getName().get(0) + ", " + friend.getName().get(1));
        } else if (friend.getType() == 3) {
            holder.l1.setVisibility(View.INVISIBLE);
            holder.l2.setVisibility(View.VISIBLE);
            holder.l3.setVisibility(View.INVISIBLE);
            holder.l2_img1.setImageResource(friend.getLogo().get(0));
            holder.l2_img2.setImageResource(friend.getLogo().get(1));
            holder.l2_img3.setImageResource(friend.getLogo().get(2));
            holder.txt_name.setText(friend.getName().get(0) + ", " + friend.getName().get(1) + "," + friend.getName().get(2));
        } else {
            holder.l1.setVisibility(View.INVISIBLE);
            holder.l2.setVisibility(View.INVISIBLE);
            holder.l3.setVisibility(View.VISIBLE);
            holder.l3_img1.setImageResource(friend.getLogo().get(0));
            holder.l3_img2.setImageResource(friend.getLogo().get(1));
            holder.l3_img3.setImageResource(friend.getLogo().get(2));
            holder.l3_img4.setImageResource(friend.getLogo().get(3));
            holder.txt_name.setText(friend.getName().get(0) + ", " + friend.getName().get(1) + ", " + friend.getName().get(2) + ", " + friend.getName().get(3));
        }

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
