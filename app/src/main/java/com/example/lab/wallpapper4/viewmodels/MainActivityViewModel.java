package com.example.lab.wallpapper4.viewmodels;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.example.lab.wallpapper4.models.Category;
import com.example.lab.wallpapper4.repositories.CategoriesRepository;

import java.util.List;

public class MainActivityViewModel  extends ViewModel {

    private MutableLiveData<List<Category>> mNicePlaces;
    private CategoriesRepository mRepo;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();

    public void init() {
        if (mNicePlaces != null) {
            return;
        }
        mRepo = CategoriesRepository.getInstance();
        mNicePlaces = mRepo.getNicePlaces();
    }

    public void addNewValue(final Category category) {
        mIsUpdating.setValue(true);

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<Category> currentPlaces = mNicePlaces.getValue();
                currentPlaces.add(category);
                mNicePlaces.postValue(currentPlaces);
                mIsUpdating.postValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    public LiveData<List<Category>> getNicePlaces() {
        return mNicePlaces;
    }


    public LiveData<Boolean> getIsUpdating() {
        return mIsUpdating;
    }
}