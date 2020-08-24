package com.example.myfarm.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {GardenEntity.class,PesticideEntity.class,FertilizationEntity.class
,HarvestEntity.class,IrrigationEntity.class,OthersEntity.class}, version = 2, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    public static final String DATABASE_NAME = "myFarmDB.db";
    private static volatile AppDataBase instance;
    //as it is the only database it shouldn't be more than one, only one instance
    public static final Object LOCK = new Object();

    public abstract DAOgardens daOgardens();
    public abstract DaoPesticide daoPesticide();
    public abstract DaoFertilize daoFertilize();
    public abstract DaoOthers daoOthers();
    public abstract DaoHarvest daoHarvest();
    public abstract DaoIrrigation daoIrrigation();




    public static AppDataBase getInstance(Context context) {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class, DATABASE_NAME).fallbackToDestructiveMigration().build();
                }
            }
        }


        return instance;
    }
}
