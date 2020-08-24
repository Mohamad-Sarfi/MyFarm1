package com.example.myfarm.DataBase;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoPesticide {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertPesticide(PesticideEntity pesticideEntity);


    @Delete
    void deletePesticide(PesticideEntity pesticideEntity);

    @Query("SELECT * FROM pesticide WHERE gName = :gNamee ORDER BY id DESC")
    LiveData<List<PesticideEntity>>  getPesticideByName(String gNamee);

    @Query("SELECT COUNT(*) FROM pesticide")
    int getCountPesticide();


}
