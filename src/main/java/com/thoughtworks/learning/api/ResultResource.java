package com.thoughtworks.learning.api;

import com.thoughtworks.learning.core.*;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by julie on 1/5/16.
 */
@Path("/receipt")
public class ResultResource {
    @Inject
    private ItemsRepository itemsRepository;
    @GET
    @Produces(MediaType.APPLICATION_JSON+";charset=utf-8")

    public Response getResult(){

        List<ReceiptItems> itemsList = new ArrayList<>();
        List<CartItems> gift = new ArrayList<>();

        List<CartItems> cartItems = itemsRepository.getCartItems();
        List<GiftItems> giftItems = itemsRepository.getGiftItems();


        for (int i = 0; i< cartItems.size(); i++) {
            ReceiptItems receiptItems = new ReceiptItems(cartItems.get(i));
            for (int j = 0; j< giftItems.size(); j++ ){
                if(cartItems.get(i).getBarcode().equals(giftItems.get(j).getBarcode())){
                    receiptItems.getTotal(giftItems.get(j));
                    CartItems itemsFree = new CartItems(giftItems.get(j));
                    gift.add(itemsFree);
                }
            }
            itemsList.add(receiptItems);
        }


        HashMap account = new HashMap();
        Double all = 0.00;
        Double save = 0.00;
        for (int i=0; i<itemsList.size(); i++){
            all = all+itemsList.get(i).getTotal();
        }
        for (int j=0; j<gift.size(); j++){
            save = save+gift.get(j).getPrice()*gift.get(j).getCount();
        }
        account.put("all",all);
        account.put("save",save);

        Receipt receipt = new Receipt(itemsList,gift,account);

        return Response.status(200).entity(receipt).build();
    }
}
