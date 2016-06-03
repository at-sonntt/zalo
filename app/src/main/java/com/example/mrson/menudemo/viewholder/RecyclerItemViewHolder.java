package com.example.mrson.menudemo.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrson.menudemo.Myfeed;
import com.example.mrson.menudemo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
    ArrayList<Myfeed> mlist= new ArrayList<Myfeed>();
    Context mcontext;
    Myfeed myfeed;

    // private final TextView mItemTextView11;
   // private final TextView mItemTextView;

    private final ImageView avatar;
    private final TextView username;
    private final TextView status;
    private final ImageView imgmain;
    private final TextView total_like;
    private final ImageView coment_i;

    public RecyclerItemViewHolder(final View parent, ImageView avatar, TextView username, TextView status, ImageView imgmain, TextView total_like, ImageView coment_i) {
        super(parent);
       // mItemTextView = itemTextView;
//        textViewl=test;


        this.avatar = avatar;
        this.username = username;
        this.status = status;
        this.imgmain = imgmain;
        this.total_like = total_like;
        this.coment_i = coment_i;
    }



    public static RecyclerItemViewHolder newInstance(View parent) {
       // TextView itemTextView = (TextView) parent.findViewById(R.id.itemTextView);
        TextView status=(TextView)parent.findViewById(R.id.status_id);
        TextView username=(TextView)parent.findViewById(R.id.username);
        ImageView avatar=(ImageView)parent.findViewById(R.id.avar_id);
        ImageView imgmain=(ImageView)parent.findViewById(R.id.img_main);
        TextView total_like=(TextView)parent.findViewById(R.id.total_like);
        ImageView coment_i=(ImageView)parent.findViewById(R.id.coment_i);

       // TextView itemTextView1 = (TextView) parent.findViewById(R.id.test);
        return new RecyclerItemViewHolder(parent, avatar, username, status, imgmain, total_like, coment_i);
    }

    public void setItemText(CharSequence text) {
       // myfeed= getItem(position);

      //  mItemTextView.setText(text);
      //  status.setText("dsdsfds");
//        textViewl.setText("dsfds");
    }
    public void setUsername(String user){

        username.setText(myfeed.getName());
    }
    public void setavatar(String mavatar){
        Picasso.with(mcontext).load(myfeed.getImage()).into(avatar);
    }
    public void setimgmain(String mimgmain){
        Picasso.with(mcontext).load(myfeed.getImage()).into(imgmain);
    }

}
