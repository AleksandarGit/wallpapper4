package com.example.lab.wallpapper4;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab.wallpapper4.adapters.WallpaperAdapter;
import com.example.lab.wallpapper4.models.Category;
import com.example.lab.wallpapper4.models.Wallpaper;
import com.example.lab.wallpapper4.repositories.WallpaperRepository;
import com.example.lab.wallpapper4.viewmodels.ImageGridViewModel;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.List;

public class ImageGrid extends AppCompatActivity{

    TextView tvGridElem;
    ImageView ivGridElem;

    private RecyclerView wallpaperRecyclerView;
    private WallpaperAdapter mWallpaperAdapter;
    private ImageGridViewModel imageGridViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);

        tvGridElem = (TextView) findViewById(R.id.tvGridElem);
        ivGridElem = (ImageView) findViewById(R.id.ivGridElem);
        wallpaperRecyclerView = (RecyclerView) findViewById(R.id.wallpaperGridrecycler);

        initViewModel();
        initRecyclerView();

    }

    private void initViewModel(){
        int imageIndex = this.getIntent().getExtras().getInt("Value1");

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
        mWallpaperAdapter = new WallpaperAdapter(this, imageGridViewModel.getWallpapers().getValue());
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        wallpaperRecyclerView.setLayoutManager(gridLayoutManager);
        wallpaperRecyclerView.setAdapter(mWallpaperAdapter);


    }


}





