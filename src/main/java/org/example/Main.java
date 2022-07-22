package org.example;

import org.example.DAO.AppUserDAOCollection;
import org.example.DAO.PersonDAOCollection;
import org.example.DAO.TodoItemDAOCollection;
import org.example.DAO.TodoItemTaskDAOCollection;
import org.example.model.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Person person = new Person();
        person.setId(4);
        person.setFirstName("Nisse");
        person.setLastName("Olsson");
        person.setEmail("nisse@gmail.com");

        System.out.println(person);


        TodoItem item = new TodoItem();
        item.setId(65);
        item.setTitle("change tires");
        item.setDescription("change summer tires to winter tires");
        item.setDeadLine(LocalDate.parse("2022-11-01"));
        item.setDone(false);
        item.setCreator(person);

        System.out.println(item);
        System.out.println(item.isOverdue());

        TodoItemTask task = new TodoItemTask();
        task.setId(100);
        task.setAssigned(true);
        task.setTodoItem(item);
        task.setAssignee(person);

        System.out.println(task);

        AppUser user = new AppUser();
        user.setUsername("Nisse-Olsson");
        user.setPassword("1234");
        user.setRole(AppRole.ROLE_APP_USER);

        person.setCredentials(user);
        System.out.println("person = " + person + " person.getCredential= " + person.getCredentials());


        AppUserDAOCollection appUserDAOCollection = new AppUserDAOCollection();
        appUserDAOCollection.persist(user);
        System.out.println("appUserDAOCollection.findByUsername(\"Nisse-Olsson\") = " +
                appUserDAOCollection.findByUsername("Nisse-Olsson"));



        PersonDAOCollection personDAOCollection = new PersonDAOCollection();
        personDAOCollection.persist(person);

        System.out.println(personDAOCollection.findById(4));
        System.out.println(personDAOCollection.findByEmail("nisse@gmail.com"));



        TodoItemDAOCollection todoItemDAOCollection = new TodoItemDAOCollection();
        todoItemDAOCollection.persist(item);

        System.out.println(todoItemDAOCollection.findById(65));
        System.out.println(todoItemDAOCollection.findAllByDoneStatus(false));
        System.out.println(todoItemDAOCollection.findByPersonId(4));
        System.out.println(todoItemDAOCollection.findByTitleContains("change tires"));
        System.out.println(todoItemDAOCollection.findByDeadlineAfter(LocalDate.parse("2022-10-01")));


        TodoItemTaskDAOCollection todoItemTaskDAOCollection = new TodoItemTaskDAOCollection();
        todoItemTaskDAOCollection.persist(task);

        System.out.println(todoItemTaskDAOCollection.findAll());
        System.out.println(todoItemTaskDAOCollection.findByAssignedStatus(true));





    }

}