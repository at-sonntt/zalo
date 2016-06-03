package com.example.mrson.menudemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.mrson.menudemo.tabbar.HeaderBarPost;
import com.squareup.picasso.Picasso;


public class PostActivity extends ActionBarActivity {
    HeaderBarPost headerBarPost;
    ImageView imageView;
    Context context;
    LinearLayout imagee,sticker,sound,linker,image_view,rela2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        imageView = (ImageView) findViewById(R.id.image_post);
        headerBarPost = (HeaderBarPost) findViewById(R.id.headerbarpost);
        imagee = (LinearLayout) findViewById(R.id.image_click);
        sticker = (LinearLayout) findViewById(R.id.sticker_click);
        sound = (LinearLayout) findViewById(R.id.sound_click);
        linker = (LinearLayout) findViewById(R.id.link_click);
        rela2 = (LinearLayout) findViewById(R.id.rela2);
        image_view = (LinearLayout) findViewById(R.id.image_view);
        Intent intent = getIntent();
        String uri = "file://" + intent.getStringExtra("image");

        Log.d("=====-", uri);
        rela2.setVisibility(View.INVISIBLE);
        image_view.setVisibility(View.VISIBLE);
        Picasso.with(context)
                .load(uri)
                .resize(189, 189)
                .error(R.mipmap.empty_photo)
                .centerCrop()
                .into(imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_post, menu);
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
