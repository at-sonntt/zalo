package com.example.mrson.menudemo;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mrson.menudemo.peoples.AwesomeAdapter;
import com.example.mrson.menudemo.peoples.Message;
import com.example.mrson.menudemo.peoples.PeoPle;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by Tuy on 7/1/2015.
 */
public class FriendAdapter extends BaseAdapter{
    Context m_context;
    ArrayList<Friend> arrayList ;
    Friend friend;



    public FriendAdapter(Context context, ArrayList<Friend> peo_ple) {
        this.m_context = context;
        this.arrayList = peo_ple;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Friend getItem(int position) {
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

        if(convertView==null){

            convertView= LayoutInflater.from(m_context).inflate(R.layout.friend_item,parent,false);
            viewHolder= new ViewHolder();
            viewHolder.img_ava=(ImageView) convertView.findViewById(R.id.img_peo);
            viewHolder.txt_name=(TextView)convertView.findViewById(R.id.txt_peo);

            viewHolder.frag=(ImageView) convertView.findViewById((R.id.fr));
            viewHolder.txt_message=(TextView) convertView.findViewById(R.id.txt_message);
            viewHolder.rlmain=(RelativeLayout) convertView.findViewById(R.id.rlmain);



            // viewHolder.textView = (TextView) convertView.findViewById(R.id.text);
            // bntfl=(Button)convertView.findViewById(R.id.btn_f);
             viewHolder.folow=(Button)convertView.findViewById(R.id.button);

            convertView.setTag(viewHolder);


        }else {
            viewHolder= (ViewHolder) convertView.getTag();

        }

        setValue(viewHolder, position);

        return convertView;
    }




    private static class  ViewHolder{
        ImageView img_ava;
        TextView txt_name;
        TextView txt_message;
        Button folow;
        ImageView frag;
        static ImageView test1;
        RelativeLayout rlmain;

    }

    private String encode(String a){
        try {
            a = URLEncoder.encode(a, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return a;
    }
    private void setValue(final ViewHolder holder, final int position) {
        friend = getItem(position);
        holder.img_ava.setImageResource(friend.getAvatar());
        holder.txt_name.setText(friend.getName());
        holder.txt_message.setText(friend.getMessage());


        if(friend.isFollow()==true){
            holder.folow.setText("Dong y");
            holder.folow.setTextSize(15);
            holder.folow.setTextColor(Color.WHITE);
            holder.folow.setBackgroundResource(R.drawable.accept_button);
        }else{
            holder.folow.setText(encode("Them"));
            holder.folow.setTextColor(0xFF3090C7);
            holder.folow.setTextSize(15);
            holder.folow.setBackgroundResource(R.drawable.button_radius);

        }

           //holder.folow=friend.isFollow();


        holder.folow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view=(View)v.getParent();
                Button image= (Button) view.findViewById(R.id.button);
                if(arrayList.get(position).isFollow()==true){
                    Toast.makeText(m_context,"Dong y ket ban",Toast.LENGTH_SHORT).show();
                    arrayList.remove(position);
                    notifyDataSetChanged();
                }else{

                    Toast.makeText(m_context,"Da yeu cau ket ban",Toast.LENGTH_SHORT).show();
                }



            }
        });

//


    }

    @Override
    public int getItemViewType(int position)
    {
        return super.getItemViewType(position);
    }
}
