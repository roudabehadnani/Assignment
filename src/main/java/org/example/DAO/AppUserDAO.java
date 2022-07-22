package org.example.DAO;

import org.example.model.AppUser;

import java.util.Collection;

public interface AppUserDAO {


    AppUser persist(AppUser appUser);
    AppUser findByUsername(String username);
    Collection<AppUser> findAll();
    void  remove(String username);

}

