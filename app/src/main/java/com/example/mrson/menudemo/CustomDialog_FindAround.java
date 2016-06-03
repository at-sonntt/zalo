package com.example.mrson.menudemo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Tuy on 7/13/2015.
 */
public class CustomDialog_FindAround extends Dialog implements View.OnClickListener {
    Activity activity;

    public CustomDialog_FindAround(Activity a) {
        super(a);
        this.activity = a;
    }

    LinearLayout l1, l2, l3, l4, l5;
    ImageView checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    int status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog_findaround);
        checkBox1 = (ImageView) findViewById(R.id.checkbox1);
        checkBox2 = (ImageView) findViewById(R.id.checkbox2);
        checkBox3 = (ImageView) findViewById(R.id.checkbox3);
        checkBox4 = (ImageView) findViewById(R.id.checkbox4);
        checkBox5 = (ImageView) findViewById(R.id.checkbox5);

        l1 = (LinearLayout) findViewById(R.id.l1);
        l2 = (LinearLayout) findViewById(R.id.l2);
        l3 = (LinearLayout) findViewById(R.id.l3);
        l4 = (LinearLayout) findViewById(R.id.l4);
        l5 = (LinearLayout) findViewById(R.id.l5);

        l1.setOnClickListener(this);
        l2.setOnClickListener(this);
        l3.setOnClickListener(this);
        l4.setOnClickListener(this);
        l5.setOnClickListener(this);
        checkBox1.setVisibility(View.GONE);
        checkBox2.setVisibility(View.GONE);
        checkBox3.setVisibility(View.GONE);
        checkBox4.setVisibility(View.GONE);
        checkBox5.setVisibility(View.GONE);

    }

    public void intent() {
        Intent intent = new Intent(activity, FindAroundActivity.class);
        intent.putExtra("status", status);
        activity.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.l1) {
            checkBox1.setVisibility(View.VISIBLE);
            checkBox2.setVisibility(View.INVISIBLE);
            checkBox3.setVisibility(View.INVISIBLE);
            checkBox4.setVisibility(View.INVISIBLE);
            checkBox5.setVisibility(View.INVISIBLE);
            status = 1;

        } else if (id == R.id.l2) {
            checkBox1.setVisibility(View.INVISIBLE);
            checkBox2.setVisibility(View.VISIBLE);
            checkBox3.setVisibility(View.INVISIBLE);
            checkBox4.setVisibility(View.INVISIBLE);
            checkBox5.setVisibility(View.INVISIBLE);
            status = 2;

        } else if (id == R.id.l3) {
            checkBox1.setVisibility(View.INVISIBLE);
            checkBox2.setVisibility(View.INVISIBLE);
            checkBox3.setVisibility(View.VISIBLE);
            checkBox4.setVisibility(View.INVISIBLE);
            checkBox5.setVisibility(View.INVISIBLE);
            status = 3;

        } else if (id == R.id.l4) {
            checkBox1.setVisibility(View.INVISIBLE);
            checkBox2.setVisibility(View.INVISIBLE);
            checkBox3.setVisibility(View.INVISIBLE);
            checkBox4.setVisibility(View.VISIBLE);
            checkBox5.setVisibility(View.INVISIBLE);
            status = 4;

        } else if (id == R.id.l5) {

            checkBox1.setVisibility(View.INVISIBLE);
            checkBox2.setVisibility(View.INVISIBLE);
            checkBox3.setVisibility(View.INVISIBLE);
            checkBox4.setVisibility(View.INVISIBLE);
            checkBox5.setVisibility(View.VISIBLE);
            status = 5;

        }
        intent();
    }
}

