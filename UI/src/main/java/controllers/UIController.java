package controllers;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
@Stateless
public class UIController {

    @Path("/echo")
    @GET
    public Response doEcho(){
        return Response.ok("Hello World").build();
    }
}
