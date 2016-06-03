package com.example.mrson.menudemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by mrson on 30/06/2015.
 */
public class ComentActivity extends Activity {
    ArrayList<Cmt> arrayList = new ArrayList<Cmt>();
    CmtAdapter cmtAdapter;
    Cmt cmt;
    private SwipeRefreshLayout layout_fresh;

    Myfeed obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coment_layout);

        Bundle b = getIntent().getExtras();
        obj = b.getParcelable("obj");
        TextView name_txt = (TextView) findViewById(R.id.title);
        TextView status_txt = (TextView) findViewById(R.id.status);
        ImageView img_main = (ImageView) findViewById(R.id.img);
        ImageView img_avar = (ImageView) findViewById(R.id.avar);
        TextView totle_like = (TextView) findViewById(R.id.total_like);
        name_txt.setText(obj.getName());
        status_txt.setText(obj.getStatus());

        totle_like.setText(String.valueOf(obj.getTotal_like()) + " Người thích điều này");
        Picasso.with(getBaseContext()).load(obj.getImage()).into(img_avar);
        Picasso.with(getBaseContext()).load(obj.getProfilePic()).into(img_main);
        // img_like.setImageResource(obj.getTotal_like());

//        TextView textView = (TextView) findViewById(R.id.title);
//        textView.setText(obj.getStrValue());


        ImageView img = (ImageView) findViewById(R.id.home);
        final EditText editText = (EditText) findViewById(R.id.ed_cmt);
        //  EditText messageInput = (EditText) findViewById(R.id.message_input);


        ListView listView = (ListView) findViewById(R.id.list_coment);
        final ImageView img_enter = (ImageView) findViewById(R.id.bnt_enter);
        cmtAdapter = new CmtAdapter(getBaseContext(), arrayList);
        listView.setAdapter(cmtAdapter);


        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        LinearLayout ll = (LinearLayout) findViewById(R.id.ll_enter);

        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = String.valueOf(editText.getText().append("\ud83d\ude01"));


                if (text.equals("") == false) {


                    cmt = new Cmt();
                    cmt.setCmt(text);


                    arrayList.add(cmt);

                    cmtAdapter.notifyDataSetChanged();
                    editText.getText().clear();
                    Toast toast = Toast.makeText(getBaseContext(), "Đã gửi bình luận", Toast.LENGTH_SHORT);
                    toast.show();
                    img_enter.setImageResource(R.mipmap.ic_enter_change);

                }

            }
        });

    }


    public void getText() {
        EditText editText = (EditText) findViewById(R.id.ed_cmt);
        if (editText.getText() != null) {
            Editable getText = editText.getText();
        }

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
