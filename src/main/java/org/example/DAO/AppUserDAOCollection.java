package org.example.DAO;


import org.example.model.AppUser;

import java.util.*;

public class AppUserDAOCollection implements AppUserDAO {

    HashMap<String, AppUser> state = new HashMap<>();


    @Override
    public AppUser persist(AppUser appUser) {
        state.put(appUser.getUsername(), appUser);
        return appUser;
    }

    @Override
    public AppUser findByUsername(String username) {
        return state.get(username);
    }

    @Override
    public Collection<AppUser> findAll() {
        return state.values();
    }

    @Override
    public void remove(String username) {
        state.remove(username);
        System.out.println("After remove username" + state);

    }
}
