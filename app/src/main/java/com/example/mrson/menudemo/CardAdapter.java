package com.example.mrson.menudemo;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrson on 07/07/2015.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    Context mcontext;
    List<Myfeed> mlist = new ArrayList<Myfeed>();
    //ArrayList<Myfeed> mlist = new ArrayList<Myfeed>();

    Myfeed po_cmt;

//    public CardAdapter() {
//        super();
//
//
//        getMyfeed();
//
//    }

    public CardAdapter(Context mcontext, List<Myfeed> mlist) {
        this.mcontext = mcontext;
        this.mlist = mlist;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Myfeed myfeeditem = mlist.get(position);
        holder.txtuser.setText(myfeeditem.getName());

        Picasso.with(mcontext).load(myfeeditem.getImage()).into(holder.imgvartar);
        Picasso.with(mcontext).load(myfeeditem.getProfilePic()).into(holder.imgmain);
        holder.txtstatus.setText(myfeeditem.getStatus());
        holder.cmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//             Toast toast=Toast.makeText(mcontext,"click test",Toast.LENGTH_SHORT);
//             toast.show();
//             Intent intent= new Intent(mcontext,ComentActivity.class);
//             mcontext.startActivity(intent);

                //   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                po_cmt = new Myfeed();
                po_cmt.setName(mlist.get(position).getName());
                po_cmt.setStatus(mlist.get(position).getStatus());
                po_cmt.setTotal_like(mlist.get(position).getTotal_like());
                po_cmt.setImage(mlist.get(position).getImage());
                po_cmt.setProfilePic(mlist.get(position).getProfilePic());
                //  String a=  po_cmt.setImage(mlist.get(position).getImage());
                //  byte[] image = mlist.get(position).getImage().getBytes();


                Intent intent = new Intent().setClass(v.getContext(), ComentActivity.class);


                intent.putExtra("obj", po_cmt);

                v.getContext().startActivity(intent);

            }
        });

        if (myfeeditem.isLike() == true) {
            holder.islike.setBackgroundResource(R.drawable.like_bo_check);
        } else {

            holder.islike.setBackgroundResource(R.drawable.like_bo);
        }
        holder.islike.setOnClickListener(new View.OnClickListener() {
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
                holder.total_like.setText(tt);


            }
        });


    }


    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgvartar;
        public TextView txtuser;
        public TextView txtstatus;
        public ImageView imgmain;
        public ImageView islike;
        public TextView total_like;
        public ImageView cmt;

        public ViewHolder(View itemView) {
            super(itemView);
            imgvartar = (ImageView) itemView.findViewById(R.id.avar_id);
            txtuser = (TextView) itemView.findViewById(R.id.username);
            txtstatus = (TextView) itemView.findViewById(R.id.status_id);
            imgmain = (ImageView) itemView.findViewById(R.id.img_main);
            islike = (ImageView) itemView.findViewById(R.id.item_like);
            total_like = (TextView) itemView.findViewById(R.id.total_like);
            cmt = (ImageView) itemView.findViewById(R.id.coment_i);
        }
    }
}
