package com.example.lab.wallpapper4.viewmodels;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.example.lab.wallpapper4.models.Category;
import com.example.lab.wallpapper4.repositories.CategoriesRepository;

import java.util.List;

public class MainActivityViewModel  extends ViewModel {

    private MutableLiveData<List<Category>> mutableCategoriesList;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init() {
        if (mutableCategoriesList != null) {
            return;
        }
        CategoriesRepository mRepo = CategoriesRepository.getInstance();
        mutableCategoriesList = mRepo.getMutableCategoriesList();
    }

    public LiveData<List<Category>> getCategories() {
        return mutableCategoriesList;
    }


    public LiveData<Boolean> getIsUpdating() {
        return mIsUpdating;
    }
}