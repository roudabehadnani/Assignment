package org.example;

public class Person {

    //Fields
    private int id;
    private String firstName;
    private String lastName;
    private String email;


    //Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
       if (firstName == null || firstName.trim().equals("")) {
            throw new IllegalArgumentException("not allowed");
       }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().equals("")) {
            throw new IllegalArgumentException("not allowed");
        }
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().equals("")) {
            throw new IllegalArgumentException("not allowed");
        }
        this.email = email;
    }


    //Method for description of the object

    public String getSummary(){

        return "{id:" + id + ", " +
                "name:" +firstName + " " + lastName + ", " +
                "email:" + email + "}";
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
