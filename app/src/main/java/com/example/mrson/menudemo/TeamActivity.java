package com.example.mrson.menudemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.mrson.menudemo.tabbar.HeaderBarTeam;

import java.util.ArrayList;


public class TeamActivity extends ActionBarActivity {
    HeaderBarTeam headerBarTeam;
    ArrayList<Team> arrayList = new ArrayList<Team>();
    TeamAdapter teamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        headerBarTeam = (HeaderBarTeam) findViewById(R.id.headerbar);


        fake();
        teamAdapter = new TeamAdapter(getBaseContext(), arrayList);
        final ListView listView = (ListView) findViewById(R.id.listviewteam);
        listView.setAdapter(teamAdapter);

        Intent a = getIntent();
        int type = a.getIntExtra("type", 0);
        ArrayList<Integer> icon = a.getIntegerArrayListExtra("icon");
        ArrayList<String> title = a.getStringArrayListExtra("title");
        if (type != 0) {
            // Toast.makeText(getBaseContext(),String.valueOf(type),Toast.LENGTH_SHORT).show();
            Team p = new Team();
            p.setLogo(icon);
            p.setName(title);
            p.setType(type);
            arrayList.add(p);
            teamAdapter.notifyDataSetChanged();
        }
        headerBarTeam.setTextW(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                teamAdapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        headerBarTeam.setOnHeaderBarListener(new HeaderBarTeam.OnHeaderBarListener() {

            @Override
            public void onLeftItemClick(View v) {
                onBackPressed();
            }

            @Override
            public void onRightItemClick(View v) {


            }

            @Override
            public void onSettingItemClick(View v) {
                startActivity(new Intent(getBaseContext(), AddteamActivity.class));
            }
        });
    }


    private void fake() {

        ArrayList<String> name = new ArrayList<>();

        name.add("Hugh Helbert");
        name.add("Tuy");
        ArrayList<Integer> logo = new ArrayList<>();
        logo.add(R.drawable.p1);
        logo.add(R.drawable.p2);
        Team p1 = new Team();
        p1.setLogo(logo);
        p1.setName(name);
        p1.setType(2);

        arrayList.add(p1);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_team, menu);
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
