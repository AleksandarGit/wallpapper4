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
            case R.drawable.cat: {
                ArrayList<String> wallpaperOneTags = new ArrayList<String>(Arrays.asList("nice", "black", "cat"));
                Category nature = new Category("Cats", R.drawable.cat);

                for (int i = 0; i < 3; i++) {
                    dataSets.add(new Wallpaper("Cats", R.drawable.cat, nature, wallpaperOneTags));
                }
                dataSet=dataSets;
                break;

            }
            case R.drawable.flora: {
                ArrayList<String> wallpaperOneTags = new ArrayList<String>(Arrays.asList("nice", "black", "landscape"));
                Category nature = new Category("Nature", R.drawable.flora);

                for (int i = 0; i < 3; i++) {
                    dataSets.add(new Wallpaper("Nature", R.drawable.flora, nature, wallpaperOneTags));
                }
                dataSet=dataSets;
                break;
            }
            case R.drawable.car: {
                ArrayList<String> wallpaperOneTags = new ArrayList<String>(Arrays.asList("nice", "black", "jaguar"));
                Category car = new Category("Car", R.drawable.car);

                for (int i = 0; i < 3; i++) {
                    dataSets.add(new Wallpaper("Car", R.drawable.car, car, wallpaperOneTags));
                }
                dataSet=dataSets;
                break;
            }
            case R.drawable.cosmea: {
                ArrayList<String> wallpaperOneTags = new ArrayList<String>(Arrays.asList("nice", "black", "unicorn"));
                Category fantasy = new Category("Fantasy", R.drawable.cosmea);

                for (int i = 0; i < 3; i++) {
                    dataSets.add(new Wallpaper("Fantasy", R.drawable.cosmea, fantasy, wallpaperOneTags));
                }
                dataSet=dataSets;
                break;

            }
            case R.drawable.girl: {
                ArrayList<String> wallpaperOneTags = new ArrayList<String>(Arrays.asList("nice", "black", "cute"));
                Category girls = new Category("Girl", R.drawable.girl);

                for (int i = 0; i < 3; i++) {
                    dataSets.add(new Wallpaper("Girl", R.drawable.girl, girls, wallpaperOneTags));
                }
                dataSet=dataSets;
                break;
            }
        }
    }
//    public List<Wallpaper> getWallpapers() {
//       ArrayList <Wallpaper> dataSets = new ArrayList();
//                ArrayList<String> wallpaperOneTags = new ArrayList<String>(Arrays.asList("nice", "black", "cat"));
//                Category nature = new Category("Cats", R.drawable.cat);
//
//                for (int i = 0; i < 10; i++) {
//                    dataSets.add(new Wallpaper("Cats", R.drawable.cat, nature, wallpaperOneTags));
//                }
//                return dataSets;
//    }
}