package org.example.model;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {


    @Test
    void create_Person_test_name(){

        Person person = new Person(
                4,
                "Nisse",
                "Olsson",
                "nisse@gmail.com");

        String expected = "Nisse";
        String actual = person.getFirstName();
        assertEquals(expected, actual);

    }

    @Test
    void create_Person_test_lastName(){

        Person person = new Person(
                4,
                "Nisse",
                "Olsson",
                "nisse@gmail.com");

        String expected = "Olsson";
        String actual = person.getLastName();
        assertEquals(expected, actual);

    }

    @Test
    void create_Person_test_email(){

        Person person = new Person(
                4,
                "Nisse",
                "Olsson",
                "nisse@gmail.com");

        String expected = "nisse@gmail.com";
        String actual = person.getEmail();
        assertEquals(expected, actual);

    }




    @Test
    public void testNameIsNull() {

        assertThrows(IllegalArgumentException.class, new Executable() {

            @Override
            public void execute() throws Throwable {
                Person person = new Person(4, null, "Olsson", "nisse@gmail.com");

            }
        });
    }


    @Test
    public void testLastNameIsNull(){
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Person person = new Person();
                person.setLastName(null);
            }
        });
    }


    @Test
    public void testEmailIsNull(){
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Person person= new Person();
                person.setEmail(null);
            }
        });
    }





}