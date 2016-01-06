package com.thoughtworks.learning.core;

/**
 * Created by julie on 1/5/16.
 */
public class CartItems {

    private String barcode;
    private String name;
    private String unit;
    private Double price;
    private Long count;

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

    public CartItems(String barcode,String name,String unit,Double price,Long count){
        this.barcode=barcode;
        this.name=name;
        this.unit=unit;
        this.price=price;
        this.count=count;
    }

    public CartItems(GiftItems itemsFree){
        this.barcode=itemsFree.getBarcode();
        this.name=itemsFree.getName();
        this.unit=itemsFree.getUnit();
        this.price=itemsFree.getPrice();
        this.count=itemsFree.getCount()/3;
    }


}
