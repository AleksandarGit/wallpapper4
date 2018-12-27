package com.example.lab.wallpapper4.repositories;

import android.arch.lifecycle.MutableLiveData;

import com.example.lab.wallpapper4.R;
import com.example.lab.wallpapper4.models.Category;
import com.example.lab.wallpapper4.models.Wallpaper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WallpaperRepository {
    private static WallpaperRepository instance;
    private Integer categoryIndex;
    private ArrayList<Wallpaper> dataSet = new ArrayList<>();

    private WallpaperRepository(Integer categoryIndex) {
        this.categoryIndex = categoryIndex;
    }

    public static WallpaperRepository getInstance(Integer categoryIndex) {
        if (instance == null) {
            instance = new WallpaperRepository(categoryIndex);
        }
        return instance;
    }


    // Pretend to get data from a webservice or online source
    public MutableLiveData<List<Wallpaper>> getImages() {
        setWallpapers(categoryIndex);
        MutableLiveData<List<Wallpaper>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setWallpapers(Integer rDotDrawable) {
        switch (rDotDrawable) {
            case R.drawable.cat: {
                ArrayList<String> wallpaperOneTags = new ArrayList<String>(Arrays.asList("nice", "black", "cat"));
                Category nature = new Category("Cats", R.drawable.cat);

                for (int i = 0; i < 10; i++) {
                    dataSet.add(new Wallpaper("Cats", R.drawable.cat, nature, wallpaperOneTags));
                }
                break;

            }
            case R.drawable.lotus: {
                ArrayList<String> wallpaperOneTags = new ArrayList<String>(Arrays.asList("nice", "black", "landscape"));
                Category nature = new Category("Nature", R.drawable.flora);

                for (int i = 0; i < 10; i++) {
                    dataSet.add(new Wallpaper("Nature", R.drawable.car, nature, wallpaperOneTags));
                }

            }
            case R.drawable.car: {
                ArrayList<String> wallpaperOneTags = new ArrayList<String>(Arrays.asList("nice", "black", "jaguar"));
                Category car = new Category("Car", R.drawable.flora);

                for (int i = 0; i < 10; i++) {
                    dataSet.add(new Wallpaper("Car", R.drawable.car, car, wallpaperOneTags));
                }
            }
            case R.drawable.cosmea: {
                ArrayList<String> wallpaperOneTags = new ArrayList<String>(Arrays.asList("nice", "black", "dragon"));
                Category fantasy = new Category("Fantasy", R.drawable.flora);

                for (int i = 0; i < 10; i++) {
                    dataSet.add(new Wallpaper("Fantasy", R.drawable.cosmea, fantasy, wallpaperOneTags));
                }

            }
            case R.drawable.girl: {
                ArrayList<String> wallpaperOneTags = new ArrayList<String>(Arrays.asList("nice", "black", "cute"));
                Category girls = new Category("Girl", R.drawable.flora);

                for (int i = 0; i < 10; i++) {
                    dataSet.add(new Wallpaper("Girl", R.drawable.girl, girls, wallpaperOneTags));
                }

            }
        }
    }
}