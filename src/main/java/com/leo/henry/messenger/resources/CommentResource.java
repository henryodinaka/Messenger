package com.leo.henry.messenger.resources;

import com.leo.henry.messenger.bean.CommentRequest;
import com.leo.henry.messenger.model.Comment;
import com.leo.henry.messenger.service.CommentService;
import org.springframework.web.bind.annotation.RequestBody;

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
        return commentService.getComment(commentId);
    }
    @POST
    public Comment postMessage(@RequestBody CommentRequest comment)
    {
        return commentService.postComment(comment);
    }

    @PUT
    @Path("/{commentId}")
    public Comment updateMessage(@RequestBody CommentRequest request)
    {
        return commentService.updatComment(request);
    }

    @DELETE
    @Path("/{commentId}")
    public void deleteMessage(@PathParam("commentId")Long commentId)
    {
         commentService.deleteComment(commentId);
    }

}
