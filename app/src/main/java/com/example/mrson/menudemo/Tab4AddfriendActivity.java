package com.example.mrson.menudemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.mrson.menudemo.tabbar.HeaderBarTab4Addfriend;


public class Tab4AddfriendActivity extends ActionBarActivity {
    HeaderBarTab4Addfriend headerBarTab4Addfriend;
    RelativeLayout adbyphone,addzalo,findface,findgoogle,findaround;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab4_addfriend);
        headerBarTab4Addfriend = (HeaderBarTab4Addfriend) findViewById(R.id.headerbar);
        adbyphone = (RelativeLayout) findViewById(R.id.layout1);
        addzalo = (RelativeLayout) findViewById(R.id.layout2);
        findface = (RelativeLayout) findViewById(R.id.layout3);
        findgoogle = (RelativeLayout) findViewById(R.id.layout4);
        findaround = (RelativeLayout) findViewById(R.id.layout5);

        headerBarTab4Addfriend.setOnHeaderBarListener(new HeaderBarTab4Addfriend.OnHeaderBarListener() {
            @Override
            public void onLeftItemClick(View v) {
                onBackPressed();
            }


        });
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
