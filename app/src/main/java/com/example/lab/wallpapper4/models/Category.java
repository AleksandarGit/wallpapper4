package com.example.lab.wallpapper4.models;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Category {
    private String name;
    private int imagePath;

    public Category(){}

    public Category(String name, int imageCat){
        this.name = name;
        this.imagePath = imageCat;
    }
}
