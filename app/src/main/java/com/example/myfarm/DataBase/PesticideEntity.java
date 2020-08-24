package com.example.myfarm.DataBase;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Pesticide")
public class PesticideEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    public String gName;
    private String type1;
    private String type2;
    private String type3;
    private String type4;

    private String date;

    @Ignore
    public PesticideEntity() {
    }


    public PesticideEntity(int id, String gName, String type1, String type2, String type3, String type4, String date) {
        this.id = id;
        this.gName = gName;
        this.type1 = type1;
        this.type2 = type2;
        this.type3 = type3;
        this.type4 = type4;
        this.date = date;
    }


    @Ignore
    public PesticideEntity(String gName, String type1, String type2, String type3, String type4, String date) {
        this.gName = gName;
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

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
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
