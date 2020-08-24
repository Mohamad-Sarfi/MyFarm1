package com.example.myfarm.DataBase;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoOthers {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertOthers(OthersEntity othersEntity);

    @Delete
    void deleteOthers(OthersEntity othersEntity);

    @Query("SELECT * FROM others WHERE oName = :name ORDER BY id DESC")
    LiveData<List<OthersEntity>> getOthersByName(String name);

    @Query("SELECT COUNT(*) FROM others ")
    int getOthersCount();



}
