package com.example.mrson.menudemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mrson.menudemo.apis.Api;
import com.example.mrson.menudemo.peoples.AwesomeAdapter;
import com.example.mrson.menudemo.peoples.Message;
import com.example.mrson.menudemo.peoples.PeoPle;
import com.example.mrson.menudemo.peoples.PeopleAdapter;

import java.util.ArrayList;

import static com.example.mrson.menudemo.R.id;

/**
 * Created by son on 5/19/2015.
 */
public class Tab3Fragment extends Fragment {
    ArrayList<PeoPle> arrayList = new ArrayList<PeoPle>();
    ArrayList<Message> arrayList1;


    PeopleAdapter peopleAdapter;
    AwesomeAdapter awesomeAdapter;
    Dialog listDialog;

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        Api.init(getActivity().getApplicationContext());
        View v = inflater.inflate(R.layout.people, viewGroup, false);


//      Myfeed myfeed = new Myfeed();
//        Myfeed myfeed1 = new Myfeed();
//        myfeed1.setName("Nguyen van b");
//    myfeed.setName("Nguyen van a");
//     //   myfeed.setImage(R.mipmap.avar_id);
//        myfeed.setProfilePic("Day la main");
//        myfeed.setStatus("dsfsdfdsfsdfffs");
        // mlist.add(myfeed);
        // mlist.add(myfeed1);
        fake();
        peopleAdapter = new PeopleAdapter(getActivity().getBaseContext(), arrayList);
        final ListView listView = (ListView) v.findViewById(id.lv_people);
        listView.setAdapter(peopleAdapter);

        //   messadater = new AwesomeAdapter(getActivity().getBaseContext(),arrmess);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dialog dialog = new Dialog((Activity) view.getContext());
                dialog.setContentView(R.layout.custom_dialog);
                AlertDialog.Builder mdialog = new AlertDialog.Builder((Activity) view.getContext());
                // mdialog.setContentView(layout.custom_dialog);
                // mdialog.setIcon(drawable.adddialog);

                // dialog.seti
                //   String test= listView.getItemAtPosition(position).toString();


                arrayList1 = new ArrayList<Message>();

                String test = arrayList.get(position).getMessage();
                //   String txt = ((TextView)view).getText().toString();
                // messages = new ArrayList<Message>();
                //  String contactId = ((TextView) dialog.findViewById(R.id.message_text)).getText().toString();
                Message message = new Message();
                message.setMessage("fdsdsdvndjkavnkn");
                Message message1 = new Message();
                message1.setMessage("dsdsfsdf");
                Message message3 = new Message();
                message3.setMessage(test);
                arrayList1.add(message);
                arrayList1.add(message1);
                arrayList1.add(message3);
                //  arrayList1.add(message);
//           mdialog.setPositiveButton(arrayList1, new DialogInterface.OnClickListener() {
//               @Override
//               public void onClick(DialogInterface dialog, int which) {
//
//               }
//           })

                awesomeAdapter = new AwesomeAdapter(getActivity().getBaseContext(), arrayList1);

                ListView listView1 = (ListView) dialog.findViewById(R.id.list);
                listView1.setAdapter(awesomeAdapter);

                dialog.show();

            }
        });


//      @Override
//      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//      //   final Dialog dialog= new Dialog(getActivity().getBaseContext());
//      //  dialog.setContentView(layout.custom_dialog);
//          final Dialog dialog = new Dialog((Activity)view.getContext());
//          dialog.setContentView(layout.custom_dialog);
//         // View vi = inflater.inflate(layout.custom_dialog, viewGroup, false);
//
//
//          arrayList_mes.add(new Message("Hello", false));
//          arrayList_mes.add(new Message("Hi!", true));
//          arrayList_mes.add(new Message("Wassup??", false));
//          awesomeAdapter= new AwesomeAdapter((Activity)view.getContext(),arrayList_mes);
//          ListView listViewmes=(ListView) view.findViewById(R.id.list);
//          listViewmes.setAdapter(awesomeAdapter);
//        //  dialog.setTitle("Edit listview");
//          dialog.show();
//   }


        //ListView listView = (ListView)v.findViewById(R.id.lv1);
        //  ArrayList<ItemPicture> arrayList =new ArrayList<>();
        //  ItemPicture p1 = new ItemPicture(R.drawable.bgg);
        //  ItemPicture p2 = new ItemPicture(R.drawable.backgr22);
