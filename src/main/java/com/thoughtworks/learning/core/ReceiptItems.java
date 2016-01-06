package com.thoughtworks.learning.core;

/**
 * Created by julie on 1/6/16.
 */
public class ReceiptItems {

    private String barcode;
    private String name;
    private String unit;
    private Double price;
    private Long count;
    private Double total;

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
    public Double getTotal(){
        return this.total;
    }

    public Double getTotal(GiftItems giftItems){
        return this.total=(giftItems.getCount()-giftItems.getCount()/3)*giftItems.getPrice();
    }
    public ReceiptItems(CartItems cartItems){
        this.barcode= cartItems.getBarcode();
        this.name= cartItems.getName();
        this.unit= cartItems.getUnit();
        this.price= cartItems.getPrice();
        this.count= cartItems.getCount();
        this.total=cartItems.getCount()*cartItems.getPrice();
    }
}
