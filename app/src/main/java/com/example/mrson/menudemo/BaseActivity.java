package com.example.mrson.menudemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Tuy on 7/14/2015.
 */
public abstract class BaseActivity extends AppCompatActivity {
    public static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        init();
        initValue();
        setListener();
    }

    public abstract int getContentView();

    public abstract void init();

    public abstract void initValue();

    public abstract void setListener();
}
