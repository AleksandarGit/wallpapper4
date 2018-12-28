package com.example.lab.wallpapper4;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.io.IOException;

public class ImageSolo extends AppCompatActivity {
    FloatingActionButton mMyButton;
    ImageView wallpaper;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_solo);
        wallpaper = (ImageView) findViewById(R.id.ivSoloImage);
        int wallpaperIndex = this.getIntent().getExtras().getInt("Value1");

        wallpaper.setImageResource(wallpaperIndex);
        mMyButton = findViewById(R.id.fab);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        final WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);

        final Drawable drawable = getResources().getDrawable(wallpaperIndex, null);
        final Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        mMyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {

                    try {
                        wallpaperManager.setBitmap(bitmap);
                        finish();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });
    }
}
