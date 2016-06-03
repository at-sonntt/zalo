package com.example.mrson.menudemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class AdfriendActivity extends ActionBarActivity {
    ArrayList<Friend> arrayList = new ArrayList<Friend>();
    FriendAdapter friendAdapter;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adfriend);
        imageView = (ImageView) findViewById(R.id.home);
        textView = (TextView) findViewById(R.id.deleteall);

        fake();
        friendAdapter = new FriendAdapter(getBaseContext(), arrayList);
        final ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(friendAdapter);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   startActivity(new Intent(getBaseContext(),Tab2Fragment.class));
                finish();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.removeAll(arrayList);
                friendAdapter.notifyDataSetChanged();
            }
        });
    }

    private void fake() {
        Friend p1 = new Friend();
        p1.setAvatar(R.drawable.p1);
        p1.setName("Hugh HelBert");
        p1.setFollow(true);
        p1.setMessage("ban dang lam gi do");


        Friend p2 = new Friend();
        p2.setAvatar(R.drawable.p6);
        p2.setName("Steven Seo");
        p2.setFollow(false);
        p2.setMessage("chao nhe");


        Friend p3 = new Friend();
        p3.setAvatar(R.drawable.p1);
        p3.setName("Dwight pe");
        p3.setFollow(false);
        p3.setMessage("hello");


        Friend p4 = new Friend();
        p4.setAvatar(R.drawable.p6);
        p4.setName("Francis Ci");
        p4.setFollow(false);
        p4.setMessage("dsfdsfsa");


        Friend p5 = new Friend();
        p5.setAvatar(R.drawable.p5);
        p5.setName("Walter Ch");
        p5.setFollow(false);


        Friend p6 = new Friend();
        p6.setAvatar(R.drawable.p6);
        p6.setName("Wilbert Rowen");
        p6.setFollow(false);

        Friend p7 = new Friend();
        p7.setAvatar(R.drawable.p6);
        p7.setName("Wilbert Rowen");
        p7.setFollow(false);

        Friend p8 = new Friend();
        p8.setAvatar(R.drawable.p6);
        p8.setName("Wilbert Rowen");
        p8.setFollow(false);

        Friend p9 = new Friend();
        p9.setAvatar(R.drawable.p6);
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


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
