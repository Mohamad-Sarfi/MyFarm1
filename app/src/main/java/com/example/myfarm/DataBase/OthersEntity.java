package com.example.myfarm.DataBase;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

@Entity(tableName = "others")
public class OthersEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String oName;
    private String activity;
    private String date;


    public OthersEntity(int id, String oName, String activity, String date) {
        this.id = id;
        this.oName = oName;
        this.activity = activity;
        this.date = date;
    }

    @Ignore
    public OthersEntity() {
    }

    @Ignore
    public OthersEntity(String oName, String activity, String date) {
        this.oName = oName;
        this.activity = activity;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOName() {
        return oName;
    }

    public void setOName(String oName) {
        this.oName = oName;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
