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
        categoriesAdd.add(new Category("The Art of Abstract", R.drawable.abstract0));
        categoriesAdd.add(new Category("Fruits", R.drawable.fruits0));
        categoriesAdd.add(new Category("Cars", R.drawable.cars0));
        categoriesAdd.add(new Category("Nature", R.drawable.nature));
        categoriesAdd.add(new Category("Abstract", R.drawable.abstract0));
        categoriesAdd.add(new Category("Fruits", R.drawable.fruits0));
        categoriesAdd.add(new Category("Cars", R.drawable.cars0));
        categoriesAdd.add(new Category("Nature", R.drawable.nature));
        categoriesAdd.add(new Category("Abstract", R.drawable.abstract0));
        categoriesAdd.add(new Category("Fruits", R.drawable.fruits0));
        categoriesAdd.add(new Category("Cars", R.drawable.cars0));
        categories = categoriesAdd;

    }
}
