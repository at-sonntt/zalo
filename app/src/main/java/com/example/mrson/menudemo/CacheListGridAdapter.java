package com.example.mrson.menudemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.mrson.menudemo.tabbar.ScreenSize;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Tuy on 7/14/2015.
 */
public class CacheListGridAdapter extends BaseAdapter {
    private static final String TAG = CacheListGridAdapter.class.getSimpleName();

    private static final int NUMBER_COLUMNS = 4;

    private Context mContext;

    private ArrayList<ImageOnCache> mImageOnCaches;
    private final int mItemHeight;
    private int mSpacing = 0;
    private RelativeLayout.LayoutParams mImageViewLayoutParams;

    public CacheListGridAdapter(Context context, ArrayList<ImageOnCache> imageOnCaches) {
        mContext = context;
        mImageOnCaches = imageOnCaches;

        mSpacing = mContext.getResources()
                .getDimensionPixelSize(R.dimen.camera_roll_grid_spacing);

        int width = ScreenSize.getWidth(mContext);

        mItemHeight = (width - (NUMBER_COLUMNS - 1) * mSpacing) / NUMBER_COLUMNS;


        mImageViewLayoutParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, mItemHeight);

    }


    public void setData(ArrayList<ImageOnCache> imageOnCaches) {
        mImageOnCaches = imageOnCaches;
    }

    @Override
    public int getCount() {
        int count = mImageOnCaches.size() + NUMBER_COLUMNS + 1;

//        if (mImageOnCaches.size() > 0) {
//            count = mImageOnCaches.size() + NUMBER_COLUMNS + 1;
//        }

        return count;
    }

    @Override
    public ImageOnCache getItem(int position) {
        return position < (NUMBER_COLUMNS + 1)
                ? null : mImageOnCaches.get(position - NUMBER_COLUMNS - 1);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position < NUMBER_COLUMNS ? 0 : 1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    private static class ViewHolder {
        ImageView imgImage;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // First check if this is the top row
        if (position < NUMBER_COLUMNS) {
            if (convertView == null) {
                convertView = new View(mContext);
            }
            return convertView;
        }

        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.picture_item, parent, false);
            holder = new ViewHolder();

            holder.imgImage = (ImageView) convertView.findViewById(R.id.img_image);



            // setLayoutParams
            holder.imgImage.setLayoutParams(mImageViewLayoutParams);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        setValue(holder, position);

        return convertView;
    }

    private void setValue(final ViewHolder holder, final int position) {

        if (position == NUMBER_COLUMNS) {



            holder.imgImage.setBackgroundColor(0x00FFFFFF);

            Picasso.with(mContext)
                    .load(R.mipmap.bg_loading_image_transparent)
                    .into(holder.imgImage);

        } else {

            ImageOnCache imageOnCache = getItem(position);


            holder.imgImage.setBackgroundColor(0xFFCCCCCC);

            String uri = "file://" + imageOnCache.getPath();
            Log.d("=====",String.valueOf(mItemHeight));
            Picasso.with(mContext)
                    .load(uri)
                    .resize(mItemHeight, mItemHeight)
                    .error(R.mipmap.empty_photo)
                    .centerCrop()
                    .into(holder.imgImage);

        }

    }

}