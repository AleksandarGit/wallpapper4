package com.example.lab.wallpapper4;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import com.example.lab.wallpapper4.utility.DeviceDimensionsHelper;

import java.io.IOException;

import static com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888;

public class ImageSolo extends AppCompatActivity {

    private FloatingActionButton mMyButton;
    private ImageView wallpaper;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_solo);
        final int wallpaperIndex = this.getIntent().getExtras().getInt("Value1");
        wallpaper = findViewById(R.id.ivSoloImage);

        RequestOptions myOptions = new RequestOptions()
                .placeholder(R.color.colorPrimaryLight)
                .error(R.color.chart_grey)
                .format(PREFER_ARGB_8888)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .signature(new ObjectKey(System.currentTimeMillis() / (24 * 60 * 60 * 1000)));
        Glide.with(this)
                .load(wallpaperIndex)
                .transition(DrawableTransitionOptions.withCrossFade())
                .thumbnail(0.1f)
                .apply(myOptions)
                .into(wallpaper);
        mMyButton = findViewById(R.id.fab);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        int screenWidth = DeviceDimensionsHelper.getDisplayWidth(this);
        final Bitmap bMap = DeviceDimensionsHelper.scaleToFitWidth
                (BitmapFactory.decodeResource(getResources(), wallpaperIndex), screenWidth);


        mMyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
//                RequestOptions myOptions = new RequestOptions()
////                        .override(2000, 6000)
////                        .centerInside()
////                        .placeholder(R.color.colorPrimaryLight)
////                        .error(R.color.chart_grey)
////                        .format(PREFER_ARGB_8888)
////                        .diskCacheStrategy(DiskCacheStrategy.ALL)
////                        .signature(new ObjectKey(System.currentTimeMillis() / (24 * 60 * 60 * 1000)));
////
////                Glide.with(ImageSolo.this)
////                        .asBitmap()
////                        .load(wallpaperIndex)
////
////                        .apply(myOptions)
////                        .transition(BitmapTransitionOptions.withCrossFade())
////                        .into(new SimpleTarget<Bitmap>() {
////                            @Override
////                            public void onResourceReady(Bitmap resource, Transition transition) {
////                                DeviceDimensionsHelper.setBitmapToScreenSize(resource, ImageSolo.this);
////                                Log.d("TAG", "onBitmapLoaded: ");
////                                Toast.makeText(ImageSolo.this, "Wallpaper Changed", Toast.LENGTH_SHORT).show();
////                            }
////                        });
                try {
                    final WallpaperManager wallMan = WallpaperManager.getInstance(ImageSolo.this);
                    wallMan.setBitmap(bMap);
                    Log.d("TAG", "onBitmapLoaded: ");
                    Toast.makeText(ImageSolo.this, "Wallpaper Changed", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Log.e("Wallpaper", "Something went wrong: " + e.toString());
                    bMap.recycle();
                }
                finish();

            }
        });
    }


}