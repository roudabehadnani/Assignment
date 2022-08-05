package org.example;

import org.example.dao.AppUserDAOCollection;
import org.example.dao.PersonDAOCollection;
import org.example.dao.TodoItemDAOCollection;
import org.example.dao.TodoItemTaskDAOCollection;
import org.example.model.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("Nisse","Olsson", "nisse@gmail.com");
        Person person1 = new Person("Rod","ad", "rod@mail.com");
//        System.out.println(person);



        TodoItem item = new TodoItem("change tires",
                "change summer tires to winter tires", LocalDate.parse("2022-11-01"), person);
        System.out.println(item);
        System.out.println(item.isOverdue());




        TodoItemTask task = new TodoItemTask(item, person);
        System.out.println(task);



        AppUser user = new AppUser("Nisse-Olsson", "1234", AppRole.ROLE_APP_USER);

        person.setCredentials(user);
        System.out.println("person = " + person + " person.getCredential= " + person.getCredentials());


        AppUserDAOCollection appUserDAOCollection = new AppUserDAOCollection();
        appUserDAOCollection.persist(user);
        System.out.println(appUserDAOCollection.findByUsername("Nisse-Olsson"));



        PersonDAOCollection personDAOCollection = new PersonDAOCollection();
        personDAOCollection.persist(person);
        personDAOCollection.persist(person1);
        System.out.println(personDAOCollection.findAll());
        System.out.println(personDAOCollection.findById(4));
        System.out.println(personDAOCollection.findByEmail("nisse@gmail.com"));



        TodoItemDAOCollection todoItemDAOCollection = new TodoItemDAOCollection();
        todoItemDAOCollection.persist(item);
        System.out.println(todoItemDAOCollection.findAll());

//        System.out.println(todoItemDAOCollection.findById(65));
//        System.out.println(todoItemDAOCollection.findAllByDoneStatus(false));
//        System.out.println(todoItemDAOCollection.findByPersonId(4));
//        System.out.println(todoItemDAOCollection.findByTitleContains("change tires"));
//        System.out.println(todoItemDAOCollection.findByDeadlineAfter(LocalDate.parse("2022-10-01")));


        TodoItemTaskDAOCollection todoItemTaskDAOCollection = new TodoItemTaskDAOCollection();
        todoItemTaskDAOCollection.persist(task);
        System.out.println(todoItemTaskDAOCollection.findAll());
        System.out.println(todoItemTaskDAOCollection.findByAssignedStatus(true));



    }




}