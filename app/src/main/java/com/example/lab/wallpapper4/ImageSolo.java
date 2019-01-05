package com.example.lab.wallpapper4;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.example.lab.wallpapper4.utility.CustomTypeFaceSpan;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import me.msfjarvis.apprate.AppRate;

import static com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888;

public class ImageSolo extends AppCompatActivity {
    Bitmap bitmap = null;

    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_image_solo);

        new AppRate(this)
                .setMinDaysUntilPrompt(0)
                .setMinLaunchesUntilPrompt(1)
                .setShowIfAppHasCrashed(false)
                .init();

        Toolbar myToolbar = findViewById(R.id.my_toolbar3);
        SpannableString s = new SpannableString(getResources().getString(R.string.app_name));
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Aileron-Heavy.otf");
        s.setSpan(new CustomTypeFaceSpan("", font),0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        myToolbar.setTitle(s);
        setSupportActionBar(myToolbar);

        final int wallpaperIndex = this.getIntent().getExtras().getInt("Value1");

        ImageView wallpaper = findViewById(R.id.ivSoloImage);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.car);
        wallpaper.setImageBitmap(bitmap);

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
        FloatingActionButton mMyButton = findViewById(R.id.fab);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        bitmap = BitmapFactory.decodeResource(getResources(), wallpaperIndex);
        wallpaper.setImageBitmap(bitmap);
        mMyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

                shareWallpaper(bitmap);
                finish();

            }
        });

        //MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = findViewById(R.id.adID);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
    }

    private void shareWallpaper(Bitmap bitmap) {

//        Glide.with(this)
//                .asBitmap()
//                .load(w)
//                .into(new SimpleTarget<Bitmap>() {
//                          @Override
//                          public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {

        MimeTypeMap map = MimeTypeMap.getSingleton();
        String path = getLocalBitmapUri(bitmap).toString();
        String ext = path.substring(path.lastIndexOf('.') + 1);
        String mimeType = map.getMimeTypeFromExtension(ext);

        Intent intent = new Intent(Intent.ACTION_ATTACH_DATA);
        intent.setDataAndType(getLocalBitmapUri(bitmap), mimeType);
        intent.putExtra("mimeType", mimeType);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            List<ResolveInfo> resInfoList = ImageSolo.this
                    .getPackageManager()
                    .queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
            for (ResolveInfo resolveInfo : resInfoList) {
                String packageName = resolveInfo.activityInfo.packageName;
                ImageSolo.this
                        .grantUriPermission(packageName, getLocalBitmapUri(bitmap), Intent.FLAG_GRANT_READ_URI_PERMISSION);
            }
        }
        if (intent.resolveActivity(ImageSolo.this.getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Set As"));
        }

//                      }}
//                );
    }

    private Uri getLocalBitmapUri(Bitmap bmp) {
        Uri bmpUri = null;
        try {
            File file = new File(this.getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                    "wallpaper_hub_" + System.currentTimeMillis() + ".png");
            FileOutputStream out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.close();
            bmpUri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".provider", file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmpUri;
    }


}