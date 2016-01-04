package com.thoughtworks.learning.api;

import com.thoughtworks.learning.core.Inputs;
import com.thoughtworks.learning.core.Items;
import com.thoughtworks.learning.core.ItemsRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by julie on 12/31/15.
 */
@Path("/getinputs")
public class GetinputsResource {
    @Inject
    private ItemsRepository itemsRepository;
    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
    public Response get_inputs(){
        List<String> inputs = itemsRepository.getInputs();
        return Response.status(200).entity(inputs).build();
    }
}
