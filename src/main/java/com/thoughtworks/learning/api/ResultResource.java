package com.thoughtworks.learning.api;

import com.thoughtworks.learning.core.ItemsInCartByCount;
import com.thoughtworks.learning.core.ItemsRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;

/**
 * Created by julie on 1/5/16.
 */
@Path("/result")
public class ResultResource {
    @Inject
    private ItemsRepository itemsRepository;
    @GET
    @Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
    public Response getResult(){
        List<ItemsInCartByCount> itemsInCartByCount = itemsRepository.getItemsInCartByCount();
        List<ItemsInCartByCount> saleItemsInCartByCount = itemsRepository.getSaleItemsInCartByCount();

        for (int i=0; i<itemsInCartByCount.size(); i++){
            itemsInCartByCount.get(i).total=itemsInCartByCount.get(i).count*itemsInCartByCount.get(i).price;
            for (int j=0; j<saleItemsInCartByCount.size(); j++ ){
                if(saleItemsInCartByCount.get(j).barcode.equals(itemsInCartByCount.get(i).barcode)){
                    int giftCount=(saleItemsInCartByCount.get(j).count-saleItemsInCartByCount.get(j).count%3)/3;
                    itemsInCartByCount.get(i).total=(itemsInCartByCount.get(i).count-giftCount)*itemsInCartByCount.get(i).price;
                    saleItemsInCartByCount.get(j).count=giftCount;
                }
            }
        }

        HashMap acount = new HashMap();
        Double all = 0.00;
        Double save = 0.00;
        for (int i=0; i<itemsInCartByCount.size(); i++){
            all = all+itemsInCartByCount.get(i).total;
        }
        for (int j=0; j<saleItemsInCartByCount.size(); j++){
            save = save+saleItemsInCartByCount.get(j).price*saleItemsInCartByCount.get(j).count;
        }
        acount.put("all",all);
        acount.put("save",save);

        HashMap result = new HashMap();
        result.put("items_list",itemsInCartByCount);
        result.put("gift",saleItemsInCartByCount);
        result.put("account",acount);

        return Response.status(200).entity(result).build();
    }
}
