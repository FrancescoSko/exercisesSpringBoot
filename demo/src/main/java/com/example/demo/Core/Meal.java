package com.example.demo.Core;

public class Meal {
    private Integer id;
    private String name;
    private String description;
    private Double price;

//    public Meal(Integer id, String name, String description, Integer price) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.price = price;
//    }

    public Meal(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
