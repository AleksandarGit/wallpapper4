package com.example.lab.wallpapper4.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Wallpaper {
    private String imageName;
    private Integer imagePath;
    private Category imageCategory;
    private List<String> imageTags;
    public Wallpaper(String name, Integer path, Category category, ArrayList<String> tags){
        imageName = name;
        imagePath = path;
        imageCategory = category;
        imageTags = tags;
    }

}
