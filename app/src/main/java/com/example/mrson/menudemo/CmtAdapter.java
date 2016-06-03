package com.example.mrson.menudemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by mrson on 02/07/2015.
 */
public class CmtAdapter extends BaseAdapter {
    Context m_context;
    ArrayList<Cmt> arrayList_cmt ;
    Cmt cmt;

    public CmtAdapter(Context m_context, ArrayList<Cmt> arrayList) {
        this.m_context = m_context;

        this.arrayList_cmt = arrayList;
    }


    @Override
    public int getCount() {
        return arrayList_cmt.size();
    }

    @Override
    public Cmt getItem(int position) {
        return arrayList_cmt.get(position);
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

            convertView= LayoutInflater.from(m_context).inflate(R.layout.cmt_item,parent,false);
            viewHolder= new ViewHolder();
            viewHolder.cmt=(TextView) convertView.findViewById(R.id.cmt_id);




            // viewHolder.textView = (TextView) convertView.findViewById(R.id.text);
            // bntfl=(Button)convertView.findViewById(R.id.btn_f);


            convertView.setTag(viewHolder);


        }else {
            viewHolder= (ViewHolder) convertView.getTag();

        }

        setValue(viewHolder, position);

        return convertView;
    }




    private static class  ViewHolder{
        TextView cmt;


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
        cmt = getItem(position);
        holder.cmt.setText(cmt.getCmt());






    }

    @Override
    public int getItemViewType(int position)
    {
        return super.getItemViewType(position);
    }
}