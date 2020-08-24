package com.example.myfarm.DataBase;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoIrrigation {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(IrrigationEntity irrigationEntity);

    @Delete
    void deleteIrrigation(IrrigationEntity irrigationEntity);

    @Query("SELECT * FROM irrigation WHERE iName = :iName ORDER BY id DESC")
    LiveData<List<IrrigationEntity>> getIrrigationByName(String iName);

    @Query("SELECT * FROM irrigation")
    LiveData<List<IrrigationEntity>> getAllIrrigation();

    @Query("SELECT COUNT(*) FROM irrigation")
    int getCountIrrigation();



}
