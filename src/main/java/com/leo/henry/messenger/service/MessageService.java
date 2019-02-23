package com.leo.henry.messenger.service;

import com.leo.henry.messenger.bean.MessageDto;
import com.leo.henry.messenger.exceptions.DataNotFoundException;
import com.leo.henry.messenger.model.Message;
import com.leo.henry.messenger.repository.MessegerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class MessageService {

    @Autowired
   private MessegerRepo messegeRepo;
//   private Map<Message> messages = DataSource.getMessages();
//   public  MessageService()
//   {
//
//   }
    public List<Message> getMessages()
    {

        return messegeRepo.findAll();
    }

    public Message getMassage(Long id)
    {
        Message message = messegeRepo.getOne(id);
        if (message ==null)throw new DataNotFoundException("Message with Id: "+id+" not found",404,null);
        return message;
    }
    public List<Message> getAllMessagesForYear(int year)
    {
        List<Message> messageList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for (Message msg : getMessages())
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
        List<Message> messageList = getMessages();
       if ((start+size) > messageList.size())return null;
        return messageList.subList(start,size);
    }
    public Message postMessage(Message message)
    {
        return messegeRepo.save(message);
    }
    public Message updateMessage(Long id,MessageDto message)
    {

        if (id <=0) return null;
        Message messageToBeUpdated = messegeRepo.getOne(id);
        if (messageToBeUpdated ==null) return null;
        messageToBeUpdated.setAuthor(message.getAuthor());
        messageToBeUpdated.setMessage(message.getMessage());
        messageToBeUpdated = messegeRepo.save(messageToBeUpdated);
        return messageToBeUpdated;
    }
    public void deleteMessage(Long id)
    {
        Message message = messegeRepo.getOne(id);
        messegeRepo.delete(message);
    }
}