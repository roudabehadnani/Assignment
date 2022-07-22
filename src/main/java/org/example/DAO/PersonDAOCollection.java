package org.example.DAO;

import org.example.model.Person;

import java.util.*;

public class PersonDAOCollection implements PersonDAO {

    HashMap<Integer, Person> state = new HashMap<>();


    @Override
    public Person persist(Person person) {
        state.put(person.getId(), person);
        return person;
    }

    @Override
    public Person findById(int id) {
        return state.get(id);
    }

    @Override
    public Person findByEmail(String email) {

        for (Person m : state.values()) {
            if (m.getEmail().equals(email)) {
                return m;
            }
        }
        return null;
    }

    @Override
    public Collection<Person> findAll() {
        return state.values();
    }

    @Override
    public void remove(int id) {
        state.remove(id);

    }
}

