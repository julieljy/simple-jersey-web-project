package com.thoughtworks.learning.core;

import java.util.HashMap;
import java.util.List;

/**
 * Created by julie on 1/6/16.
 */
public class Receipt {

    private List<ReceiptItems> items_list;
    private List<CartItems> gift;
    private HashMap account;

    public Receipt(List<ReceiptItems> itemsList, List<CartItems> gift, HashMap account) {
        this.items_list=itemsList;
        this.gift=gift;
        this.account=account;
    }

    public HashMap getAccount() {
        return account;
    }

    public List<CartItems> getGift() {
        return gift;
    }

    public List<ReceiptItems> getItems_list() {
        return items_list;
    }


//    public Receipt(List<ReceiptItems> items_list,List<CartItems> gift,HashMap account){
//        this.items_list=items_list;
//        this.gift=gift;
//        this.account=account;
//    }
}
