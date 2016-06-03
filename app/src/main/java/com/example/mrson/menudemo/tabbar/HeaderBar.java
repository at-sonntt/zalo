package com.example.mrson.menudemo.tabbar;


import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mrson.menudemo.R;


public class HeaderBar extends RelativeLayout implements View.OnClickListener {
    public static final String TAG = HeaderBar.class.getSimpleName();

    public interface OnHeaderBarListener {
        void onLeftItemClick(View v);

        void onRightItemClick(View v);
    }

    private OnHeaderBarListener mOnHeaderBarListener;

	private Context mContext;
	private View mRootView;

	private ImageView mImgLeft;
    private TextView deleteall;

    private TextView mTxtHeaderTitle;

	public HeaderBar(Context context) {
		super(context);
        init(context);
    }

	public HeaderBar(Context context, AttributeSet attrs) {
		super(context, attrs);
        init(context);
        setAttributeSet(context, attrs);
	}

	public HeaderBar(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
        init(context);
        setAttributeSet(context, attrs);
	}
	
	private void init(Context context) {
		mContext = context;
		mRootView = LayoutInflater.from(mContext).inflate(R.layout.header_bar, this, false);
		addView(mRootView);

        mHeaderHeight = ScreenSize.convertDPToPixels(context, 45);
        mTxtHeaderTitle = (TextView) mRootView.findViewById(R.id.txt_header_title);
        mImgLeft = (ImageView) mRootView.findViewById(R.id.img_left);
        deleteall = (TextView) mRootView.findViewById(R.id.deleteall);

        //mTxtHeaderTitle.setOnClickListener(this);
        mImgLeft.setOnClickListener(this);
        deleteall.setOnClickListener(this);

        setDefaultUI();
    }

    private void setAttributeSet(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.HeaderBar);

        // get
        String title = a.getString(R.styleable.HeaderBar_header_title);
        int leftIcon = R.mipmap.home;
        String rightIcon = a.getString(R.styleable.HeaderBar_right_icon);;

        // set
        if (title != null) {
            mTxtHeaderTitle.setText(title);
//            deleteall.setText(title);
        }

        if (leftIcon == 0) {
            mImgLeft.setVisibility(GONE);
        } else {
            mImgLeft.setImageResource(leftIcon);
            mImgLeft.setVisibility(VISIBLE);
        }

        if (rightIcon !=null) {
            mTxtHeaderTitle.setText(title);
        }

        a.recycle();
    }

    public void setDefaultUI() {
        mImgLeft.setVisibility(View.GONE);
        //deleteall.setVisibility(View.GONE);
    }


	public void setOnHeaderBarListener(OnHeaderBarListener l) {
        mOnHeaderBarListener = l;
    }

    public void setTitle(String title) {
        mTxtHeaderTitle.setText(title);
    }

//    public void setVisibilityRightItem(int visibility) {
//        deleteall.setVisibility(visibility);
//    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.img_left) {
            if (mOnHeaderBarListener != null) {
                mOnHeaderBarListener.onLeftItemClick(v);
            } else {
                ((Activity) mContext).onBackPressed();
            }

        } else if (id == R.id.deleteall) {
            if (mOnHeaderBarListener != null) {
                mOnHeaderBarListener.onRightItemClick(v);
            }

        }

    }

    private TranslateAnimation mTranslateAnimation;
    private boolean mVisible = true;
    private boolean mIsRunningAnimation = false;
    private int mHeaderHeight;

    public void showHeader() {
        if (mIsRunningAnimation || mVisible) {
            return;
        }

        mTranslateAnimation = new TranslateAnimation(0, 0, -mHeaderHeight, 0);
        mTranslateAnimation.setFillAfter(true);
        mTranslateAnimation.setDuration(300);
        mTranslateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mIsRunningAnimation = true;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mIsRunningAnimation = false;
                mVisible = true;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        startAnimation(mTranslateAnimation);

    }

    public void hideHeader() {
        if (mIsRunningAnimation || !mVisible) {
            return;
        }

        mTranslateAnimation = new TranslateAnimation(0, 0 , 0, -mHeaderHeight);
        mTranslateAnimation.setFillAfter(true);
        mTranslateAnimation.setDuration(300);
        mTranslateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mIsRunningAnimation = true;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mIsRunningAnimation = false;
                mVisible = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        startAnimation(mTranslateAnimation);

    }






}
