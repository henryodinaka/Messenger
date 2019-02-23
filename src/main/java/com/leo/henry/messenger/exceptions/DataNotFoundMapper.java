package com.leo.henry.messenger.exceptions;

import com.leo.henry.messenger.model.ErrorMessage;
import com.leo.henry.messenger.utils.JsonBuilder;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataNotFoundMapper implements ExceptionMapper<DataNotFoundException> {

    @Override
    public Response toResponse(DataNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), ex.getCode(),ex.getRefDocumention());
        String jsonMessage = JsonBuilder.generateJson(errorMessage);
        System.out.println(jsonMessage);
        return Response.status(Response.Status.NOT_FOUND)
                .entity(jsonMessage)
                .build();
    }
}
