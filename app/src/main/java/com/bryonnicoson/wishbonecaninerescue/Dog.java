package com.bryonnicoson.wishbonecaninerescue;

import java.io.Serializable;

/**
 * Created by bryon on 7/5/16.
 */
public class Dog implements Serializable {

    private int id, mix, hasShots, altered, housetrained, specialNeeds, noDogs, noCats;
    private String name, breed, sex, age, size, desc;

    Dog(int id, String name, String breed, String sex, String age, String size, String desc,
        int mix, int hasShots, int altered, int housetrained, int specialNeeds, int noDogs, int noCats) {

        this.id = id;
        this.mix = mix;
        this.hasShots = hasShots;
        this.altered = altered;
        this.housetrained = housetrained;
        this.specialNeeds = specialNeeds;
        this.noDogs = noDogs;
        this.noCats = noCats;
        this.name = name;
        this.breed = breed;
        this.sex = sex;
        this.age = age;
        this.size = size;
        this.desc = desc;
    }

    // simple Dog constructor with essentials for cursor, listview, detailview
    Dog(int id, String name, String breed, String sex, String age, String size, String desc) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.sex = sex;
        this.age = age;
        this.size = size;
        this.desc = desc;
    }

    public int getMix() {
        return mix;
    }

    public void setMix(int mix) {
        this.mix = mix;
    }

    public int getHasShots() {
        return hasShots;
    }

    public void setHasShots(int hasShots) {
        this.hasShots = hasShots;
    }

    public int getAltered() {
        return altered;
    }

    public void setAltered(int altered) {
        this.altered = altered;
    }

    public int getHousetrained() {
        return housetrained;
    }

    public void setHousetrained(int housetrained) {
        this.housetrained = housetrained;
    }

    public int getSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(int specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    public int getNoDogs() {
        return noDogs;
    }

    public void setNoDogs(int noDogs) {
        this.noDogs = noDogs;
    }

    public int getNoCats() {
        return noCats;
    }

    public void setNoCats(int noCats) {
        this.noCats = noCats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
