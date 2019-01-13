package com.example.lab.wallpapper4.repositories;

import android.arch.lifecycle.MutableLiveData;

import com.example.lab.wallpapper4.R;
import com.example.lab.wallpapper4.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoriesRepository {
    private static CategoriesRepository instance;
    private ArrayList<Category> categories = new ArrayList<>();

    public static CategoriesRepository getInstance(){
        if(instance == null){
            instance = new CategoriesRepository();
        }
        return instance;
    }


    // Pretend to get data from a webservice or online source
    public MutableLiveData<List<Category>> getMutableCategoriesList(){
        setCategories();
        MutableLiveData<List<Category>> data = new MutableLiveData<>();
        data.setValue(categories);
        return data;
    }

    private void setCategories(){
        ArrayList<Category> categoriesAdd = new ArrayList<>();

        categoriesAdd.add(new Category("Aircraft", R.drawable.aircraft0));
        categoriesAdd.add(new Category("Animals", R.drawable.animals0));
        categoriesAdd.add(new Category("Bikes", R.drawable.bikes0));
        categoriesAdd.add(new Category("City Lights", R.drawable.citylights0));
        categoriesAdd.add(new Category("Flowers", R.drawable.flowers0));
        categoriesAdd.add(new Category("Fruits", R.drawable.fruits0));
        categoriesAdd.add(new Category("Space", R.drawable.rsz_1space0));
        categoriesAdd.add(new Category("Sky", R.drawable.skycloud0));
        categoriesAdd.add(new Category("Proba", R.drawable.lotus));

        categories = categoriesAdd;

    }
}
