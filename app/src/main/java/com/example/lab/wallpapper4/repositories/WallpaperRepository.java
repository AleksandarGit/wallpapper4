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

    public static WallpaperRepository getInstance(){
        if(instance == null){
            instance = new WallpaperRepository();
        }
        return instance;
    }


    // Pretend to get data from a webservice or online source
    public MutableLiveData<List<Wallpaper>> getSubcategories(){
        setWallpapers();
        MutableLiveData<List<Wallpaper>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setWallpapers(){
        ArrayList<String> wallpaperOneTags = new ArrayList<String>(Arrays.asList("nice", "black", "cat"));
        Category nature = new Category("Nature", R.drawable.flora);

        dataSet.add(new Wallpaper("Animals", R.drawable.cat, nature, wallpaperOneTags ));
        dataSet.add(new Wallpaper("Plants", R.drawable.lotus, nature, wallpaperOneTags ));
        dataSet.add(new Wallpaper("Fungi", R.drawable.car, nature, wallpaperOneTags ));
        dataSet.add(new Wallpaper("Fantasy", R.drawable.cosmea, nature, wallpaperOneTags ));
        dataSet.add(new Wallpaper("Marine", R.drawable.girl, nature, wallpaperOneTags ));

    }
}
/*

 */