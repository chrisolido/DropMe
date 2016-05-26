package com.prasilabs.dropme.backend.utils;

import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.appengine.api.users.User;
import com.prasilabs.UserRole;
import com.prasilabs.dropme.backend.datastore.DropMeUser;
import com.prasilabs.dropme.backend.db.OfyService;

/**
 * Created by prasi on 19/4/16.
 * admin util to check wether user object exist. admin or not
 */
public class AdminUtil
{
    public static boolean checkAdmin(User user)
    {
        try
        {
            return checkAndThrow(user);
        }
        catch (OAuthRequestException e)
        {
            return false;
        }
    }

    public static boolean checkAndThrow(User user) throws OAuthRequestException
    {
        return checkAndThrow(user, false);
    }

    public static boolean checkAndThrow(User user, boolean isAdminCheck) throws OAuthRequestException
    {
        boolean isAdmin = false;
        if(user != null && user.getEmail() != null)
        {
            DropMeUser dropMeUser = OfyService.ofy().load().type(DropMeUser.class).filter(DropMeUser.EMAIL_STR, user.getEmail()).first().now();
            if(dropMeUser != null && dropMeUser.getRoles().contains(UserRole.Admin.name()))
            {
                isAdmin = true;
            }
        }
        else
        {
            throw new OAuthRequestException("oauth user is not found.");
        }

        if(isAdminCheck && !isAdmin)
        {
            throw  new OAuthRequestException("user is not admin");
        }

        return isAdmin;
    }
}