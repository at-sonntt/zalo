package com.example.mrson.menudemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mrson.menudemo.apis.Api;

/**
 * Created by son on 5/19/2015.
 */
public class Tab4Fragment extends Fragment {
    LinearLayout addfriend, find, talk, qrcode, zalopage, game;

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        Api.init(getActivity().getApplicationContext());
        View v = inflater.inflate(R.layout.connect_frag, viewGroup, false);
        addfriend = (LinearLayout) v.findViewById(R.id.addfriend);
        find = (LinearLayout) v.findViewById(R.id.find);
        talk = (LinearLayout) v.findViewById(R.id.talk);
        qrcode = (LinearLayout) v.findViewById(R.id.qrcode);
        zalopage = (LinearLayout) v.findViewById(R.id.zalopage);
        game = (LinearLayout) v.findViewById(R.id.game);

        addfriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Tab4AddfriendActivity.class));
            }
        });
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FindAroundActivity.class));
            }
        });
        return v;
    }
}
