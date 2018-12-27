package com.example.lab.wallpapper4;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
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
import com.example.lab.wallpapper4.models.Wallpaper;
import com.example.lab.wallpapper4.repositories.WallpaperRepository;
import com.example.lab.wallpapper4.viewmodels.ImageGridViewModel;
import com.google.android.gms.ads.InterstitialAd;

import java.util.List;

public class ImageGrid extends AppCompatActivity implements View.OnClickListener {

    TextView tvGridElem;
    ImageView ivGridElem;

    private RecyclerView wallpaperRecyclerView;
    private WallpaperAdapter mWallpaperAdapter;
    private ImageGridViewModel imageGridViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);

        tvGridElem = findViewById(R.id.tvGridElem);
        ivGridElem = findViewById(R.id.ivGridElem);

        wallpaperRecyclerView = findViewById(R.id.wallpaperGridrecycler);

        initRecyclerView();

    }


    private void initRecyclerView() {
        mWallpaperAdapter = new WallpaperAdapter(this, imageGridViewModel.getNicePlaces().getValue());
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(this, 5);
        wallpaperRecyclerView.setLayoutManager(gridLayoutManager);
        wallpaperRecyclerView.setAdapter(mWallpaperAdapter);

        imageGridViewModel = ViewModelProviders.of(this).get(ImageGridViewModel.class);
        Integer imageIndex = this.getIntent().getIntExtra("Value1", R.drawable.cat);
        imageGridViewModel.init(imageIndex);
        imageGridViewModel.getNicePlaces().observe(this, (new Observer<List<Wallpaper>>() {
            @Override
            public void onChanged(@Nullable List<Wallpaper> subCategories) {
                mWallpaperAdapter.notifyDataSetChanged();
            }
        }));
        imageGridViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (!aBoolean) {
                    wallpaperRecyclerView.smoothScrollToPosition(imageGridViewModel.getNicePlaces().getValue().size() - 1);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ImageSolo.class);
        intent.putExtra("ValueOfWallpaper", v.getId());
    }
}





