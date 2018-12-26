package com.example.lab.wallpapper4.models;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Category {
    private String name;
    private Integer imagePath;

    public Category(String name, Integer imageCat){
        name = name;
        imagePath = imageCat;
    }
}
