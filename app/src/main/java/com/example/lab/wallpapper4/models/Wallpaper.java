package com.example.lab.wallpapper4.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Wallpaper {
    private String imageName;
    private int imagePath;
    private Category imageCategory;
    private List<String> imageTags;

    public Wallpaper(){}
    
    public Wallpaper(String name, int path, Category category, ArrayList<String> tags){
        this.imageName = name;
        this.imagePath = path;
        this.imageCategory = category;
        this.imageTags = tags;
    }

}
