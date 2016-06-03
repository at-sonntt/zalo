package com.example.mrson.menudemo.peoples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mrson.menudemo.R;

import java.util.ArrayList;

import static com.example.mrson.menudemo.R.id;

/**
 * Created by son on 5/22/2015.
 */
public class PeopleAdapter extends BaseAdapter {
    Context m_context;
    ArrayList<PeoPle> arrayList_people ;
    PeoPle people;
    AwesomeAdapter messadater;

    ArrayList<Message> messarr= new ArrayList<Message>();

    public PeopleAdapter(Context context, ArrayList<PeoPle> peo_ple) {
        this.m_context = context;
        this.arrayList_people = peo_ple;
    }

    @Override
    public int getCount() {
        return arrayList_people.size();
    }

    @Override
    public PeoPle getItem(int position) {
        return arrayList_people.get(position);
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

      convertView= LayoutInflater.from(m_context).inflate(R.layout.people_item,parent,false);
            viewHolder= new ViewHolder();
            viewHolder.img_ava=(ImageView) convertView.findViewById(R.id.img_peo);
          viewHolder.txt_name=(TextView)convertView.findViewById(R.id.txt_peo);

            viewHolder.frag=(ImageView) convertView.findViewById((id.fr));
            viewHolder.txt_message=(TextView) convertView.findViewById(id.txt_message);
            viewHolder.rlmain=(RelativeLayout) convertView.findViewById(R.id.rlmain);



           // viewHolder.textView = (TextView) convertView.findViewById(R.id.text);
        // bntfl=(Button)convertView.findViewById(R.id.btn_f);
           // viewHolder.folow=(Button)convertView.findViewById(R.id.btn_f);

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


    private void setValue(final ViewHolder holder, final int position) {
        people = getItem(position);
        holder.img_ava.setImageResource(people.getA_var());
        holder.txt_name.setText(people.getName());
        holder.txt_message.setText(people.getMessage());


//        if(people.isFollow()==true){
//            holder.folow.setBackgroundResource(drawable.check);
//        }else{
//
//            holder.folow.setBackgroundResource(drawable.uncheck);
//        }

     //   holder.folow=people.isFollow();


//        holder.folow.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                View view=(View)v.getParent();
//                Button image= (Button) view.findViewById(id.btn_f);
////                if(arrayList_people.get(position).isFollow()==true){
////                    image.setBackgroundResource(drawable.uncheck);
////                   // people.setFollow(false);
////                    arrayList_people.get(position).setFollow(false);
////                }else{
////
////                    image.setBackgroundResource(drawable.check);
////                   // people.setFollow(true);
////                    arrayList_people.get(position).setFollow(true);
////                }
//
//
//
//            }
//        });

//
//


    }

    @Override
    public int getItemViewType(int position)
    {
        return super.getItemViewType(position);
    }
}
