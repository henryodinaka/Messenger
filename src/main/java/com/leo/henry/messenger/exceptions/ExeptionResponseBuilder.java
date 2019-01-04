package com.leo.henry.messenger.exceptions;


import com.leo.henry.messenger.model.ErrorMessage;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

public class ExeptionResponseBuilder {

    public static Response buildResponse(String errorMsg,int statusCode)
    {
        ErrorMessage errorMessage  = new ErrorMessage(errorMsg,statusCode,"");
        return Response.status(statusCode).entity(errorMessage).build();
    }
}
