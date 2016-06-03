package com.example.mrson.menudemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mrson.menudemo.peoples.PeoPle;
import com.example.mrson.menudemo.peoples.PeopleAdapter;
import com.example.mrson.menudemo.tabbar.TabBar;

import java.util.ArrayList;


public class TabbarActivity extends FragmentActivity {
    public ArrayList<PeoPle> arrayList = new ArrayList<PeoPle>();
    private TabBar mTabBar;
    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;
    MainLayout mLayout;
    PeopleAdapter peopleAdapter;


    private TextView lvMenu;
    private String[] lvMenuItems;
    ImageView btMenu;
    TextView tvTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayout = (MainLayout) this.getLayoutInflater().inflate(
                R.layout.activity_main, null);
        setContentView(mLayout);
        //   mLayout = (MainLayout) this.getLayoutInflater().inflate(
        //   R.layout.main_menu, null);
        //  setContentView(mLayout);

        //  lvMenuItems = getResources().getStringArray(R.array.menu_items);
        //Doan nay test cai listview trong menus
        fake();

        peopleAdapter = new PeopleAdapter(this, arrayList);

        //   final ListView listView = (ListView)findViewById(R.id.lv_people);
        // lvMenu = (TextView) findViewById(R.id.menu_listview);
        //   listView.setAdapter(peopleAdapter);\
        //  lvMenu.setAdapter(peopleAdapter);//het doan

//        lvMenu.setAdapter(new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, lvMenuItems));
        //  lvMenu.setAdapter(this,R.layout.menu_items);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        mTabBar = (TabBar) findViewById(R.id.tab_bar);
        //  TextView title = (TextView) findViewById(R.id.txt_b1);
        // title.setTextColor(Color.WHITE);

        mTabBar.clickTab(0);
        mTabBar.setOnTabBarListener(new TabBar.OnTabBarListener() {
            @Override
            public void onTabClick(int position) {
                mViewPager.setCurrentItem(position);

            }
        });
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                mTabBar.clickTab(position);

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                //   mLayout.toggleMenu();

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {


            }
        });
        mTabBar.clickTab(0);
        mTabBar.setOnClickListener(new TabBar.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getBaseContext(), "hagen", Toast.LENGTH_SHORT);
                toast.show();

            }
        });
//        mTabBar.setOnTabBarListener(new TabBar.OnTabBarListener() {
//            @Override
//            public void onTabClick(int position) {
//                mViewPager.setCurrentItem(position);
//
//            }
//        });

        btMenu = (ImageView) findViewById(R.id.button_menu);
        btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show/hide the menu
                mLayout.toggleMenu();

            }
        });
//        FragmentManager fm = TabbarActivity.this.getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        Layout1 fragment = new Layout1();
//        ft.add(R.id.activity_main_content_fragment, fragment);
//        ft.commit();
//


    }
//    private void onMenuItemClick(AdapterView<?> parent, View view,
//                                 int position, long id) {
//        String selectedItem = lvMenuItems[position];
//        String currentItem = tvTitle.getText().toString();
//        if (selectedItem.compareTo(currentItem) == 0) {
//            mLayout.toggleMenu();
//            return;
//        }
////
////        FragmentManager fm = this.getSupportFragmentManager();
////        FragmentTransaction ft = fm.beginTransaction();
////        Fragment fragment = null;
////
////        if (selectedItem.compareTo("Layout 1") == 0) {
////            fragment = new Layout1();
////        } else if (selectedItem.compareTo("Layout 2") == 0) {
////            fragment = new Layout2();
////        }
////
////        if (fragment != null) {
////            ft.replace(R.id.activity_main_content_fragment, fragment);
////            ft.commit();
////            tvTitle.setText(selectedItem);
////        }
////        mLayout.toggleMenu();
//    }


//    private void onMenuItemClick(AdapterView<?> parent, View view,
//                                 int position, long id) {
//        String selectedItem = lvMenuItems[position];
//        String currentItem = tvTitle.getText().toString();
//        if (selectedItem.compareTo(currentItem) == 0) {
//            mLayout.toggleMenu();
//            return;
//        }

//        FragmentManager fm = TabbarActivity.this.getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        Fragment fragment = null;

//        if (selectedItem.compareTo("Layout 1") == 0) {
//            fragment = new Layout1();
//        } else if (selectedItem.compareTo("Layout 2") == 0) {
//            fragment = new Layout2();
//        }
//
//        if (fragment != null) {
//            ft.replace(R.id.activity_main_content_fragment, fragment);
//            ft.commit();
//            tvTitle.setText(selectedItem);
//        }
//        mLayout.toggleMenu();
//    }

    @Override
    public void onBackPressed() {
        if (mLayout.isMenuShown()) {
            mLayout.toggleMenu();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabbar, menu);
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
