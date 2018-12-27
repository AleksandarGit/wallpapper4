package com.example.lab.wallpapper4.repositories;

import android.arch.lifecycle.MutableLiveData;

import com.example.lab.wallpapper4.R;
import com.example.lab.wallpapper4.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoriesRepository {
    private static CategoriesRepository instance;
    private ArrayList<Category> dataSet = new ArrayList<>();

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
        data.setValue(dataSet);
        return data;
    }

    private void setCategories(){
        dataSet.add(new Category("Nature", R.drawable.flora));
        dataSet.add(new Category("Landscapes", R.drawable.lotus));
        dataSet.add(new Category("Cars", R.drawable.car ));
        dataSet.add(new Category("Fantasy", R.drawable.tree));
        dataSet.add(new Category("Beauties", R.drawable.girl));

    }
}
/*

 */