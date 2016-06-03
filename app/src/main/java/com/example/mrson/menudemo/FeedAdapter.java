package com.example.mrson.menudemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.mrson.menudemo.R.layout.item_feed;

/**
 * Created by mrson on 18/06/2015.
 */
public class FeedAdapter extends BaseAdapter {
    ArrayList<Myfeed> mlist = new ArrayList<Myfeed>();
    Context mcontext;
    Myfeed myfeed;

    public FeedAdapter(ArrayList<Myfeed> mlist, Context mcontext) {
        this.mlist = mlist;
        this.mcontext = mcontext;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Myfeed getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.item_feed, parent, false);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.avar_id);
            viewHolder.name = (TextView) convertView.findViewById(R.id.title_id);
            viewHolder.url = (TextView) convertView.findViewById(R.id.url_id);
            viewHolder.status = (TextView) convertView.findViewById(R.id.status_id);
            viewHolder.profilePic = (ImageView) convertView.findViewById(R.id.img_main);
            viewHolder.isLike = (ImageView) convertView.findViewById(R.id.item_like);
            viewHolder.total_like = (TextView) convertView.findViewById(R.id.total_like);
            viewHolder.cmt = (ImageView) convertView.findViewById(R.id.coment_i);
            // viewHolder.test=(ImageView)convertView.findViewById(R.id.coment_i);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        setValue(viewHolder, position);


        return convertView;
    }

    private static class ViewHolder {
        ImageView cmt;
        ImageView image;
        TextView name;
        TextView status;
        TextView url;
        ImageView profilePic;
        ImageView isLike;
        TextView total_like;
        ImageView test;
    }

    public void setValue(final ViewHolder viewHolder, final int position) {
        myfeed = getItem(position);
        viewHolder.name.setText(myfeed.getName());
        viewHolder.url.setText(myfeed.getUrl());
        viewHolder.status.setText(myfeed.getStatus());
        Picasso.with(mcontext).load(myfeed.getImage()).into(viewHolder.image);
        Picasso.with(mcontext).load(myfeed.getProfilePic()).into(viewHolder.profilePic);
//      viewHolder.test.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View v) {
//              Toast toast=Toast.makeText(mcontext,"click test",Toast.LENGTH_SHORT);
//              toast.show();
//              Intent intent= new Intent(mcontext,ComentActivity.class);
//        mcontext.startActivity(intent);
//          }
//      });
        viewHolder.cmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//             Toast toast=Toast.makeText(mcontext,"click test",Toast.LENGTH_SHORT);
//             toast.show();
//             Intent intent= new Intent(mcontext,ComentActivity.class);
//             mcontext.startActivity(intent);
                Intent intent = new Intent().setClass(v.getContext(), ComentActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
            }
        });

        if (myfeed.isLike() == true) {
            viewHolder.isLike.setBackgroundResource(R.drawable.like_bo_check);
        } else {

            viewHolder.isLike.setBackgroundResource(R.drawable.like_bo);
        }


        viewHolder.isLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = (View) v.getParent();
                ImageView image = (ImageView) view.findViewById(R.id.item_like);
                TextView total_like = (TextView) view.findViewById(R.id.total_like);

                int myNum = 0;

                myNum = Integer.parseInt(total_like.getText().toString());

                if (mlist.get(position).isLike() == true) {
                    image.setBackgroundResource(R.drawable.like_bo);
                    myNum = myNum - 1;
                    // people.setFollow(false);
                    mlist.get(position).setIsLike(false);
                } else {

                    image.setBackgroundResource(R.drawable.like_bo_check);
                    myNum = myNum + 1;
                    // people.setFollow(true);
                    mlist.get(position).setIsLike(true);
                }
                String tt;
                tt = String.valueOf(myNum);
                viewHolder.total_like.setText(tt);


            }
        });


    }

    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

}
