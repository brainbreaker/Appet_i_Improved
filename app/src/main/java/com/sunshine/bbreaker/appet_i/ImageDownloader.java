package com.sunshine.bbreaker.appet_i;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by brainbreaker on 20/7/15.
 */
/*
 * here we are going to use an AsyncTask to download the image
  *      in background while showing the download progress
  * */

public class ImageDownloader extends AsyncTask<Void, Integer, Void> {


    private String url;
    private Context c;
    private Bitmap bmp;
    private ImageView img;


    /*--- constructor ---*/
    public ImageDownloader(String url, Bitmap bmp, ImageView img,Context c) {
    /*--- we need to pass some objects we are going to work with ---*/
        this.url = url;
        this.bmp = bmp;
        this.c = c;
        this.img = img;

    }
    /*--- we need this interface for keeping the reference to our Bitmap from the MainActivity.
     *  Otherwise, bmp would be null in our MainActivity*/


    @Override
    protected Void doInBackground(Void... arg0) {

        bmp = getBitmapFromURL(url);

        return null;
    }
//    @Override
//    protected void onPostExecute(Void result) {
//        Intent intent =
//        img.setImageBitmap(bmp);
//        Toast.makeText(c, "download complete", Toast.LENGTH_SHORT).show();
//        super.onPostExecute(result);
//    }

    public static Bitmap getBitmapFromURL(String link) {
    /*--- this method downloads an Image from the given URL,
     *  then decodes and returns a Bitmap object
     ---*/
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);

            return myBitmap;

        } catch (IOException e) {
            e.printStackTrace();
            Log.e("getBmpFromUrl error: ", e.getMessage().toString());
            return null;
        }
    }

}