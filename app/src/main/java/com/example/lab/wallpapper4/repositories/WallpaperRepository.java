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
    private ArrayList<Wallpaper> dataSet = new ArrayList<>();

    private WallpaperRepository() {


    }

    public static WallpaperRepository getInstance() {
        if (instance == null) {
            instance = new WallpaperRepository();
        }
        return instance;
    }


    // Pretend to get data from a webservice or online source
    public MutableLiveData<List<Wallpaper>> getImages(int categoryIndex) {
        setWallpapers(categoryIndex);
        MutableLiveData<List<Wallpaper>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setWallpapers(int rDotDrawable) {
        ArrayList<Wallpaper> dataSets = new ArrayList<>();
        switch (rDotDrawable) {
            case R.drawable.bw: {
                ArrayList<String> wallpaperOneTags = new ArrayList<>(Arrays.asList("nice", "black", "white"));
                Category bw = new Category("Black & White", R.drawable.bw);

                for (int i = 0; i < 30; i++) {
                    dataSets.add(new Wallpaper("Black and White", R.drawable.bw, bw, wallpaperOneTags));
                }
                dataSet=dataSets;
                break;

            }
            case R.drawable.adventure: {
                ArrayList<String> wallpaperTwoTags = new ArrayList<>(Arrays.asList("nice", "adventure", "landscape"));
                Category adventure = new Category("Adventure", R.drawable.adventure);

                for (int i = 0; i < 30; i++) {
                    dataSets.add(new Wallpaper("Adventure", R.drawable.adventure, adventure, wallpaperTwoTags));
                }
                dataSet=dataSets;
                break;
            }
            case R.drawable.nature: {
                ArrayList<String> wallpaperThreeTags = new ArrayList<>(Arrays.asList("nice", "black", "jaguar"));
                Category nature = new Category("Nature", R.drawable.nature);

                for (int i = 0; i < 30; i++) {
                    dataSets.add(new Wallpaper("Nature", R.drawable.nature, nature, wallpaperThreeTags));
                }
                dataSet=dataSets;
                break;
            }
            case R.drawable.cosmea: {
                ArrayList<String> wallpaperOneTags = new ArrayList<>(Arrays.asList("nice", "black", "unicorn"));
                Category fantasy = new Category("Fantasy", R.drawable.cosmea);

                for (int i = 0; i < 30; i++) {
                    dataSets.add(new Wallpaper("Fantasy", R.drawable.cosmea, fantasy, wallpaperOneTags));
                }
                dataSet=dataSets;
                break;

            }
            case R.drawable.girl: {
                ArrayList<String> wallpaperOneTags = new ArrayList<>(Arrays.asList("nice", "black", "cute"));
                Category girls = new Category("Girl", R.drawable.girl);

                for (int i = 0; i < 30; i++) {
                    dataSets.add(new Wallpaper("Girl", R.drawable.girl, girls, wallpaperOneTags));
                }
                dataSet=dataSets;
                break;
            }
        }
    }
}