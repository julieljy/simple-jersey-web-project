package com.thoughtworks.learning.core;

/**
 * Created by julie on 1/6/16.
 */
public class GiftItems {

    private String barcode;
    private String name;
    private String unit;
    private Double price;
    private Long count;

    public GiftItems(String barcode,String name,String unit,Double price,Long count){
        this.barcode=barcode;
        this.name=name;
        this.unit=unit;
        this.price=price;
        this.count=count;
    }

    public String getBarcode(){
        return this.barcode;
    }
    public String getName(){
        return this.name;
    }
    public String getUnit(){
        return this.unit;
    }
    public Double getPrice(){
        return this.price;
    }
    public Long getCount(){
        return this.count;
    }
}
