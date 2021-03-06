package com.example.lab.wallpapper4.viewmodels;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.example.lab.wallpapper4.models.Wallpaper;
import com.example.lab.wallpapper4.repositories.WallpaperRepository;

import java.util.List;

public class ImageGridViewModel extends ViewModel {

    private MutableLiveData<List<Wallpaper>> mWallpapers;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init(int index) {
        if (mWallpapers != null) {
            return;
        }
        WallpaperRepository mRepo = WallpaperRepository.getInstance();
        mWallpapers = mRepo.getImages(index);
    }

    public LiveData<List<Wallpaper>> getWallpapers() {
        return mWallpapers;
    }

    public LiveData<Boolean> getIsUpdating() {
        return mIsUpdating;
    }
}