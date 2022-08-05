package org.example.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTaskTest {

    @Test
    public void testTodoItemIsNull(){
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                TodoItemTask todoItemTask = new TodoItemTask();
                todoItemTask.setTodoItem(null);
            }
        });
    }

    @Test
    public void test_isAssigned_isTrue(){

        Person person = new Person("Nisse","Olsson", "nisse@gmail.com");
        TodoItem item = new TodoItem("change tires",
                "change summer tires to winter tires", LocalDate.parse("2022-11-01"), person);
        TodoItemTask task = new TodoItemTask(item, person);

        assertTrue(task.isAssigned());

    }

    @Test
    public void test_isAssigned_isFalse(){

        Person person = new Person("Nisse","Olsson", "nisse@gmail.com");
        TodoItem item = new TodoItem("change tires",
                "change summer tires to winter tires", LocalDate.parse("2022-11-01"), person);
        TodoItemTask task = new TodoItemTask(item, null);

        assertFalse(task.isAssigned());

    }




}