package com.example.lab.wallpapper4;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = findViewById(R.id.adID);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);



        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        final WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        final Drawable drawable = getResources().getDrawable(R.drawable.cosmea, null);
        final Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();


        Button mMyButton = findViewById(R.id.btnID);
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

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("life cycle event: ", "In onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("life cycle event: ", "In onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("life cycle event: ", "In onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("life cycle event: ", "In onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("life cycle event: ", "In onDestroy");

    }
    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("life cycle event: ", "In onRestart");

    }
}
