package com.example.mrson.menudemo;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.mrson.menudemo.adapter.NavigationDrawerAdapter;
import com.example.mrson.menudemo.model.NavDrawerItem;

import java.util.ArrayList;
import java.util.List;


public class FragmentDrawer extends Fragment {

    private static String TAG = FragmentDrawer.class.getSimpleName();

    private RecyclerView recyclerView;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private NavigationDrawerAdapter adapter;
    private View containerView;
    private static String[] titles = null;
    private static String[] ic_img=null;
    private FragmentDrawerListener drawerListener;
    private ViewPager mViewPager;

    public FragmentDrawer() {

    }

    public void setDrawerListener(FragmentDrawerListener listener) {
        this.drawerListener = listener;
    }

    public static List<NavDrawerItem> getData() {
        List<NavDrawerItem> data = new ArrayList<>();
        NavDrawerItem navItem1 = new NavDrawerItem();
        navItem1.setTitle("Thông báo mới");
        navItem1.setIc_menu_string(R.mipmap.no_zalo);

        NavDrawerItem navItem2 = new NavDrawerItem();
        navItem2.setTitle("Sticker");
        navItem2.setIc_menu_string(R.mipmap.stick_za);

        NavDrawerItem navItem3 = new NavDrawerItem();
        navItem3.setTitle("Cài đặt riêng tư");
        navItem3.setIc_menu_string(R.mipmap.set_zalo);


        NavDrawerItem navItem4 = new NavDrawerItem();
        navItem4.setTitle("Thiết lập");
        navItem4.setIc_menu_string(R.mipmap.se_za);

        NavDrawerItem navItem5 = new NavDrawerItem();
        navItem5.setTitle("Sản phẩm");
        navItem5.setIc_menu_string(R.mipmap.danhsach);


        NavDrawerItem navItem6 = new NavDrawerItem();
        navItem6.setTitle("Các máy tính đăng nhập");
        navItem6.setIc_menu_string(R.mipmap.computer_zalo);

        NavDrawerItem navItem7 = new NavDrawerItem();
        navItem7.setTitle("Quản lý tài khoản");
        navItem7.setIc_menu_string(R.mipmap.key_zalo);


        data.add(navItem1);
        data.add(navItem2);
        data.add(navItem3);
        data.add(navItem4);
        data.add(navItem5);
        data.add(navItem6);
        data.add(navItem7);





        // preparing navigation drawer items
//        for (int i = 0; i < titles.length; i++) {
//            NavDrawerItem navItem = new NavDrawerItem();
//            navItem.setTitle(titles[i]);
//            navItem.setIc_menu_string(ic_img[i]);
//            data.add(navItem);
//        }
        return data;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // drawer labels
        titles = getActivity().getResources().getStringArray(R.array.nav_drawer_labels);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflating view layout
        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.drawerList);

        adapter = new NavigationDrawerAdapter(getActivity(), getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                drawerListener.onDrawerItemSelected(view, position);


                mDrawerLayout.closeDrawer(containerView);



            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return layout;
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();

            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                toolbar.setAlpha(1 - slideOffset / 2);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }


    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }
    }

    public interface FragmentDrawerListener {
        public void onDrawerItemSelected(View view, int position);
    }
}
