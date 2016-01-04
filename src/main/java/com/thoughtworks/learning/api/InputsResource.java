package com.thoughtworks.learning.api;

import com.thoughtworks.learning.core.Inputs;
import com.thoughtworks.learning.core.ItemsRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by julie on 12/31/15.
 */
@Path("/inputs")
public class InputsResource {

    @Inject
    private ItemsRepository itemsRepository;
    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON+";charset=utf-8")

    public Response inputs(@FormParam("barcode") String barcode){
        itemsRepository.putItems(barcode);
        return Response.status(200).entity("OK").build();
    }
    
}
