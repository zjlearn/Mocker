package com.zjlearn.mock;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * create by zhangjun1 on 2017/9/20
 */
public class Student {
    private int id;
    private String name;
    private String sex;
    private float height;
    private List<String> photos;


    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }



    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }


}
