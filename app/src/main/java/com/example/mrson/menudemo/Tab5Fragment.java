package com.example.mrson.menudemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.example.mrson.menudemo.apis.Api;
import com.example.mrson.menudemo.apis.ApiError;
import com.example.mrson.menudemo.apis.ApiErrorListener;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by son on 5/19/2015.
 */
public class Tab5Fragment extends Fragment {
    ArrayList<Myfeed> mlist = new ArrayList<Myfeed>();
    FeedAdapter feedAdapter;
    Myfeed myfeed;

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        Api.init(getActivity().getApplicationContext());
        View v = inflater.inflate(R.layout.activity_main, viewGroup, false);


        getMyfeed();
//      Myfeed myfeed = new Myfeed();
//        Myfeed myfeed1 = new Myfeed();
//        myfeed1.setName("Nguyen van b");
//    myfeed.setName("Nguyen van a");
//     //   myfeed.setImage(R.mipmap.avar_id);
//        myfeed.setProfilePic("Day la main");
//        myfeed.setStatus("dsfsdfdsfsdfffs");
        // mlist.add(myfeed);
        // mlist.add(myfeed1);
        feedAdapter = new FeedAdapter(mlist, getActivity().getBaseContext());
        ListView listView = (ListView) v.findViewById(R.id.list);
        listView.setAdapter(feedAdapter);
        // ListView listView = (ListView)v.findViewById(R.id.lv1);
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

    public void getMyfeed() {
        HashMap<String, String> param = new HashMap<String, String>();
        Api.getInstance().getUserInfo(param, new Response.Listener<NetworkResponse>() {

            @Override
            public void onResponse(NetworkResponse response) {
                final Gson gson = new Gson();

                try {
                    String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
                    JsonElement je = gson.fromJson(json, JsonElement.class);
                    JsonObject jsonObjectroot = je.getAsJsonObject();

                    Log.d("obj", jsonObjectroot.toString());
                    JsonArray jsonArray = jsonObjectroot.get("feed").getAsJsonArray();
                    for (int i = 0; i < jsonArray.size(); i++) {
                        //   JSONObject feedObj = (JSONObject) jsonArray.get(i);
                        JsonObject jsonMem = jsonArray.get(i).getAsJsonObject();
                        //   Log.d("jsonmem",jsonMem.toString());\
                        //   String test=jsonMem.getString("name");
                        String name = jsonMem.get("name").getAsString();
                        String status = jsonMem.get("status").getAsString();
                        //  String image=jsonMem.get("image").getAsString();
                        Log.d("name", name.toString());
                        Log.d("status", status.toString());
                        String image_c = jsonMem.get("image").isJsonNull() ? null : jsonMem.get("image").getAsString();
                        String url = jsonMem.get("url").isJsonNull() ? null : jsonMem.get("url").getAsString();
                        //        Log.d("image",image_c.toString());
                        // String status_c=jsonMem.get("status").getAsString();
                        String profilePic_c = jsonMem.get("profilePic").getAsString();

                        //    String url=jsonMem.get("url").getAsString();
                        myfeed = new Myfeed();
                        // myfeed.setStatus(status);
                        myfeed.setName(name);
                        myfeed.setStatus(status);
                        myfeed.setImage(profilePic_c);
                        myfeed.setUrl(url);
                        //  myfeed.setImage(image);

                        myfeed.setProfilePic(image_c);
                        //   myfeed.setUrl(url);
                        //    myfeed.setImage(image_c);


                        mlist.add(myfeed);


                    }


                    feedAdapter.notifyDataSetChanged();

                    //   Log.d("array",jsonArray.toString());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new ApiErrorListener() {
            @Override

            public void onErrorResponse(ApiError error) {

            }


        });
    }
}
