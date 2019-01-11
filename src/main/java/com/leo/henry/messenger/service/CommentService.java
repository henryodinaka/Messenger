package com.leo.henry.messenger.service;

import com.leo.henry.messenger.database.DataSource;
import com.leo.henry.messenger.exceptions.DataNotFoundException;
import com.leo.henry.messenger.exceptions.ExceptionResponseBuilder;
import com.leo.henry.messenger.model.Comment;
import com.leo.henry.messenger.model.Message;

import javax.ws.rs.WebApplicationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CommentService {
    private Map<Long,Message> messages = DataSource.getMessages();
//    private Map<Long,Comment> commentMap = DataSource.
    public List<Comment> getComments(Long messageId)
    {
        Message message = messages.get(messageId);
        if (message == null)
            throw new WebApplicationException(ExceptionResponseBuilder.buildResponse("Message with Id: "+messageId +" not found",404,null));

        Map<Long,Comment> comments = message.getComments();
        if (comments.size() <=0)
            throw new DataNotFoundException("Message with Id: "+messageId+" has no comments");

        return new ArrayList<>(comments.values());
    }

    public Comment getComment(Long messageId, Long commentId)
    {
        Message message = messages.get(messageId);
        if (message == null)
           throw new DataNotFoundException("Message with Id: "+messageId +" not found");


        Map<Long,Comment> comments = message.getComments();
        if (comments.size() <= 0)
            throw new DataNotFoundException("Message with Id: "+messageId+" has no comments");

        return comments.get(commentId);
    }

//    public List<Message> getAllMessagesForYear(int year)
//    {
//        List<Message> messageList = new ArrayList<>();
//        Calendar calendar = Calendar.getInstance();
//        for (Message msg : messages.values())
//        {
//            calendar.setTime(msg.getCreatedAt());
//            if (calendar.get(Calendar.YEAR) ==year){
//                messageList.add(msg);
//            }
//        }
//        return messageList;
//    }

//    public List<Message> getMessagesPaginated(int start,int size)
//    {
//        List<Message> messageList = new ArrayList<>(messages.values());
//        if ((start+size) > messageList.size())return null;
//        return messageList.subList(start,size);
//    }

    public Comment postComment(Long messageId, Comment comment)
    {
        Map<Long,Comment> comments = messages.get(messageId).getComments();
        comment.setId(comments.size()+1L);
        comment.setCreatedAt(new Date());
        comments.put(comment.getId(),comment);
        return comment;
    }
    public Comment updatComment(Long messageId,Long commentId,Comment comment)
    {
        if (messageId <=0 || commentId <=0) return null;
        Map<Long,Comment> comments = messages.get(messageId).getComments();
        Comment commentToBeUpdated = comments.get(commentId);
        if (commentToBeUpdated ==null) return null;
        commentToBeUpdated.setComment(comment.getComment());
        commentToBeUpdated.setUpdatedAt(new Date());
        comments.put(commentToBeUpdated.getId(),commentToBeUpdated);
        return comment;
    }
    public Comment deleteComment(Long messageId,Long commentId)
    {
        Map<Long,Comment> comments = messages.get(messageId).getComments();
        return comments.remove(commentId);
    }
}
