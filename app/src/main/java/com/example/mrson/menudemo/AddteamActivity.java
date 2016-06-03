package com.example.mrson.menudemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mrson.menudemo.tabbar.HeaderBarAddTeam;

import java.util.ArrayList;


public class AddteamActivity extends ActionBarActivity {
    HeaderBarAddTeam headerBarAddTeam;
    ListView listView;
    EditText editText;
    ArrayList<Model_addteam> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addteam);
        headerBarAddTeam = (HeaderBarAddTeam) findViewById(R.id.headerbar);
        listView = (ListView) findViewById(R.id.listview);
        editText = (EditText) findViewById(R.id.edtsearch);

        final AddteamListAdapter addteamListAdapter = new AddteamListAdapter(getBaseContext(), generateData());
        listView.setAdapter(addteamListAdapter);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                addteamListAdapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        headerBarAddTeam.setOnHeaderBarListener(new HeaderBarAddTeam.OnHeaderBarListener() {
            @Override
            public void onLeftItemClick(View v) {
                finish();
            }

            @Override
            public void onRightItemClick(View v) {
                ArrayList<Integer> img = new ArrayList<Integer>();
                ArrayList<String> title = new ArrayList<String>();
                int tmp = 0;
                //tmp = String.valueOf(models.size());
                for (int i = 0; i < models.size(); i++) {
                    if (models.get(i).isCheck() == true) {
                        img.add(models.get(i).getIcon());
                        Log.d("-------", models.get(i).getTitle().toString());
                        title.add(models.get(i).getTitle());
                        tmp = tmp + 1;
                    }
                    Intent a = new Intent(getBaseContext(), TeamActivity.class);
                    a.putIntegerArrayListExtra("icon", img);
                    a.putStringArrayListExtra("title", title);
                    a.putExtra("type", tmp);
                    startActivity(a);
                }
//                Toast.makeText(getBaseContext(), "Chao ban", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList<Model_addteam> generateData() {
        models = new ArrayList<Model_addteam>();
        models.add(new Model_addteam("D"));
        models.add(new Model_addteam(R.drawable.p1, "Dwight pe"));

        models.add(new Model_addteam("F"));
        models.add(new Model_addteam(R.drawable.p6, "Francis Ci"));

        models.add(new Model_addteam("H"));
        models.add(new Model_addteam(R.drawable.p1, "Hugh HelBert"));

        models.add(new Model_addteam("S"));
        models.add(new Model_addteam(R.drawable.p6, "Steven Seo"));

        models.add(new Model_addteam("W"));
        models.add(new Model_addteam(R.drawable.p5, "Walter Ch"));
        models.add(new Model_addteam(R.drawable.p6, "Wilbert Rowen"));
        models.add(new Model_addteam(R.drawable.p5, "Walter Ch"));
        models.add(new Model_addteam(R.drawable.p6, "Wilbert Rowen"));
        return models;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_addteam, menu);
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
