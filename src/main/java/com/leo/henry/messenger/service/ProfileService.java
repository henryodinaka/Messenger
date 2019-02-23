package com.leo.henry.messenger.service;

import com.leo.henry.messenger.database.DataSource;
import com.leo.henry.messenger.model.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ProfileService {
    private Map<String,Profile> profiles = DataSource.getProfiles();
    public ProfileService()
    {
        Profile p1 = new Profile(1L,"HENRY","Joicy","henjoce", new Date());
        Profile p2 = new Profile(2L,"Leo","Nario","leona", new Date());
        Profile p3 = new Profile(3L,"Joy","Joseph","joyjoe", new Date());
        Profile p4 = new Profile(4L,"Ken","Johnson","kenjohn", new Date());
        profiles.put(p1.getProfileName(),p1);
        profiles.put(p2.getProfileName(),p2);
        profiles.put(p3.getProfileName(),p3);
        profiles.put(p4.getProfileName(),p4);
    }
    public List<Profile> getProfiles()
    {

        return new ArrayList<>(profiles.values());
    }

    public Profile getProfile(String profileName)
    {
        return profiles.get(profileName);
    }
    public Profile createProfile(Profile profile)
    {
        profile.setId(profiles.size()+1L);
        profile.setCreatedAt(new Date());
        profiles.put(profile.getProfileName(),profile);
        return profile;
    }
    public Profile updateProfile(String profileNmae,Profile profile)
    {

        if (profileNmae.isEmpty()) return null;
        Profile profileToBeUpdated = profiles.get(profileNmae);
        if (profileToBeUpdated ==null) return null;
        profileToBeUpdated.setUpdatedAt(new Date());
        profileToBeUpdated.setFirstName(profile.getFirstName());
        profileToBeUpdated.setLastName(profile.getLastName());
        profiles.put(profileToBeUpdated.getProfileName(),profileToBeUpdated);
        return profile;
    }
    public Profile deleteProfile(String profileName)
    {
        return profiles.remove(profileName);
    }
}
