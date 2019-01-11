package com.leo.henry.messenger.service;

import com.leo.henry.messenger.exceptions.DataNotFoundException;
import com.leo.henry.messenger.database.DataSource;
import com.leo.henry.messenger.model.Message;

import java.util.*;

//@Service
public class MessageService {

   private Map<Long,Message> messages = DataSource.getMessages();
   public  MessageService()
   {
       Message m1  = new Message(1L,"I love You","Henry");
       Message m2  = new Message(2L,"I will marry You","Jeo");
       Message m3  = new Message(3L,"I will Kiss you","Leo");
       messages.put(1L,m1);
       messages.put(2L,m2);
       messages.put(3L,m3);
   }
    public List<Message> getMessages()
    {

        return new ArrayList<>(messages.values());
    }

    public Message getMassage(Long id)
    {
        Message message = messages.get(id);
        if (message ==null)throw new DataNotFoundException("Message with Id: "+id+" not found");
        return message;
    }
    public List<Message> getAllMessagesForYear(int year)
    {
        List<Message> messageList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for (Message msg : messages.values())
        {
            calendar.setTime(msg.getCreatedAt());
            if (calendar.get(Calendar.YEAR) ==year){
                messageList.add(msg);
            }
        }
        return messageList;
    }
    public List<Message> getMessagesPaginated(int start,int size)
    {
        List<Message> messageList = new ArrayList<>(messages.values());
       if ((start+size) > messageList.size())return null;
        return messageList.subList(start,size);
    }
    public Message postMessage(Message message)
    {
        message.setId(messages.size()+1L);
        messages.put(message.getId(),message);
        return message;
    }
    public Message updateMessage(Long id,Message message)
    {

        if (id <=0) return null;
        Message messageToBeUpdated = messages.get(id);
        if (messageToBeUpdated ==null) return null;
        messageToBeUpdated.setAuthor(message.getAuthor());
        messageToBeUpdated.setMessage(message.getMessage());
        messageToBeUpdated.setUpdatedAt(new Date());
        messages.put(messageToBeUpdated.getId(),messageToBeUpdated);
        return messageToBeUpdated;
    }
    public Message deleteMessage(Long id)
    {
        return messages.remove(id);
    }
}