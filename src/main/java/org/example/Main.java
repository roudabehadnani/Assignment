package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Person person = new Person();
        person.setId(4);
        person.setFirstName("Nisse");
        person.setLastName("Olsson");
        person.setEmail("nisse@gmail.com");

        //System.out.println(person.getSummary());


        TodoItem item = new TodoItem();
        item.setId(65);
        item.setTitle("change tires");
        item.setDescription("change summer tires to winter tires");
        item.setDeadLine(LocalDate.parse("2022-11-01"));
        item.setDone(false);
        item.setCreator(person);

        //System.out.println(item.toString());
        //System.out.println(item.isOverdue());

        TodoItemTask task = new TodoItemTask();
        task.setId(100);
        task.setAssigned(true);
        task.setTodoItem(item);
        task.setAssignee(person);

        System.out.println(task.toString());

    }
}