package com.example.myfarm.DataBase;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "fertilization")
public class FertilizationEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    public String fName;
    private String type1;
    private String type2;
    private String type3;
    private String type4;

    private String date;


    public FertilizationEntity(int id, String fName, String type1, String type2, String type3, String type4, String date) {
        this.id = id;
        this.fName = fName;
        this.type1 = type1;
        this.type2 = type2;
        this.type3 = type3;
        this.type4 = type4;
        this.date = date;
    }

    @Ignore
    public FertilizationEntity() {
    }

    @Ignore
    public FertilizationEntity(String fName, String type1, String type2, String type3, String type4, String date) {
        this.fName = fName;
        this.type1 = type1;
        this.type2 = type2;
        this.type3 = type3;
        this.type4 = type4;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getType3() {
        return type3;
    }

    public void setType3(String type3) {
        this.type3 = type3;
    }

    public String getType4() {
        return type4;
    }

    public void setType4(String type4) {
        this.type4 = type4;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
