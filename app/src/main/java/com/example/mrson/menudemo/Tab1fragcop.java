package com.example.mrson.menudemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.example.mrson.menudemo.apis.Api;
import com.example.mrson.menudemo.apis.ApiError;
import com.example.mrson.menudemo.apis.ApiErrorListener;
import com.example.mrson.menudemo.partone.HidingScrollListener;
import com.example.mrson.menudemo.tabbar.TabBar;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Tab1fragcop extends android.support.v4.app.Fragment {
    CardAdapter cardAdapter;
    public List<Myfeed> mlist = new ArrayList<Myfeed>();
    //  private Toolbar mToolbar;
    public Myfeed myfeed;
    RelativeLayout rl;
    private LinearLayout mFabButton;
    ViewPager mviewPager;
    TabBar tb;
    RecyclerView recyclerView;
    ImageView picture;
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        Api.init(getActivity().getApplicationContext());

        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme);
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);


        final View v = inflater.inflate(R.layout.feedlayout, viewGroup, false);
        mFabButton = (LinearLayout) v.findViewById(R.id.fabButton);
        mviewPager = (ViewPager) v.findViewById(R.id.viewpager);
        tb = (TabBar) v.findViewById(R.id.tab_bar);
        picture= (ImageView) v.findViewById(R.id.picture);
        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),PictureActivity.class));
            }
        });
        // mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        //   mRecyclerView.setHasFixedSize(true);

        //  mLayoutManager = new LinearLayoutManager(this);
        //mRecyclerView.setLayoutManager(mLayoutManager);
//
//        mAdapter = new CardAdapter();
//        mRecyclerView.setAdapter(mAdapter);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));

        cardAdapter = new CardAdapter(getActivity().getBaseContext(), mlist);
        getMyfeed();
        recyclerView.setAdapter(cardAdapter);
        rl = (RelativeLayout) v.findViewById(R.id.rela1);
        recyclerView.setOnScrollListener(new HidingScrollListener() {
            @Override
            public void onHide() {
                hideViews();

            }

            @Override
            public void onShow() {
                showViews();

//
//                viewPager.setVisibility(View.INVISIBLE);


            }
        });


        return v;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        setTheme(R.style.AppThemeRed);
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        // initToolbar();
//        mFabButton = (LinearLayout) findViewById(R.id.fabButton);
//        initRecyclerView();
//
//
//    }
    //    private void initToolbar() {
//        mToolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(mToolbar);
//        setTitle(getString(R.string.app_name));
//        mToolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
//    }


    //        recyclerView.addOnScrollListener(new HidingScrollListener() {
//            @Override
//            public void onHide() {
//                hideViews();
//            }
//
//            @Override
//            public void onShow() {
//                showViews();
//            }
//        });
//    }
    private void hideViews() {
//        mToolbar.animate().translationY(-mToolbar.getHeight()).setInterpolator(new AccelerateInterpolator(2));

        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mFabButton.getLayoutParams();
        int fabBottomMargin = lp.bottomMargin;
        mFabButton.animate().translationY(mFabButton.getHeight() + fabBottomMargin).setInterpolator(new AccelerateInterpolator(2)).start();
    }

    private void showViews() {
        //mToolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
        mFabButton.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();

    }

    public void getMyfeed() {
        // swipeRefreshLayout.setRefreshing(true);
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
                        myfeed.setIsLike(false);


                        mlist.add(myfeed);


                    }


                    cardAdapter.notifyDataSetChanged();


                    //    swipeRefreshLayout.setRefreshing(false);

                    //   Log.d("array",jsonArray.toString());

                } catch (Exception e) {
                    e.printStackTrace();
                    //  swipeRefreshLayout.setRefreshing(false);
                }
            }
        }, new ApiErrorListener() {
            @Override

            public void onErrorResponse(ApiError error) {

            }


        });

    }


//
//    private List<String> createItemList() {
//        List<String> itemList = new ArrayList<>();
//        for(int i=0;i<20;i++) {
//            itemList.add("Item "+i);
//        }
//        return itemList;
//    }
}
