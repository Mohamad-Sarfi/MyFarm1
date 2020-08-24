package com.example.myfarm.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myfarm.DataBase.GardenEntity;
import com.example.myfarm.DataBase.RepositoryGardens;

import java.util.List;

public class GardenViewModel extends AndroidViewModel {

    RepositoryGardens repositoryGardens;
    private LiveData<List<GardenEntity>> mGardens;
    public GardenViewModel(@NonNull Application application) {
        super(application);
        repositoryGardens = new RepositoryGardens(application);
        mGardens = repositoryGardens.getAllGardens();
    }



    public GardenEntity getByName(String name){return repositoryGardens.getByName(name);}
    public LiveData<List<GardenEntity>> getAllGardens(){return mGardens;}
    public void insert(GardenEntity gardenEntity){ repositoryGardens.insertGarden(gardenEntity); }

}
