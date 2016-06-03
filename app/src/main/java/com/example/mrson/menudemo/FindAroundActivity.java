package com.example.mrson.menudemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.mrson.menudemo.tabbar.HeaderbarFindAround;

import java.util.ArrayList;


public class FindAroundActivity extends ActionBarActivity {
    ArrayList<PeopleAround> arrayList = new ArrayList<>();
    ArrayList<PeopleAround> origi = new ArrayList<>();
    PeopleAroundAdapter peopleAroundAdapter;
    HeaderbarFindAround headerbarFindAround;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_around);
        headerbarFindAround = (HeaderbarFindAround) findViewById(R.id.headerbar);

        fake();
        for (int i = 0; i < arrayList.size(); i++) {
            origi.add(arrayList.get(i));
        }
        peopleAroundAdapter = new PeopleAroundAdapter(getBaseContext(), origi);
        final ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(peopleAroundAdapter);
        Intent intent = getIntent();
        int status = intent.getIntExtra("status", 0);
        if (status == 1) {
            origi.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).isSex() == true)

                    origi.add(arrayList.get(i));

            }
            peopleAroundAdapter.notifyDataSetChanged();
        } else if (status == 2) {
            origi.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).isSex() == false)
                    origi.add(arrayList.get(i));

            }
            peopleAroundAdapter.notifyDataSetChanged();
        }
        else if (status == 5) {
            origi.clear();


            peopleAroundAdapter.notifyDataSetChanged();
        }
        headerbarFindAround.setOnHeaderBarListener(new HeaderbarFindAround.OnHeaderBarListener() {
            @Override
            public void onLeftItemClick(View v) {
                finish();
            }

            @Override
            public void onSettingItemClick(View v) {

                //Toast.makeText(getBaseContext(),"adsadsa",Toast.LENGTH_SHORT).show();
                CustomDialog_FindAround customDialog_findAround = new CustomDialog_FindAround(FindAroundActivity.this);
                WindowManager.LayoutParams wmlp = customDialog_findAround.getWindow().getAttributes();
                wmlp.gravity = Gravity.RIGHT|Gravity.TOP;

                customDialog_findAround.getWindow().setAttributes(wmlp);
                customDialog_findAround.show();
                Window window = customDialog_findAround.getWindow();
                window.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.MATCH_PARENT);
            }
        });
    }


    private void fake() {
        PeopleAround p1 = new PeopleAround();
        p1.setAvatar(R.drawable.p1);
        p1.setName("Hugh HelBert");
        p1.setSex(true);
        p1.setMessage("50m");


        PeopleAround p2 = new PeopleAround();
        p2.setAvatar(R.drawable.p6);
        p2.setName("Steven Seo");
        p2.setSex(false);
        p2.setMessage("100m");


        PeopleAround p3 = new PeopleAround();
        p3.setAvatar(R.drawable.p1);
        p3.setName("Dwight pe");
        p3.setSex(false);
        p3.setMessage("150m");


        PeopleAround p4 = new PeopleAround();
        p4.setAvatar(R.drawable.p6);
        p4.setName("Francis Ci");
        p4.setSex(true);
        p4.setMessage("150m");


        PeopleAround p5 = new PeopleAround();
        p5.setAvatar(R.drawable.p5);
        p5.setName("Walter Ch");
        p5.setSex(true);
        p5.setMessage("150m");


        PeopleAround p6 = new PeopleAround();
        p6.setAvatar(R.drawable.p6);
        p6.setName("Wilbert Rowen");
        p6.setSex(false);
        p6.setMessage("200m");

        PeopleAround p7 = new PeopleAround();
        p7.setAvatar(R.drawable.p6);
        p7.setName("Wilbert Rowen");
        p7.setSex(false);
        p7.setMessage("250m");

        PeopleAround p8 = new PeopleAround();
        p8.setAvatar(R.drawable.p6);
        p8.setName("Wilbert Rowen");
        p8.setSex(false);
        p8.setMessage("250m");

        PeopleAround p9 = new PeopleAround();
        p9.setAvatar(R.drawable.p6);
        p9.setName("Wilbert Rowen");
        p9.setSex(false);
        p9.setMessage("350m");


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
}
