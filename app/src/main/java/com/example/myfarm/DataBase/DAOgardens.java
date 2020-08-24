package com.example.myfarm.DataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


@Dao
public interface DAOgardens {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void InsertGarden(GardenEntity gardenEntity);


    @Delete
    void DeleteGardens(GardenEntity gardenEntity);

    @Query("SELECT * FROM gardens WHERE id = :id")
    GardenEntity getGardenByID(int id);

    @Query("SELECT * FROM gardens WHERE name = :name")
    GardenEntity getGardenByName(String name);

    @Query("SELECT * FROM gardens ORDER BY id DESC")
    LiveData<List<GardenEntity>> getAll();

    @Query("DELETE FROM gardens")
    void deleteAll();

    @Query("SELECT COUNT(*) FROM gardens")
    int getCountGarden();


}
