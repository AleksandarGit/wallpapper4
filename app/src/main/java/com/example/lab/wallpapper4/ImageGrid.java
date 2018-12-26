package com.example.lab.wallpapper4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab.wallpapper4.adapters.CategoryAdapter;
import com.example.lab.wallpapper4.adapters.WallpaperAdapter;
import com.example.lab.wallpapper4.viewmodels.MainActivityViewModel;
import com.example.lab.wallpapper4.viewmodels.MainActivityViewModelSub;
import com.google.android.gms.ads.InterstitialAd;

public class ImageGrid extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    TextView tvGridElem;
    ImageView ivGridElem;
    Button mMyButton;
    private RecyclerView wallpaperRecyclerView;
    private WallpaperAdapter mWallpaperAdapter;
    private MainActivityViewModelSub mainActivityViewModelSubcat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);

        tvGridElem = findViewById(R.id.tvGridElem);
        ivGridElem = findViewById(R.id.ivGridElem);
        mMyButton = findViewById(R.id.btnID);
        wallpaperRecyclerView = findViewById(R.id.wallpaperGridrecycler);
    }
}





