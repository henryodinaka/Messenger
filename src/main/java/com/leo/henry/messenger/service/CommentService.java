package com.leo.henry.messenger.service;

import com.leo.henry.messenger.bean.CommentRequest;
import com.leo.henry.messenger.model.Comment;
import com.leo.henry.messenger.model.Message;
import com.leo.henry.messenger.model.User;
import com.leo.henry.messenger.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {
    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;

//    private Map<Long,Message> messages = DataSource.getMessages();
//    private Map<Long,Comment> commentMap = DataSource.

    public List<Comment> getComments(Long messageId)
    {
//        Message message = messages.get(messageId);
//        if (message == null)
//            throw new WebApplicationException(ExceptionResponseBuilder.buildResponse("The requested Message with Id: "+messageId +" not found",404,null));
//
//        Set<Comment> comments = message.getComments();
//        if (comments.size() <=0)
//            throw new DataNotFoundException("Message with Id: "+messageId+" has no comments",404,null);

        return commentRepo.findAllByMessage_Id(messageId);
    }

    public Comment getComment(Long commentId)
    {
//        Message message = messages.get(messageId);
//        if (message == null)
//           throw new DataNotFoundException("Message with Id: "+messageId +" not found",404,null);
//
//
//        Set<Comment> comments = message.getComments();
//        if (comments.size() <= 0)
//            throw new DataNotFoundException("Message with Id: "+messageId+" has no comments",404,null);

        return commentRepo.getOne(commentId);
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

    public Comment postComment(CommentRequest commentRequest)
    {
//       Set<Comment> comments = messages.get(messageId).getComments();
//        comments.put(commentRequest.getId(),commentRequest);
        Message message = messageService.getMassage(commentRequest.getMessageId());
        User user = userService.getOne(commentRequest.getUserId());

        Comment comment = new Comment();
        comment.setComment(commentRequest.getComment());
        comment.setMessage(message);
        comment.setAuthor(user);
        return commentRepo.save(comment);
    }
    public Comment updatComment(CommentRequest request)
    {
//        if (messageId <=0 || commentId <=0) return null;
//       Message message = messages.get(messageId);
        Comment commentToBeUpdated = commentRepo.getOne(request.getId());
        if (commentToBeUpdated ==null) return null;
        commentToBeUpdated.setComment(request.getComment());
//        commentToBeUpdated.setUpdatedAt(new Date());
//        comments.put(commentToBeUpdated.getId(),commentToBeUpdated);
        return commentRepo.save(commentToBeUpdated);
    }
    public void deleteComment(Long commentId)
    {
//        Map<Long,Comment> comments = messages.get(messageId).getComments();
        Comment comment = commentRepo.getOne(commentId);
        commentRepo.delete(comment);
    }
}
