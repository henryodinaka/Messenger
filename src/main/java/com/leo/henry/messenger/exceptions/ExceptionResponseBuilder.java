package com.leo.henry.messenger.exceptions;


import com.leo.henry.messenger.model.ErrorMessage;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

public class ExceptionResponseBuilder {

    public static Response buildResponse(String errorMsg,int statusCode,String documentation)
    {
        ErrorMessage errorMessage  = new ErrorMessage(errorMsg,statusCode,documentation);
        return Response.status(statusCode).entity(errorMessage).build();
    }
}
