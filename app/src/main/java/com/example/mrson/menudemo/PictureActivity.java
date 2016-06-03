package com.example.mrson.menudemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class PictureActivity extends BaseActivity {
    private static final String TAG = PictureActivity.class.getSimpleName();

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    public static final String ARG_PATH = "arg_path";
    private String mCurrentPhotoPath = "";

    // Cursor
    private Cursor mCursor;

    // 1. Data
    private ArrayList<ImageOnCache> mImageOnCaches = new ArrayList<>();
    private boolean mFirstTime = true;

    // 2. Adapter
    private CacheListGridAdapter mGridAdapter;

    // 3. Grid View
    private GridView mGridView;

    // 4. Task
    private LoadingImageOnCache mTask;

    // xml
    private ProgressBar mProgressBar;
    private TextView mTxtMenu;
    private TextView mTxtEdit;

    public static void startActivity(Activity activity, int requestCode) {
        Intent intent = new Intent(activity, PictureActivity.class);
        activity.startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mFirstTime) {
            loadImages();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCursor != null) {
            mCursor.close();
        }

        if (mTask != null) {
            mTask.cancel(true);
        }
    }


    @Override
    public int getContentView() {
        return R.layout.activity_picture;
    }

    @Override
    public void init() {
        mGridAdapter = new CacheListGridAdapter(this, mImageOnCaches);

        mGridView = (GridView) findViewById(R.id.grid_view_cache_list);
        mGridView.setAdapter(mGridAdapter);


    }

    @Override
    public void initValue() {

    }

    @Override
    public void setListener() {

//        mTxtEdit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent intent = new Intent(PictureActivity.this, CacheListEditActivity.class);
////                startActivity(intent);
//            }
//        });

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                ImageOnCache imageOnCache = mGridAdapter.getItem(position);

                if (imageOnCache != null) {
                    onDoneClick(null, imageOnCache);

                } else {
//                     item take photo click
                    onTakePhotoClick();
                }

                mGridAdapter.notifyDataSetChanged();
            }
        });

    }

    private void loadImages() {
        mTask = new LoadingImageOnCache();
        mTask.execute();
    }


    public static ImageOnCache getImageOnPhoneFromUri(Context context, Uri uri) {
        ImageOnCache imageOnCache = new ImageOnCache();
        String path;
        Bitmap bitmap;

        Cursor cursor = null;
        final String[] projection = {
                MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID
        };

        try {
            cursor = context.getContentResolver().query(uri, projection,
                    null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                int dataColumnIndex = cursor.getColumnIndex(MediaStore.Images.Media.DATA);
                int idColumnIndex = cursor.getColumnIndex(MediaStore.Images.Media._ID);

                path = cursor.getString(dataColumnIndex);
                int id = cursor.getInt(idColumnIndex);

                bitmap = MediaStore.Images.Thumbnails.getThumbnail(context
                                .getContentResolver(),
                        id, MediaStore.Images.Thumbnails.MICRO_KIND, null);

                imageOnCache.setBitmap(bitmap);
                imageOnCache.setPath(path);
                imageOnCache.setSelected(true);

            }
        } finally {
            if (cursor != null)
                cursor.close();
        }

        return imageOnCache;

    }

//    private void displayProgressBar(boolean showCircleProgressBar) {
//        mProgressBar.setVisibility(showCircleProgressBar ? View.VISIBLE : View.GONE);
//    }

    private void onDoneClick(View v, ImageOnCache imageOnCache) {
//        Intent returnIntent = new Intent();
//        returnIntent.putExtra(ARG_PATH, imageOnCache.getPath());
//        setResult(RESULT_OK, returnIntent);
//        finish();
        Intent intent= new Intent(getBaseContext(),PostActivity.class);
        intent.putExtra("image",imageOnCache.getPath());
        startActivity(intent);
    }

    private void onTakePhotoClick() {
        dispatchTakePictureIntent();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE:
                if (resultCode == RESULT_OK) {

                    if (!mCurrentPhotoPath.isEmpty()) {
                        final ImageOnCache imageOnCache = new ImageOnCache();
                        imageOnCache.setPath(mCurrentPhotoPath);
                        galleryAddPic();
                        mCurrentPhotoPath = "";
                        imageOnCache.setSelected(true);
                        mImageOnCaches.add(0, imageOnCache);
                        mGridAdapter.notifyDataSetChanged();

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                onDoneClick(null, imageOnCache);
                            }
                        }, 500);
                    }

                }
                break;

            default:
                break;
        }

    }


    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = /*"file:" +*/ image.getAbsolutePath();
        return image;
    }

    /**
     * Create a File for saving an image or video
     */
    private File getOutputMediaFile(Context context) {
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "Vivo");
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("Vivo", "failed to create directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_" + timeStamp + ".jpg");
        mCurrentPhotoPath = mediaFile.getAbsolutePath();
        return mediaFile;
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = getOutputMediaFile(this);
            // Continue only if the File was successfully created
            if (photoFile != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photoFile));
                startActivityForResult(takePictureIntent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
            }
        }
    }

    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(mCurrentPhotoPath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }

    private class LoadingImageOnCache extends AsyncTask<Void, ImageOnCache, ArrayList<ImageOnCache>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            displayProgressBar(true);
        }


        @Override
        protected ArrayList<ImageOnCache> doInBackground(Void... params) {
            ArrayList<ImageOnCache> imageOnCaches = new ArrayList<ImageOnCache>();

            // Columns
            String[] columns = {MediaStore.Images.Media.DATA,
                    MediaStore.Images.Media._ID};

            // Order By
            String sortOrder = MediaStore.Images.Media._ID;

            // Cursor
            mCursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    columns, null, null, sortOrder);

            // Count
            int count = mCursor.getCount();

            // ImageOnCache
            ImageOnCache imageOnCache;

            // Data Index
            int idColumnIndex = mCursor.getColumnIndex(MediaStore.Images.Media._ID);
            int dataColumnIndex = mCursor.getColumnIndex(MediaStore.Images.Media.DATA);
            int id;
            String path;

            for (int i = count - 1; i >= 0; i--) {
                if (isCancelled()) {
                    break;
                }

                mCursor.moveToPosition(i);

                id = mCursor.getInt(idColumnIndex);
                path = mCursor.getString(dataColumnIndex);

                imageOnCache = new ImageOnCache();
                imageOnCache.setId(id);
                imageOnCache.setPath(path);
                imageOnCache.setSelected(false);

                imageOnCaches.add(imageOnCache);
            }

            return imageOnCaches;
        }


        @Override
        protected void onPostExecute(ArrayList<ImageOnCache> result) {
            super.onPostExecute(result);
            if (isCancelled()) {
                result = null;
            }

            mImageOnCaches.clear();

            if (result != null && !result.isEmpty()) {
                mImageOnCaches.addAll(0, result);
            }

            mGridAdapter.notifyDataSetChanged();
//            displayProgressBar(false);
            mFirstTime = false;
        }

    }
}
