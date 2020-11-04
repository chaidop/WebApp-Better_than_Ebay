package com.example.model;

public class product {
    private Integer barcode;
    private String name;
    private String colour;
    private String description;

    // Setters
    public void setBarcode(Integer barcode) {
        this.barcode = barcode;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // Getters
    public Integer getBarcode() {
        return barcode;
    }
    public String getName() {
        return name;
    }
    public String getColour() {
        return colour;
    }
    public String getDescription() {
        return description;
    }
}