package com.example.myfarm.DataBase;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Gardens")
public class GardenEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;


    private String name;
    private int age;
    private String type1;
    private String type2;
    private String type3;
    private String type4;
    private float lat;
    private float lon;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    @Ignore
    public GardenEntity(){
    }

    @Ignore
    public GardenEntity(int id, String name, int age, String type1,String type2,String type3,String type4, float lat, float lon){

        this.id = id;
        this.name = name;
        this.age = age;
        this.type1 = type1;
        this.type2 = type2;
        this.type3 = type3;
        this.type4 = type4;
        this.lat = lat;
        this.lon = lon;
    }


    public GardenEntity(String name, int age, String type1,String type2,String type3,String type4, float lat, float lon){

        this.name = name;
        this.age = age;
        this.type1 = type1;
        this.type2 = type2;
        this.type3 = type3;
        this.type4 = type4;
        this.lat = lat;
        this.lon = lon;
    }


    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

}
