package com.example.lab.wallpapper4.utility;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;

import java.io.IOException;

public class DeviceDimensionsHelper {

    // DeviceDimensionsHelper.getDisplayWidth(context) => (display width in pixels)
    public static int getDisplayWidth(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    // DeviceDimensionsHelper.getDisplayHeight(context) => (display height in pixels)
    public static int getDisplayHeight(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.heightPixels;
    }

    // DeviceDimensionsHelper.convertDpToPixel(25f, context) => (25dp converted to pixels)
    public static float convertDpToPixel(float dp, Context context){
        Resources r = context.getResources();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
    }

    // DeviceDimensionsHelper.convertPixelsToDp(25f, context) => (25px converted to dp)
    public static float convertPixelsToDp(float px, Context context){
        Resources r = context.getResources();
        DisplayMetrics metrics = r.getDisplayMetrics();
        float dp = px / (metrics.densityDpi / 160f);
        return dp;
    }

    public static void setBitmapToScreenSize(Bitmap image, Context context) {
        // Get display dimensions
        final DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        final int displayWidth = metrics.widthPixels;
        final int displayHeight = metrics.heightPixels;

        // obtain the original Bitmap's dimensions
        final int originalWidth = image.getWidth();
        final int originalHeight = image.getHeight();

        // Obtain the horizontal and vertical scale factors
        final float horizontalScaleFactor = (float) originalWidth / (float) displayWidth;
        final float verticalScaleFactor = (float) originalHeight / (float) displayHeight;

        // Get the biggest scale factor to use in order to maintain original image's aspect ratio
        final float scaleFactor = Math.max(verticalScaleFactor, horizontalScaleFactor);
        final int finalWidth = (int) (originalWidth / scaleFactor);
        final int finalHeight = (int) (originalHeight / scaleFactor);

        // Create the final bitmap
        final Bitmap wallpaperBmp = Bitmap.createScaledBitmap(
                image, finalWidth, finalHeight, true);

        // Recycle the original bitmap
        image.recycle();

        // Finally set it as wallpaper
        try {
            final WallpaperManager wallMan = WallpaperManager.getInstance(context);
            wallMan.setBitmap(wallpaperBmp);
        } catch (IOException e) {
            Log.e("Wallpaper", "Something went wrong: " + e.toString());
            wallpaperBmp.recycle();
        }
    }


    // Scale and maintain aspect ratio given a desired width
    // BitmapScaler.scaleToFitWidth(bitmap, 100);
    public static Bitmap scaleToFitWidth(Bitmap b, int width)
    {
        float factor = width / (float) b.getWidth();
        return Bitmap.createScaledBitmap(b, width, (int) (b.getHeight() * factor), true);
    }


    // Scale and maintain aspect ratio given a desired height
    // BitmapScaler.scaleToFitHeight(bitmap, 100);
    public static Bitmap scaleToFitHeight(Bitmap b, int height)
    {
        float factor = height / (float) b.getHeight();
        return Bitmap.createScaledBitmap(b, (int) (b.getWidth() * factor), height, true);
    }
}