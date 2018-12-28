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
    private WallpaperRepository mRepo;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init(int index) {
        if (mWallpapers != null) {
            return;
        }
        mRepo = WallpaperRepository.getInstance();
        mWallpapers = mRepo.getImages(index);
    }

    public void addNewWallpaper(final Wallpaper wallpaper) {
        mIsUpdating.setValue(true);

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<Wallpaper> currentSubcategories = mWallpapers.getValue();
                currentSubcategories.add(wallpaper);
                mWallpapers.postValue(currentSubcategories);
                mIsUpdating.postValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    public LiveData<List<Wallpaper>> getWallpapers() {
        return mWallpapers;
    }


    public LiveData<Boolean> getIsUpdating() {
        return mIsUpdating;
    }
}