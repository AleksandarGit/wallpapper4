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
            case R.drawable.abstract0: {
                ArrayList<String> wallpaperAbstractTags = new ArrayList<>(Arrays.asList("nice", "black", "white"));
                Category abstractCategory = new Category("The Art of Abstract", R.drawable.abstract0);

                dataSets.add(new Wallpaper("Abstract1", R.drawable.abstract1, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract2", R.drawable.abstract2, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract3", R.drawable.abstract3, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract4", R.drawable.abstract4, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract5", R.drawable.abstract5, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract6", R.drawable.abstract6, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract7", R.drawable.abstract7, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract8", R.drawable.abstract8, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract9", R.drawable.abstract9, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract10", R.drawable.abstract10, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract11", R.drawable.abstract11, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract12", R.drawable.abstract12, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract13", R.drawable.abstract13, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract14", R.drawable.abstract14, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract15", R.drawable.abstract15, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract16", R.drawable.abstract16, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract17", R.drawable.abstract17, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract18", R.drawable.abstract18, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract19", R.drawable.abstract19, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract20", R.drawable.abstract20, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract21", R.drawable.abstract21, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract22", R.drawable.abstract22, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract23", R.drawable.abstract23, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract24", R.drawable.abstract24, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract25", R.drawable.abstract25, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract26", R.drawable.abstract26, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract27", R.drawable.abstract27, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract28", R.drawable.abstract28, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract29", R.drawable.abstract29, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract30", R.drawable.abstract30, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract31", R.drawable.abstract31, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract32", R.drawable.abstract32, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract33", R.drawable.abstract33, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract34", R.drawable.abstract34, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract35", R.drawable.abstract35, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract36", R.drawable.abstract36, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract37", R.drawable.abstract37, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract38", R.drawable.abstract38, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract39", R.drawable.abstract39, abstractCategory, wallpaperAbstractTags));
                dataSets.add(new Wallpaper("Abstract40", R.drawable.abstract40, abstractCategory, wallpaperAbstractTags));

                dataSet=dataSets;
                break;

            }
            case R.drawable.cars0: {
                ArrayList<String> wallpaperCarsTags = new ArrayList<>(Arrays.asList("nice", "black", "white"));
                Category cars = new Category("Cars", R.drawable.cars0);

                dataSets.add(new Wallpaper("Car1", R.drawable.cars1, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars2, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars3, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars4, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars5, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars6, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars7, cars, wallpaperCarsTags));
                //dataSets.add(new Wallpaper("Car1", R.drawable.cars8, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars9, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars10, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars11, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars12, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars13, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars14, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars15, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars16, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars17, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars18, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars19, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars20, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars21, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars22, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars23, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars24, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars25, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars26, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars27, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars28, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars29, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars30, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars31, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars32, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars33, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars34, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars35, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars36, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars37, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars38, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars39, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars40, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars41, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars42, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars43, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars44, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars45, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars46, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars47, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars48, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars49, cars, wallpaperCarsTags));
                dataSets.add(new Wallpaper("Car1", R.drawable.cars50, cars, wallpaperCarsTags));

                dataSet=dataSets;
                break;

            }
            case R.drawable.fruits0: {
                ArrayList<String> wallpaperFruitTags = new ArrayList<>(Arrays.asList("nice", "adventure", "landscape"));
                Category fruits = new Category("Fruits", R.drawable.fruits0);

                dataSets.add(new Wallpaper("Fruits1", R.drawable.fruits1, fruits, wallpaperFruitTags));
                dataSets.add(new Wallpaper("Fruits2", R.drawable.fruits2, fruits, wallpaperFruitTags));
                dataSets.add(new Wallpaper("Fruits3", R.drawable.fruits3, fruits, wallpaperFruitTags));
                dataSets.add(new Wallpaper("Fruits4", R.drawable.fruits4, fruits, wallpaperFruitTags));
                dataSets.add(new Wallpaper("Fruits5", R.drawable.fruits5, fruits, wallpaperFruitTags));
                dataSets.add(new Wallpaper("Fruits6", R.drawable.fruits6, fruits, wallpaperFruitTags));
                dataSets.add(new Wallpaper("Fruits7", R.drawable.fruits7, fruits, wallpaperFruitTags));
                dataSets.add(new Wallpaper("Fruits8", R.drawable.fruits8, fruits, wallpaperFruitTags));
                dataSets.add(new Wallpaper("Fruits9", R.drawable.fruits9, fruits, wallpaperFruitTags));
                dataSets.add(new Wallpaper("Fruits10", R.drawable.fruits10, fruits, wallpaperFruitTags));
                dataSets.add(new Wallpaper("Fruits11", R.drawable.fruits11, fruits, wallpaperFruitTags));
                dataSets.add(new Wallpaper("Fruits12", R.drawable.fruits12, fruits, wallpaperFruitTags));
                dataSets.add(new Wallpaper("Fruits13", R.drawable.fruits13, fruits, wallpaperFruitTags));
                dataSets.add(new Wallpaper("Fruits14", R.drawable.fruits14, fruits, wallpaperFruitTags));
                dataSets.add(new Wallpaper("Fruits15", R.drawable.fruits15, fruits, wallpaperFruitTags));
                dataSets.add(new Wallpaper("Fruits16", R.drawable.fruits16, fruits, wallpaperFruitTags));

                dataSet=dataSets;
                break;
            }
            case R.drawable.nature: {
                ArrayList<String> wallpaperThreeTags = new ArrayList<>(Arrays.asList("nice", "black", "jaguar"));
                Category nature = new Category("Nature", R.drawable.nature);

                dataSets.add(new Wallpaper("Nature1", R.drawable.nature1, nature, wallpaperThreeTags));
                dataSets.add(new Wallpaper("Nature2", R.drawable.nature2, nature, wallpaperThreeTags));

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