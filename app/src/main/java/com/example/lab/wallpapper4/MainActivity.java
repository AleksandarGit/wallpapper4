package com.example.lab.wallpapper4;

import android.app.WallpaperManager;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab.wallpapper4.adapters.CategoryAdapter;
import com.example.lab.wallpapper4.models.Category;
import com.example.lab.wallpapper4.viewmodels.MainActivityViewModel;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.List;

public class MainActivity extends AppCompatActivity{

    TextView tvNameCard;
    ImageView imageCard;
    private RecyclerView categoryRecyclerView;
    private CategoryAdapter mAdapter;
    private MainActivityViewModel mainActivityViewModel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNameCard = findViewById(R.id.tvNameCard);
        imageCard = findViewById(R.id.imageCard);
        categoryRecyclerView = findViewById(R.id.mainCategoryList);


        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = findViewById(R.id.adID);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

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

        initRecyclerView();
    }
    private void initRecyclerView(){
        mAdapter = new CategoryAdapter(this, mainActivityViewModel.getNicePlaces().getValue());


        mAdapter.setOnItemClickListener(new CategoryAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent = new Intent(v.getContext(), ImageGrid.class);
                intent.putExtra("Value1", R.id.imageCard);
                v.getContext().startActivity(intent);
            }

            @Override
            public void onItemLongClick(int position, View v) {
                Intent intent = new Intent(v.getContext(), ImageGrid.class);
                intent.putExtra("Value1", R.id.imageCard);
                v.getContext().startActivity(intent);
            }
        });
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        categoryRecyclerView.setLayoutManager(linearLayoutManager);
        categoryRecyclerView.setAdapter(mAdapter);
    }


}
