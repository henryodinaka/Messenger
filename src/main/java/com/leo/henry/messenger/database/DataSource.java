package com.leo.henry.messenger.database;

import com.leo.henry.messenger.model.Message;
import com.leo.henry.messenger.model.Profile;
import com.leo.henry.messenger.model.User;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class DataSource {

    private ArrayList<User> users;
    private static Map<Long,Message> messages = new HashMap<>();
    private static Map<String,Profile> profiles = new HashMap<>();
    public ArrayList<User> getUsers() {
        return users;
    }
  
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public static Map<Long,Message> getMessages()
    {
        return messages;
    }
    public static Map<String,Profile> getProfiles()
    {
        return profiles;
    }
}