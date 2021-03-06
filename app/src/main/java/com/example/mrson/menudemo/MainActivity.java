package com.example.mrson.menudemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    MainLayout mLayout;
    private ListView lvMenu;
    private String[] lvMenuItems;
    ImageView btMenu;
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayout = (MainLayout) this.getLayoutInflater().inflate(
                R.layout.activity_main, null);
        setContentView(mLayout);

       // lvMenuItems = getResources().getStringArray(R.array.menu_items);
       // lvMenu = (ListView) findViewById(R.id.menu_listview);
        lvMenu.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lvMenuItems));
        lvMenu.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                onMenuItemClick(parent, view, position, id);
            }

        });

        btMenu = (ImageView) findViewById(R.id.button_menu);
        btMenu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show/hide the menu
                toggleMenu(v);
            }
        });

     //   tvTitle = (TextView) findViewById(R.id.activity_main_content_title);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void toggleMenu(View v) {
        mLayout.toggleMenu();
    }

    private void onMenuItemClick(AdapterView<?> parent, View view,
                                 int position, long id) {
        String selectedItem = lvMenuItems[position];
        String currentItem = tvTitle.getText().toString();
        if (selectedItem.compareTo(currentItem) == 0) {
            mLayout.toggleMenu();
            return;
        }




        mLayout.toggleMenu();
    }

    @Override
    public void onBackPressed() {
        if (mLayout.isMenuShown()) {
            mLayout.toggleMenu();
        } else {
            super.onBackPressed();
        }
    }
}

