package com.example.myfarm.DataBase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RepositoryGardens {

    DAOgardens daOgardens;
    LiveData<List<GardenEntity>> mGardens;

    public RepositoryGardens(Application application){
        AppDataBase db = AppDataBase.getInstance(application);
        daOgardens = db.daOgardens();
        mGardens = daOgardens.getAll();
    }

    public GardenEntity getByName(String name){ return daOgardens.getGardenByName(name);}
    public LiveData<List<GardenEntity>> getAllGardens(){return mGardens;}
    public void insertGarden(GardenEntity garden){
        new insertAsyncTask(daOgardens).execute(garden);
    }




    private static class insertAsyncTask extends AsyncTask<GardenEntity, Void, Void> {

        private DAOgardens mAsyncTaskDao;

        insertAsyncTask(DAOgardens dao) {
            mAsyncTaskDao = dao;
        }


        @Override
        protected Void doInBackground(GardenEntity... params) {
            mAsyncTaskDao.InsertGarden(params[0]);
            return null;
        }
    }

}
