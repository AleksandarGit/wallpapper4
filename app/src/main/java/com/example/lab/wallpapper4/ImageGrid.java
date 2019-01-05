package com.example.lab.wallpapper4;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lab.wallpapper4.adapters.WallpaperAdapter;
import com.example.lab.wallpapper4.models.Wallpaper;
import com.example.lab.wallpapper4.utility.CustomTypeFaceSpan;
import com.example.lab.wallpapper4.viewmodels.ImageGridViewModel;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.List;

public class ImageGrid extends AppCompatActivity{

    ImageView ivGridElem;

    private RecyclerView wallpaperRecyclerView;
    private WallpaperAdapter mWallpaperAdapter;
    private ImageGridViewModel imageGridViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);
        Toolbar myToolbar = findViewById(R.id.my_toolbar2);
        SpannableString s = new SpannableString(getResources().getString(R.string.app_name));
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Aileron-Heavy.otf");
        s.setSpan(new CustomTypeFaceSpan("", font),0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        myToolbar.setTitle(s);
        setSupportActionBar(myToolbar);

        ivGridElem = findViewById(R.id.ivGridElem);
        wallpaperRecyclerView = findViewById(R.id.wallpaperGridrecycler);

        initViewModel();
        initRecyclerView();

        AdView mAdView = findViewById(R.id.adID);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
    }

    private void initViewModel(){

        int imageIndex= this.getIntent().getExtras().getInt("Value1");

        imageGridViewModel = ViewModelProviders.of(this).get(ImageGridViewModel.class);
        imageGridViewModel.init(imageIndex);
        imageGridViewModel.getWallpapers().observe(this, (new Observer<List<Wallpaper>>() {
            @Override
            public void onChanged(@Nullable List<Wallpaper> subCategories) {
                mWallpaperAdapter.notifyDataSetChanged();
            }
        }));
        imageGridViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (!aBoolean) {
                    wallpaperRecyclerView.smoothScrollToPosition(imageGridViewModel.getWallpapers().getValue().size() - 1);
                }
            }
        });
    }


    private void initRecyclerView() {
        mWallpaperAdapter = new WallpaperAdapter(this, Glide.with(this),  imageGridViewModel.getWallpapers().getValue());
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        wallpaperRecyclerView.setLayoutManager(gridLayoutManager);
        wallpaperRecyclerView.setAdapter(mWallpaperAdapter);


    }


}





