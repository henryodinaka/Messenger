package com.leo.henry.messenger.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injection")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InjectionDemo {

    @GET
    @Path("/annotation")
    public String test(@MatrixParam("param") String param,
                        @HeaderParam("headerParam")String headerParam,
                       @CookieParam("JSESSIONID") String cookie)
    {
        return "Matrix param: "+param+" Header param: "+headerParam+" Cookie Param "+cookie;
    }
    @GET
    @Path("/context")
    public String getContextInfo(@Context UriInfo uriInfo, @Context HttpHeaders headers)
    {
        String path = uriInfo.getAbsolutePath().toString();
        String host = uriInfo.getAbsolutePath().getHost();
        String cookies = headers.getCookies().toString();
        return path+" the host is :"+host+" Cookies: "+cookies;
    }

}
