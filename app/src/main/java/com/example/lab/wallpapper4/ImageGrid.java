package com.example.lab.wallpapper4;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lab.wallpapper4.adapters.WallpaperAdapter;
import com.example.lab.wallpapper4.models.Wallpaper;
import com.example.lab.wallpapper4.viewmodels.ImageGridViewModel;

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


        ivGridElem = findViewById(R.id.ivGridElem);
        wallpaperRecyclerView = findViewById(R.id.wallpaperGridrecycler);

        initViewModel();
        initRecyclerView();

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





