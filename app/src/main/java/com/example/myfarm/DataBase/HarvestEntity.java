package com.example.myfarm.DataBase;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "harvest")
public class HarvestEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String hName;
    private float weight;
    private String date;
    private String explanation;
    private String type;

    public HarvestEntity(int id, String hName, float weight, String date, String explanation, String type) {
        this.id = id;
        this.hName = hName;
        this.weight = weight;
        this.date = date;
        this.explanation = explanation;
        this.type = type;
    }

    @Ignore
    public HarvestEntity(String hName, float weight, String date, String explanation, String type) {
        this.hName = hName;
        this.weight = weight;
        this.date = date;
        this.explanation = explanation;
        this.type = type;
    }


    @Ignore
    public HarvestEntity() {
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHName() {
        return hName;
    }

    public void setHName(String hName) {
        this.hName = hName;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
