package com.thoughtworks.learning.core;

/**
 * Created by julie on 12/30/15.
 */
public class Items {

    public String barcode;
    public String name;
    public String unit;
    public double price;

    public Items(String barcode,String name,String unit,Double price){
        this.barcode = barcode;
        this.name = name;
        this.unit = unit;
        this.price = price;
    }
}
