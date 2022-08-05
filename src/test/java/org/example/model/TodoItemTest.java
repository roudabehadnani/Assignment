package org.example.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTest {
    
    @Test
    public void testTitleIsNull(){
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                TodoItem todoItem = new TodoItem();
                todoItem.setTitle(null);
            }
        });

    }

    @Test
    public void testDeadLineIsNull(){
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                TodoItem todoItem = new TodoItem();
                todoItem.setDeadLine(null);
            }
        });
    }

    @Test
    public void test_isOverdue_isFalse(){
        Person person = new Person("Nisse","Olsson", "nisse@gmail.com");
        TodoItem item = new TodoItem("change tires",
                "change summer tires to winter tires", LocalDate.parse("2022-11-01"), person);

        assertFalse(item.isOverdue());

    }

    @Test
    public void test_isOverdue_isTrue(){
        Person person = new Person("Nisse","Olsson", "nisse@gmail.com");
        TodoItem item = new TodoItem("change tires",
                "change summer tires to winter tires", LocalDate.parse("2021-11-01"), person);

        assertTrue(item.isOverdue());

    }


}