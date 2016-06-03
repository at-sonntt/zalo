package com.example.mrson.menudemo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.mrson.menudemo.FragmentDrawer;
import com.example.mrson.menudemo.R;
import com.example.mrson.menudemo.Tab1fragcop;
import com.example.mrson.menudemo.Tab2Fragment;
import com.example.mrson.menudemo.Tab3Fragment;
import com.example.mrson.menudemo.Tab4Fragment;
import com.example.mrson.menudemo.fragment_menu.FriendsFragment;
import com.example.mrson.menudemo.fragment_menu.HomeFragment;
import com.example.mrson.menudemo.fragment_menu.MessagesFragment;
import com.example.mrson.menudemo.tabbar.TabBar;


public class MainActivity extends ActionBarActivity implements FragmentDrawer.FragmentDrawerListener {
    private Toolbar mToolbar;
    private static String TAG = MainActivity.class.getSimpleName();
    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;
    private TabBar mTabBar;
    private LinearLayout container_toolbar;
    private  ImageView bt;
    private FragmentDrawer drawerFragment;
    private FragmentDrawer bt1;
    boolean click=false;
    private ImageView pre;
    private LinearLayout menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

     //   mTabBar = (TabBar) findViewById(R.id.tab_bar);
       // bt=(ImageView) findViewById(R.id.button_menu);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setVisibility(View.VISIBLE);

        mTabBar=(TabBar) findViewById(R.id.tab_bar);
        container_toolbar=(LinearLayout)findViewById(R.id.container_toolbar);
        pre=(ImageView)findViewById(R.id.pre);
        pre.setVisibility(View.INVISIBLE);

        container_toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setVisibility(View.VISIBLE);
                mTabBar.setVisibility(View.VISIBLE);
                mToolbar.setVisibility(View.VISIBLE);
                pre.setVisibility(View.INVISIBLE);

            }
        });


//        ll_show_viewpage_click.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mViewPager.setVisibility(View.VISIBLE);
//            }
//        });

        setSupportActionBar(mToolbar);
        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
      drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
        mTabBar.clickTab(0);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);


        mTabBar.setOnTabBarListener(new TabBar.OnTabBarListener() {
            @Override
            public void onTabClick(int position) {
                mViewPager.setCurrentItem(position);
            }
        });
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabBar.clickTab(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               // Toast.makeText(getBaseContext(),"dd",Toast.LENGTH_SHORT).show();
//               mLayout.toggleMenu();
//
//            }
//        });

    }


    public class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = null;
            switch (position) {
                case 0:
                    f = new Tab3Fragment();
                    break;
                case 1:
                    f = new Tab2Fragment();
                    break;
                case 2:
                    f = new Tab1fragcop();
                    break;
                case 3:
                    f = new Tab4Fragment();
                    break;


                default:
                    f = new Tab3Fragment();
                    break;
            }
            return f;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);

    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                title = getString(R.string.title_home);
                mViewPager.setVisibility(View.INVISIBLE);
                mTabBar.setVisibility(View.INVISIBLE);
                mToolbar.setVisibility(View.INVISIBLE);
                pre.setVisibility(View.VISIBLE);


                break;
            case 1:
                fragment = new FriendsFragment();
                title = getString(R.string.title_friends);
            mViewPager.setVisibility(View.INVISIBLE);
                mTabBar.setVisibility(View.INVISIBLE);
                break;
            case 2:
                fragment = new MessagesFragment();
                title = getString(R.string.title_messages);
                mViewPager.setVisibility(View.INVISIBLE);
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }

}
