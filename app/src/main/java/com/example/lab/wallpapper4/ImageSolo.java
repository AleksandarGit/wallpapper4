package com.example.lab.wallpapper4;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.example.lab.wallpapper4.utility.DeviceDimensionsHelper;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.List;

import static com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888;

public class ImageSolo extends AppCompatActivity{


    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_solo);
        final int wallpaperIndex = this.getIntent().getExtras().getInt("Value1");

        ImageView wallpaper = findViewById(R.id.ivSoloImage);

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

        mMyButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                shareWallpaper(wallpaperIndex);
                finish();

            }
        });
    }

    private void shareWallpaper(int w) {
        Glide.with(this)
                .asBitmap()
                .load(w)
                .into(new SimpleTarget<Bitmap>() {
                          @Override
                          public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {

                              MimeTypeMap map = MimeTypeMap.getSingleton();
                              String path = getLocalBitmapUri(resource).toString();
                              String ext = path.substring(path.lastIndexOf('.') + 1);
                              String mimeType = map.getMimeTypeFromExtension(ext);

                              Intent intent = new Intent(Intent.ACTION_ATTACH_DATA);
                              intent.setDataAndType(getLocalBitmapUri(resource), mimeType);
                              intent.putExtra("mimeType", mimeType);
                              intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

                              if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
                                  List<ResolveInfo> resInfoList = ImageSolo.this
                                          .getPackageManager()
                                          .queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                                  for (ResolveInfo resolveInfo : resInfoList) {
                                      String packageName = resolveInfo.activityInfo.packageName;
                                      ImageSolo.this
                                              .grantUriPermission(packageName, getLocalBitmapUri(resource), Intent.FLAG_GRANT_READ_URI_PERMISSION);
                                  }
                              }
                              if (intent.resolveActivity(ImageSolo.this.getPackageManager()) != null) {
                              startActivity(Intent.createChooser(intent, "Set As"));}
                          }
                      }
                );
    }

    private Uri getLocalBitmapUri(Bitmap bmp) {
        Uri bmpUri = null;
        try {
            File file = new File(this.getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                    "wallpaper_hub_" + System.currentTimeMillis() + ".png");
            FileOutputStream out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
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