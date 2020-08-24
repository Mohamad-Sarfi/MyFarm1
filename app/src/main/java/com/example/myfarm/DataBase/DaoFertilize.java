package com.example.myfarm.DataBase;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoFertilize {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertFertilize(FertilizationEntity fertilizationEntity);

    @Delete
    void deleteFertilize(FertilizationEntity fertilizationEntity);

    @Query("SELECT * FROM fertilization WHERE fName = :fname ORDER BY id DESC")
    LiveData<List<FertilizationEntity>> getFertilization(String fname);


    @Query("SELECT COUNT(*) FROM fertilization")
    int getCountFertilize();

}
