package com.example.mrson.menudemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by son on 5/19/2015.
 */
public class Tab2Fragment extends android.support.v4.app.Fragment {
    RelativeLayout addfriend, favour, team;

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab2layout, viewGroup, false);
        addfriend = (RelativeLayout) v.findViewById(R.id.layout1);
        favour = (RelativeLayout) v.findViewById(R.id.layout2);
        team = (RelativeLayout) v.findViewById(R.id.layout3);

        ExpandListAdapter adapter = new ExpandListAdapter(getActivity(), generateData());
        ListView listView = (ListView) v.findViewById(R.id.expandlistview);
        listView.setAdapter(adapter);

        addfriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), AdfriendActivity.class));
            }
        });
        favour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FavouritActivity.class));
            }
        });
        team.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), TeamActivity.class));
            }
        });
        return v;
    }

    private ArrayList<Group_Expand> generateData() {
        ArrayList<Group_Expand> models = new ArrayList<Group_Expand>();
        models.add(new Group_Expand("D"));
        models.add(new Group_Expand(R.drawable.p1, "Dwight pe"));

        models.add(new Group_Expand("F"));
        models.add(new Group_Expand(R.drawable.p6, "Francis Ci"));

        models.add(new Group_Expand("H"));
        models.add(new Group_Expand(R.drawable.p1, "Hugh HelBert"));

        models.add(new Group_Expand("S"));
        models.add(new Group_Expand(R.drawable.p6, "Steven Seo"));

        models.add(new Group_Expand("W"));
        models.add(new Group_Expand(R.drawable.p5, "Walter Ch"));
        models.add(new Group_Expand(R.drawable.p6, "Wilbert Rowen"));
        models.add(new Group_Expand(R.drawable.p5, "Walter Ch"));
        models.add(new Group_Expand(R.drawable.p6, "Wilbert Rowen"));
        return models;
//
//
//
//
//
//
//
//
//
//
//
//        Group_Expand p6 = new Group_Expand();
//        p6.setA_var(R.drawable.p6);
//        p6.setName("Wilbert Rowen");
//        p6.setFollow(false);
//
//        Group_Expand p7 = new Group_Expand();
//        p7.setA_var(R.drawable.p6);
//        p7.setName("Wilbert Rowen");
//        p7.setFollow(false);
//
//        Group_Expand p8 = new Group_Expand();
//        p8.setA_var(R.drawable.p6);
//        p8.setName("Wilbert Rowen");
//        p8.setFollow(false);
//
//        Group_Expand p9 = new Group_Expand();
//        p9.setA_var(R.drawable.p6);
//        p9.setName("Wilbert Rowen");
//        p9.setFollow(false);
//
//
//        //  p8.setFollow(R.drawable.follow);
//        arrayList.add(p1);
//        arrayList.add(p2);
//        arrayList.add(p3);
//        arrayList.add(p4);
//        arrayList.add(p5);
//        arrayList.add(p6);
//        arrayList.add(p7);
//        arrayList.add(p8);
//        arrayList.add(p9);

    }

}
