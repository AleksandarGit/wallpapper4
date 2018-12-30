package com.example.lab.wallpapper4;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lab.wallpapper4.adapters.CategoryAdapter;
import com.example.lab.wallpapper4.models.Category;
import com.example.lab.wallpapper4.viewmodels.MainActivityViewModel;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.List;

public class MainActivity extends AppCompatActivity {

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

        initViewModel();
        initRecyclerView();


    }

    private void initViewModel() {
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.init();
        mainActivityViewModel.getCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(@Nullable List<Category> categories) {
                mAdapter.notifyDataSetChanged();
            }
        });
        mainActivityViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (!aBoolean) {
                    categoryRecyclerView.smoothScrollToPosition(mainActivityViewModel.getCategories().getValue().size() - 1);
                }
            }
        });
    }

    private void initRecyclerView() {
        mAdapter = new CategoryAdapter(mainActivityViewModel.getCategories().getValue(), this, Glide.with(this));
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        categoryRecyclerView.setLayoutManager(linearLayoutManager);
        categoryRecyclerView.setAdapter(mAdapter);
    }
}
