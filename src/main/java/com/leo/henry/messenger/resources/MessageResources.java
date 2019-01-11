package com.leo.henry.messenger.resources;

import com.leo.henry.messenger.bean.MessageFilterBean;
import com.leo.henry.messenger.service.MessageService;
import com.leo.henry.messenger.model.Message;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/messages")
@Consumes(value = {MediaType.APPLICATION_JSON})
@Produces(value = {MediaType.APPLICATION_JSON})
public class MessageResources {
    MessageService messageService = new MessageService();
    @GET
    public List<Message> getMessages(@BeanParam MessageFilterBean messageFilterBean)
    {
        if (messageFilterBean.getYear()>0) return messageService.getAllMessagesForYear(messageFilterBean.getYear());
        if (messageFilterBean.getStart()>=0 && messageFilterBean.getSize() >0)
            return messageService.getMessagesPaginated(messageFilterBean.getStart(),messageFilterBean.getSize());
        return messageService.getMessages();
    }
    @GET
    @Path("/{id}")
    public Message getMessage(@PathParam("id") Long id,@Context UriInfo uriInfo)
    {
        Message message = messageService.getMassage(id);
        message.addLinks( getUriForSelf(uriInfo, message),"self");
        message.addLinks( getUriForProfile(uriInfo, message),"profile");
        message.addLinks( getUriForComment(uriInfo, message),"comment");
        return message;
    }

    private String getUriForSelf(@Context UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder()
                    .path(MessageResources.class)
                    .path(Long.toString(message.getId()))
                    .build()
                    .toString();
    }
    private String getUriForProfile(@Context UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder()
                    .path(ProfileResources.class)
                    .path(message.getAuthor())
                    .build()
                    .toString();
    }
    private String getUriForComment(@Context UriInfo uriInfo, Message message) {
        return uriInfo.getBaseUriBuilder()
                    .path(MessageResources.class)
                    .path(MessageResources.class,"getCommentResource")
                    .path(CommentResource.class)
                    .resolveTemplate("messageId",message.getId())
                    .build()
                    .toString();
    }

    @POST
    public Response postMessage(Message message, @Context UriInfo uriInfo)
    {
        Message newMessage = messageService.postMessage(message);
        String newId = String.valueOf(newMessage.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
        return Response.created(uri)
                .entity(newMessage)
                .build();
    }
    @PUT
    @Path("/{id}")
    public Message updateMessage(@PathParam("id")Long id, Message message)
    {
        return messageService.updateMessage(id,message);
    }

    @DELETE
    @Path("/{id}")
    public Message deleteMessage(@PathParam("id")Long id)
    {
        return messageService.deleteMessage(id);
    }

    @Path("/{messageId}/comments")
    public CommentResource getCommentResource()
    {
        return new CommentResource();
    }
}
