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
    private ArrayList<Wallpaper> dataSets;
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

        switch (rDotDrawable) {
            case R.drawable.fruits0: {
                dataSets= new ArrayList<>();
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
            case R.drawable.animals0: {
                dataSets= new ArrayList<>();
                ArrayList<String> wallpaperAnimalsTags = new ArrayList<>(Arrays.asList("nice", "black", "jaguar"));
                Category animals = new Category("Animals", R.drawable.animals0);

                dataSets.add(new Wallpaper("animals1", R.drawable.animals1, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals2", R.drawable.animals2, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals3", R.drawable.animals3, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals4", R.drawable.animals4, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals5", R.drawable.animals5, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals6", R.drawable.animals6, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals7", R.drawable.animals7, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals8", R.drawable.animals8, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals9", R.drawable.animals9, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals10", R.drawable.animals10, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals11", R.drawable.animals11, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals12", R.drawable.animals12, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals13", R.drawable.animals13, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals14", R.drawable.animals14, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals15", R.drawable.animals15, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals16", R.drawable.animals16, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals17", R.drawable.animals17, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals18", R.drawable.animals18, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals19", R.drawable.animals19, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals20", R.drawable.animals20, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals21", R.drawable.animals21, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals22", R.drawable.animals22, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals23", R.drawable.animals23, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals24", R.drawable.animals24, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals25", R.drawable.animals25, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals26", R.drawable.animals26, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals27", R.drawable.animals27, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals28", R.drawable.animals28, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals29", R.drawable.animals29, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals30", R.drawable.animals30, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals31", R.drawable.animals31, animals, wallpaperAnimalsTags));
                dataSets.add(new Wallpaper("animals32", R.drawable.animals32, animals, wallpaperAnimalsTags));
                dataSet=dataSets;
                break;
            }
            case R.drawable.citylights0: {
                dataSets= new ArrayList<>();
                ArrayList<String> wallpaperCitylightsTags = new ArrayList<>(Arrays.asList("nice", "black", "unicorn"));
                Category citylightsCategory = new Category("Space", R.drawable.citylights0);

                dataSets.add(new Wallpaper("citylights1", R.drawable.citylights1, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights2", R.drawable.citylights2, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights3", R.drawable.citylights3, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights4", R.drawable.citylights4, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights5", R.drawable.citylights5, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights6", R.drawable.citylights6, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights7", R.drawable.citylights7, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights8", R.drawable.citylights8, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights9", R.drawable.citylights9, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights10", R.drawable.citylights10, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights11", R.drawable.citylights11, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights12", R.drawable.citylights12, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights13", R.drawable.citylights13, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights14", R.drawable.citylights14, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights15", R.drawable.citylights15, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights16", R.drawable.citylights16, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights17", R.drawable.citylights17, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights18", R.drawable.citylights18, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights19", R.drawable.citylights19, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights20", R.drawable.citylights20, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights21", R.drawable.citylights21, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights22", R.drawable.citylights22, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights23", R.drawable.citylights23, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights24", R.drawable.citylights24, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights25", R.drawable.citylights25, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights26", R.drawable.citylights26, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights27", R.drawable.citylights27, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights28", R.drawable.citylights28, citylightsCategory, wallpaperCitylightsTags));
                dataSets.add(new Wallpaper("citylights29", R.drawable.citylights29, citylightsCategory, wallpaperCitylightsTags));
                dataSet=dataSets;
                break;

            }
            case R.drawable.skycloud0: {
                dataSets= new ArrayList<>();
                ArrayList<String> wallpaperSkycloudTags = new ArrayList<>(Arrays.asList("nice", "black", "unicorn"));
                Category skycloudCategory = new Category("SkyCloud", R.drawable.skycloud0);

                dataSets.add(new Wallpaper("skycloud1", R.drawable.skycloud1, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud2", R.drawable.skycloud2, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud3", R.drawable.skycloud3, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud4", R.drawable.skycloud4, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud5", R.drawable.skycloud5, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud6", R.drawable.skycloud6, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud7", R.drawable.skycloud7, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud8", R.drawable.skycloud8, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud9", R.drawable.skycloud9, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud10", R.drawable.skycloud10, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud11", R.drawable.skycloud11, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud12", R.drawable.skycloud12, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud13", R.drawable.skycloud13, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud14", R.drawable.skycloud14, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud15", R.drawable.skycloud15, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud16", R.drawable.skycloud16, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud17", R.drawable.skycloud17, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud18", R.drawable.skycloud18, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud19", R.drawable.skycloud19, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud20", R.drawable.skycloud20, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud21", R.drawable.skycloud21, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud22", R.drawable.skycloud22, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud23", R.drawable.skycloud23, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud24", R.drawable.skycloud24, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud25", R.drawable.skycloud25, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud26", R.drawable.skycloud26, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud27", R.drawable.skycloud27, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud28", R.drawable.skycloud28, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud29", R.drawable.skycloud29, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud30", R.drawable.skycloud30, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud31", R.drawable.skycloud31, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud32", R.drawable.skycloud32, skycloudCategory, wallpaperSkycloudTags));
                dataSets.add(new Wallpaper("skycloud33", R.drawable.skycloud33, skycloudCategory, wallpaperSkycloudTags));
                dataSet=dataSets;
                break;

            }
            case R.drawable.flowers0: {
                dataSets= new ArrayList<>();
                ArrayList<String> wallpaperFlowersTags = new ArrayList<>(Arrays.asList("nice", "black", "unicorn"));
                Category flowersCategory = new Category("Space", R.drawable.flowers0);

                dataSets.add(new Wallpaper("flowers1", R.drawable.flowers1, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers2", R.drawable.flowers2, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers3", R.drawable.flowers3, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers4", R.drawable.flowers4, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers5", R.drawable.flowers5, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers6", R.drawable.flowers6, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers7", R.drawable.flowers7, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers8", R.drawable.flowers8, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers9", R.drawable.flowers9, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers10", R.drawable.flowers10, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers11", R.drawable.flowers11, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers12", R.drawable.flowers12, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers13", R.drawable.flowers13, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers14", R.drawable.flowers14, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers15", R.drawable.flowers15, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers16", R.drawable.flowers16, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers17", R.drawable.flowers17, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers18", R.drawable.flowers18, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers19", R.drawable.flowers19, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers20", R.drawable.flowers20, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers21", R.drawable.flowers21, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers22", R.drawable.flowers22, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers23", R.drawable.flowers23, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers24", R.drawable.flowers24, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers25", R.drawable.flowers25, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers26", R.drawable.flowers26, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers27", R.drawable.flowers27, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers28", R.drawable.flowers28, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers29", R.drawable.flowers29, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers30", R.drawable.flowers30, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers31", R.drawable.flowers31, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers33", R.drawable.flowers33, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers34", R.drawable.flowers34, flowersCategory, wallpaperFlowersTags));
                dataSets.add(new Wallpaper("flowers35", R.drawable.flowers35, flowersCategory, wallpaperFlowersTags));
                dataSet=dataSets;
                break;

            }
            case R.drawable.aircraft0: {
                dataSets= new ArrayList<>();
                ArrayList<String> wallpaperAircraftTags = new ArrayList<>(Arrays.asList("nice", "black", "unicorn"));
                Category aircraftCategory = new Category("Space", R.drawable.aircraft0);

                dataSets.add(new Wallpaper("aircraft1", R.drawable.aircraft1, aircraftCategory, wallpaperAircraftTags));
                dataSets.add(new Wallpaper("aircraft2", R.drawable.aircraft2, aircraftCategory, wallpaperAircraftTags));
                dataSets.add(new Wallpaper("aircraft3", R.drawable.aircraft3, aircraftCategory, wallpaperAircraftTags));
                dataSets.add(new Wallpaper("aircraft4", R.drawable.aircraft4, aircraftCategory, wallpaperAircraftTags));
                dataSets.add(new Wallpaper("aircraft5", R.drawable.aircraft5, aircraftCategory, wallpaperAircraftTags));
                dataSets.add(new Wallpaper("aircraft6", R.drawable.aircraft6, aircraftCategory, wallpaperAircraftTags));
                dataSets.add(new Wallpaper("aircraft7", R.drawable.aircraft7, aircraftCategory, wallpaperAircraftTags));
                dataSets.add(new Wallpaper("aircraft8", R.drawable.aircraft8, aircraftCategory, wallpaperAircraftTags));
                dataSets.add(new Wallpaper("aircraft9", R.drawable.aircraft9, aircraftCategory, wallpaperAircraftTags));
                dataSets.add(new Wallpaper("aircraft10", R.drawable.aircraft10, aircraftCategory, wallpaperAircraftTags));
                dataSets.add(new Wallpaper("aircraft11", R.drawable.aircraft11, aircraftCategory, wallpaperAircraftTags));
                dataSets.add(new Wallpaper("aircraft12", R.drawable.aircraft12, aircraftCategory, wallpaperAircraftTags));
                dataSets.add(new Wallpaper("aircraft13", R.drawable.aircraft13, aircraftCategory, wallpaperAircraftTags));
                dataSets.add(new Wallpaper("aircraft14", R.drawable.aircraft14, aircraftCategory, wallpaperAircraftTags));
                dataSets.add(new Wallpaper("aircraft15", R.drawable.aircraft15, aircraftCategory, wallpaperAircraftTags));
                dataSets.add(new Wallpaper("aircraft16", R.drawable.aircraft16, aircraftCategory, wallpaperAircraftTags));
                dataSets.add(new Wallpaper("aircraft17", R.drawable.aircraft17, aircraftCategory, wallpaperAircraftTags));
                dataSets.add(new Wallpaper("aircraft18", R.drawable.aircraft18, aircraftCategory, wallpaperAircraftTags));
                dataSets.add(new Wallpaper("aircraft19", R.drawable.aircraft19, aircraftCategory, wallpaperAircraftTags));
                dataSets.add(new Wallpaper("aircraft20", R.drawable.aircraft20, aircraftCategory, wallpaperAircraftTags));
                dataSets.add(new Wallpaper("aircraft21", R.drawable.aircraft21, aircraftCategory, wallpaperAircraftTags));
                dataSets.add(new Wallpaper("aircraft22", R.drawable.aircraft22, aircraftCategory, wallpaperAircraftTags));
                dataSet=dataSets;
                break;

            }
            case R.drawable.bikes0: {
                dataSets= new ArrayList<>();
                ArrayList<String> wallpaperBikesTags = new ArrayList<>(Arrays.asList("nice", "black", "unicorn"));
                Category bikesCategory = new Category("Space", R.drawable.bikes0);

                dataSets.add(new Wallpaper("bikes1", R.drawable.bikes1, bikesCategory, wallpaperBikesTags));
                dataSets.add(new Wallpaper("bikes2", R.drawable.bikes2, bikesCategory, wallpaperBikesTags));
                dataSets.add(new Wallpaper("bikes3", R.drawable.bikes3, bikesCategory, wallpaperBikesTags));
                dataSets.add(new Wallpaper("bikes4", R.drawable.bikes4, bikesCategory, wallpaperBikesTags));
                dataSets.add(new Wallpaper("bikes5", R.drawable.bikes5, bikesCategory, wallpaperBikesTags));
                dataSets.add(new Wallpaper("bikes6", R.drawable.bikes6, bikesCategory, wallpaperBikesTags));
                dataSets.add(new Wallpaper("bikes7", R.drawable.bikes7, bikesCategory, wallpaperBikesTags));
                dataSets.add(new Wallpaper("bikes8", R.drawable.bikes8, bikesCategory, wallpaperBikesTags));
                dataSets.add(new Wallpaper("bikes9", R.drawable.bikes9, bikesCategory, wallpaperBikesTags));
                dataSets.add(new Wallpaper("bikes10", R.drawable.bikes10, bikesCategory, wallpaperBikesTags));
                dataSets.add(new Wallpaper("bikes11", R.drawable.bikes11, bikesCategory, wallpaperBikesTags));
                dataSets.add(new Wallpaper("bikes12", R.drawable.bikes12, bikesCategory, wallpaperBikesTags));
                dataSets.add(new Wallpaper("bikes13", R.drawable.bikes13, bikesCategory, wallpaperBikesTags));
                dataSets.add(new Wallpaper("bikes14", R.drawable.bikes14, bikesCategory, wallpaperBikesTags));
                dataSets.add(new Wallpaper("bikes15", R.drawable.bikes15, bikesCategory, wallpaperBikesTags));
                dataSets.add(new Wallpaper("bikes16", R.drawable.bikes16, bikesCategory, wallpaperBikesTags));
                dataSets.add(new Wallpaper("bikes17", R.drawable.bikes17, bikesCategory, wallpaperBikesTags));
                dataSets.add(new Wallpaper("bikes18", R.drawable.bikes18, bikesCategory, wallpaperBikesTags));
                dataSets.add(new Wallpaper("bikes19", R.drawable.bikes19, bikesCategory, wallpaperBikesTags));

                dataSet=dataSets;
                break;

            }
            case R.drawable.rsz_1space0: {
                dataSets= new ArrayList<>();
                ArrayList<String> wallpaperSpaceTags = new ArrayList<>(Arrays.asList("nice", "black", "unicorn"));
                Category spaceCategory = new Category("Space", R.drawable.space0);

                dataSets.add(new Wallpaper("space1", R.drawable.space1, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space2", R.drawable.space2, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space3", R.drawable.space3, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space4", R.drawable.space4, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space5", R.drawable.space5, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space6", R.drawable.space6, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space7", R.drawable.space7, spaceCategory, wallpaperSpaceTags));
                //dataSets.add(new Wallpaper("space8", R.drawable.space8, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space9", R.drawable.space9, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space10", R.drawable.space10, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space11", R.drawable.space11, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space12", R.drawable.space12, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space13", R.drawable.space13, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space14", R.drawable.space14, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space15", R.drawable.space15, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space16", R.drawable.space16, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space17", R.drawable.space17, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space18", R.drawable.space18, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space19", R.drawable.space19, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space20", R.drawable.space20, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space21", R.drawable.space21, spaceCategory, wallpaperSpaceTags));
                //dataSets.add(new Wallpaper("space22", R.drawable.space22, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space23", R.drawable.space23, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space24", R.drawable.space24, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space25", R.drawable.space25, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space26", R.drawable.space26, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space27", R.drawable.space27, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space28", R.drawable.space28, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space29", R.drawable.space29, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space30", R.drawable.space30, spaceCategory, wallpaperSpaceTags));
                dataSets.add(new Wallpaper("space31", R.drawable.space31, spaceCategory, wallpaperSpaceTags));
                dataSet=dataSets;
                break;

            }
            case R.drawable.lotus: {
                dataSets= new ArrayList<>();
                ArrayList<String> wallpaperProbaTags = new ArrayList<>(Arrays.asList("nice", "adventure", "landscape"));
                Category proba = new Category("Fruits", R.drawable.lotus);

                dataSets.add(new Wallpaper("Proba1", R.drawable.proba1022724x1920, proba, wallpaperProbaTags));
                dataSets.add(new Wallpaper("Proba2", R.drawable.proba2833420x1920, proba, wallpaperProbaTags));
                dataSets.add(new Wallpaper("Proba3", R.drawable.proba3623676x1920, proba, wallpaperProbaTags));
                dataSets.add(new Wallpaper("Proba4", R.drawable.proba3913600x1920, proba, wallpaperProbaTags));
                dataSets.add(new Wallpaper("Proba5", R.drawable.proba7201280, proba, wallpaperProbaTags));
                dataSets.add(new Wallpaper("Proba6", R.drawable.proba10801920, proba, wallpaperProbaTags));
                dataSets.add(new Wallpaper("Proba5", R.drawable.proba72012801, proba, wallpaperProbaTags));
                dataSet=dataSets;
                break;
            }
        }
    }
}