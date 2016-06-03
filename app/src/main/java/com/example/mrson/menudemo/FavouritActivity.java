package com.example.mrson.menudemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.mrson.menudemo.tabbar.HeaderBarFavourit;

import java.util.ArrayList;


public class FavouritActivity extends ActionBarActivity {
    HeaderBarFavourit headerBarFavourit;
    ArrayList<Friend> arrayList = new ArrayList<Friend>();
    ListView listView;
    FavouritAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourit);
        headerBarFavourit = (HeaderBarFavourit) findViewById(R.id.headerbar);

        adapter = new FavouritAdapter(getBaseContext(), generateData());
        listView = (ListView) findViewById(R.id.listviewfavourit);
        listView.setAdapter(adapter);

        headerBarFavourit.setTextW(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                adapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        headerBarFavourit.setOnHeaderBarListener(new HeaderBarFavourit.OnHeaderBarListener() {
            @Override
            public void onLeftItemClick(View v) {
                finish();
            }

            @Override
            public void onRightItemClick(View v) {

            }

            @Override
            public void onSettingItemClick(View v) {
                // headerBarFavourit.setVisibilityRightItem(View.INVISIBLE);
            }
        });
    }


    private ArrayList<Favourit> generateData() {
        ArrayList<Favourit> models = new ArrayList<Favourit>();
        models.add(new Favourit("B"));
        models.add(new Favourit(R.mipmap.baomoitest, "Bao Moi"));

        models.add(new Favourit("F"));
        models.add(new Favourit(R.mipmap.fonebox, "FoneBox"));

        models.add(new Favourit("L"));
        models.add(new Favourit(R.mipmap.laban, "La Ban"));

        models.add(new Favourit("Z"));
        models.add(new Favourit(R.mipmap.zalo, "ZALO"));


        return models;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_favourit, menu);
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


}