//      final Button b = (Button) v.findViewById(R.id.bnt_f);
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "Thanks follow me!", Toast.LENGTH_LONG)
//
//                        .show();
//
//                if(v.equals(b)){
//                    b.setText("Followed");
//                }
//                else {
//                    b.setText("Follow");
//                }
//
//            }
//        });
//     //   ItemPicture p1 = new ItemPicture(R.drawable.backgr3);
//        arrayList.add(p1);
//        arrayList.add(p2);
//        AlbumAdapter adapter = new AlbumAdapter(getActivity(),arrayList);
//        listView.setAdapter(adapter);

        return v;
    }

    /*
    ArrayList<Albums> arrayList;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
            View v = inflater.inflate(R.layout.tab1, viewGroup,false);
            ListView listView = (ListView)v.findViewById(R.id.listView);


            ArrayList<Albums> arrayList =new ArrayList<>();
            Albums p1 = new Albums(R.drawable.albums_i1,"Of the Past","28 photos| updated 21 Jan 2015");
            Albums p2 = new Albums(R.drawable.albums_i2,"City","20 photos| updated 21 Jan 2015");
            Albums p3 = new Albums(R.drawable.albums_i1,"Of the Past","28 photos| updated 21 Jan 2015");
            Albums p4 = new Albums(R.drawable.albums_i2,"City","20 photos| updated 21 Jan 2015");

            arrayList.add(p1);
            arrayList.add(p2);
            arrayList.add(p3);
            arrayList.add(p4);

            AlbumsAdapter adapter = new AlbumsAdapter(arrayList,getActivity());
            listView.setAdapter(adapter);

            return v;
        }
    [7:58:11 PM] nguyen Tuy: ListView listView = (ListView)v.findViewById(R.id.listView);


            ArrayList<Albums> arrayList =new ArrayList<>();
            Albums p1 = new Albums(R.drawable.albums_i1,"Of the Past","28 photos| updated 21 Jan 2015");
            Albums p2 = new Albums(R.drawable.albums_i2,"City","20 photos| updated 21 Jan 2015");
            Albums p3 = new Albums(R.drawable.albums_i1,"Of the Past","28 photos| updated 21 Jan 2015");
            Albums p4 = new Albums(R.drawable.albums_i2,"City","20 photos| updated 21 Jan 2015");

            arrayList.add(p1);
            arrayList.add(p2);
            arrayList.add(p3);
            arrayList.add(p4);

            AlbumsAdapter adapter = new AlbumsAdapter(arrayList,getActivity());
            listView.setAdapter(adapter);
     */
    private void fake() {
        PeoPle p1 = new PeoPle();
        p1.setA_var(R.drawable.p1);
        p1.setName("Hugh HelBert");
        p1.setFollow(true);
        p1.setMessage("ban dang lam gi do");


        PeoPle p2 = new PeoPle();
        p2.setA_var(R.drawable.p6);
        p2.setName("Steven Seo");
        p2.setFollow(false);
        p2.setMessage("chao nhe");


        PeoPle p3 = new PeoPle();
        p3.setA_var(R.drawable.p1);
        p3.setName("Dwight pe");
        p3.setFollow(false);
        p3.setMessage("hello");


        PeoPle p4 = new PeoPle();
        p4.setA_var(R.drawable.p6);
        p4.setName("Francis Ci");
        p4.setFollow(false);
        p4.setMessage("dsfdsfsa");


        PeoPle p5 = new PeoPle();
        p5.setA_var(R.drawable.p5);
        p5.setName("Walter Ch");
        p5.setFollow(false);


        PeoPle p6 = new PeoPle();
        p6.setA_var(R.drawable.p6);
        p6.setName("Wilbert Rowen");
        p6.setFollow(false);

        PeoPle p7 = new PeoPle();
        p7.setA_var(R.drawable.p6);
        p7.setName("Wilbert Rowen");
        p7.setFollow(false);

        PeoPle p8 = new PeoPle();
        p8.setA_var(R.drawable.p6);
        p8.setName("Wilbert Rowen");
        p8.setFollow(false);

        PeoPle p9 = new PeoPle();
        p9.setA_var(R.drawable.p6);
        p9.setName("Wilbert Rowen");
        p9.setFollow(false);


        //  p8.setFollow(R.drawable.follow);
        arrayList.add(p1);
        arrayList.add(p2);
        arrayList.add(p3);
        arrayList.add(p4);
        arrayList.add(p5);
        arrayList.add(p6);
        arrayList.add(p7);
        arrayList.add(p8);
        arrayList.add(p9);


    }


}
