package com.leo.henry.messenger.resources;

import com.leo.henry.messenger.model.Profile;
import com.leo.henry.messenger.service.ProfileService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResources {
    ProfileService profileService = new ProfileService();
    @GET
    public List<Profile> getProfiles()
    {
        return profileService.getProfiles();
    }

    @GET
    @Path("/{profiles}")
    public Profile getProfile(@PathParam("profiles") String profiles)
    {
        return profileService.getProfile(profiles);
    }
    @POST
    public Profile createProfile( Profile message)
    {
        return profileService.createProfile(message);
    }
    @PUT
    @Path("/{profileName}")
    public Profile updateProfile(@PathParam("profileName")String profileName, Profile profile)
    {
        return profileService.updateProfile(profileName,profile);
    }

    @DELETE
    @Path("/{profileName}")
    public Profile deleteMessage(@PathParam("profileName")String profileName)
    {
        return profileService.deleteProfile(profileName);
    }

}
