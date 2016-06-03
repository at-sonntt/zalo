package com.example.mrson.menudemo.tabbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mrson.menudemo.R;


public class TabBar extends RelativeLayout implements View.OnClickListener {
    public interface OnTabBarListener {
        public void onTabClick(int position);
    }

  //  private static final int COLOR_DEFAULT = R.mipmap.feed;
   // private static final int COLOR_SELECTED = R.mipmap.feedchange;
  //  private static final int  COLOR_S=0xcc320b3d;

    private View mRootView;

  //  private View mViewTab1;
   // private ImageView mViewTab1;
    private ImageView mViewTab2;
    private ImageView mViewTab3;
    private ImageView mViewTab4;
    private ImageView mViewTab5;


    private TextView mTxtTitle;

    public void setTitle(String title) {
        mTxtTitle.setText(title);
    }

    private OnTabBarListener mOnTabBarListener;

    public TabBar(Context context) {
        super(context);
        init(context);
    }

    public TabBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TabBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mRootView = (View) LayoutInflater.from(context).inflate(R.layout.tab_bar, this, false);
        addView(mRootView);

        //mViewTab1 = (ImageView) mRootView.findViewById(R.id.view_tab1);
        mViewTab2 = (ImageView) mRootView.findViewById(R.id.view_tab2);
        mViewTab3 = (ImageView) mRootView.findViewById(R.id.view_tab3);
        mViewTab4 = (ImageView) mRootView.findViewById(R.id.view_tab4);
        mViewTab5 = (ImageView) mRootView.findViewById(R.id.view_tab5);

       // mViewTab1.setOnClickListener(this);
        mViewTab2.setOnClickListener(this);
        mViewTab3.setOnClickListener(this);
        mViewTab4.setOnClickListener(this);
        mViewTab5.setOnClickListener(this);
        clickTab(0);
    }

    private void setColorDefault() {
     // mViewTab1.setBackgroundResource(R.mipmap.feed);
       // mViewTab1.setImageResource(R.mipmap.menu_zalo);
        mViewTab2.setImageResource(R.mipmap.ic_message_b);
        mViewTab3.setImageResource(R.mipmap.ic_add_zalob);
        mViewTab4.setImageResource(R.mipmap.post_zalo);
        mViewTab5.setImageResource(R.mipmap.coneect_zalo);

//        mViewTab2.setBackgroundResource(R.mipmap.add);
//        mViewTab3.setBackgroundResource(R.mipmap.message_ic);
//        mViewTab4.setBackgroundResource(R.mipmap.postt);
//        mViewTab5.setBackgroundResource(R.mipmap.canvas);
//        mViewTab3.setBackgroundColor(COLOR_DEFAULT);
//        mViewTab4.setBackgroundColor(COLOR_DEFAULT);
//        mViewTab5.setBackgroundColor(COLOR_DEFAULT);

    }

    public void setOnTabBarListener(OnTabBarListener l) {
        mOnTabBarListener = l;
    }

    public void clickTab(int position) {
        setColorDefault();

        switch (position) {
            case 0:
            //    mViewTab1.setDrawingCacheBackgroundColor(COLOR_S);

                mViewTab2.setImageResource(R.mipmap.ic_message);


                if (mOnTabBarListener != null) {
                    mOnTabBarListener.onTabClick(0);
                }
                break;

            case 1:
                mViewTab3.setImageResource(R.mipmap.ic_add_zalo);
                if (mOnTabBarListener != null) {
                    mOnTabBarListener.onTabClick(1);
                }
                break;

            case 2:
                mViewTab4.setImageResource(R.mipmap.post_zalo_change);
                if (mOnTabBarListener != null) {
                    mOnTabBarListener.onTabClick(2);
                }
                break;

            case 3:
                mViewTab5.setImageResource(R.mipmap.conect_change_zalo);


                if (mOnTabBarListener != null) {
                    mOnTabBarListener.onTabClick(3);
                }break;

        }

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.view_tab2) {
            clickTab(0);
        } else if (id == R.id.view_tab3) {
            clickTab(1);
        } else if (id == R.id.view_tab4) {
            clickTab(2);
        } else if (id == R.id.view_tab5) {
            clickTab(3);
        }


    }
}
