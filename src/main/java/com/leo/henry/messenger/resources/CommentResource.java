package com.leo.henry.messenger.resources;

import com.leo.henry.messenger.model.Comment;
import com.leo.henry.messenger.service.CommentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@Consumes(value = {MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
@Produces(value = {MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
public class CommentResource {
    CommentService commentService = new CommentService();
    @GET
    public List<Comment> getComments(@PathParam("messageId") Long messageId)
    {
        return commentService.getComments(messageId);
    }
    @GET
    @Path("/{commentId}")
    public Comment getComment(@PathParam("messageId") Long messageId,@PathParam("commentId") Long commentId)
    {
        return commentService.getComment(messageId,commentId);
    }
    @POST
    public Comment postMessage(@PathParam("messageId") Long messageId, Comment comment)
    {
        return commentService.postComment(messageId,comment);
    }

    @PUT
    @Path("/{commentId}")
    public Comment updateMessage(@PathParam("messageId")Long messageId, @PathParam("commentId")Long commentId, Comment comment)
    {
        return commentService.updatComment(messageId,commentId,comment);
    }

    @DELETE
    @Path("/{commentId}")
    public Comment deleteMessage(@PathParam("messageId")Long messageId,@PathParam("commentId")Long commentId)
    {
        return commentService.deleteComment(messageId,commentId);
    }

}
