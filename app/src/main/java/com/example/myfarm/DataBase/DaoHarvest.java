package com.example.myfarm.DataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoHarvest {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertHarvest(HarvestEntity harvestEntity);

    @Delete
    void deleteHarvest(HarvestEntity harvestEntity);

    @Query("SELECT * FROM harvest WHERE hName = :hName ORDER BY id DESC")
    LiveData<List<HarvestEntity>> getHarvestByName(String hName);

    @Query("SELECT * FROM harvest")
    LiveData<List<HarvestEntity>> getAllHarvest();

    @Query("SELECT COUNT(*) FROM harvest")
    int getcountHarvest();


}
