package com.example.myfarm.DataBase;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "irrigation")
public class IrrigationEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String iName;
    private String date;
    private int duration;
    private String amount;


    public IrrigationEntity(int id, String iName, String date, int duration, String amount) {
        this.id = id;
        this.iName = iName;
        this.date = date;
        this.duration = duration;
        this.amount = amount;
    }

    @Ignore
    public IrrigationEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIName() {
        return iName;
    }

    public void setIName(String iName) {
        this.iName = iName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
