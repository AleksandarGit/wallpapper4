package com.example.lab.wallpapper4;

import android.app.WallpaperManager;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab.wallpapper4.adapters.CategoryAdapter;
import com.example.lab.wallpapper4.adapters.WallpaperAdapter;
import com.example.lab.wallpapper4.models.Category;
import com.example.lab.wallpapper4.models.Wallpaper;
import com.example.lab.wallpapper4.viewmodels.MainActivityViewModel;
import com.example.lab.wallpapper4.viewmodels.MainActivityViewModelSub;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    TextView tvNameCard, tvGridElem;
    ImageView imageCard, ivGridElem;
    Button mMyButton;
    private RecyclerView categoryRecyclerView, subcategoryRecyclerView;
    private CategoryAdapter mAdapter;
    private WallpaperAdapter mWallpaperAdapter;
    private MainActivityViewModel mainActivityViewModel;
    private MainActivityViewModelSub mainActivityViewModelSubcat;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvGridElem = findViewById(R.id.tvGridElem);
        tvNameCard = findViewById(R.id.tvNameCard);
        imageCard = findViewById(R.id.imageCard);
        ivGridElem = findViewById(R.id.ivGridElem);
        mMyButton = findViewById(R.id.btnID);
        categoryRecyclerView = findViewById(R.id.mainCategoryList);
        subcategoryRecyclerView = findViewById(R.id.subCategoryGrid);


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
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.init();
        mainActivityViewModel.getNicePlaces().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(@Nullable List<Category> categories) {
                mAdapter.notifyDataSetChanged();
            }
        });
        mainActivityViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if(!aBoolean){
                    categoryRecyclerView.smoothScrollToPosition(mainActivityViewModel.getNicePlaces().getValue().size()-1);
                }
            }
        });
        mainActivityViewModelSubcat = ViewModelProviders.of(this).get(MainActivityViewModelSub.class);
        mainActivityViewModelSubcat.init();
        mainActivityViewModelSubcat.getNicePlaces().observe(this, (new Observer<List<Wallpaper>>() {
            @Override
            public void onChanged(@Nullable List<Wallpaper> subCategories) {
                mWallpaperAdapter.notifyDataSetChanged();
            }
        }));
        mainActivityViewModelSubcat.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if(!aBoolean){
                    subcategoryRecyclerView.smoothScrollToPosition(mainActivityViewModelSubcat.getNicePlaces().getValue().size()-1);
                }
            }
        });
        initRecyclerView();
    }
    private void initRecyclerView(){
        mAdapter = new CategoryAdapter(this, mainActivityViewModel.getNicePlaces().getValue());
        mWallpaperAdapter = new WallpaperAdapter(this, mainActivityViewModelSubcat.getNicePlaces().getValue());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 5);
        categoryRecyclerView.setLayoutManager(linearLayoutManager);
        subcategoryRecyclerView.setLayoutManager(gridLayoutManager);
        categoryRecyclerView.setAdapter(mAdapter);
        subcategoryRecyclerView.setAdapter(mWallpaperAdapter);



    }
}
