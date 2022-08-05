package org.example.model;

import java.util.Objects;

public class TodoItemTask {

    private int id;
    private boolean assigned;
    private TodoItem todoItem ;
    private Person assignee;


    public TodoItemTask() {
    }

    public TodoItemTask(TodoItem todoItem, Person assignee) {
        setTodoItem(todoItem);
        setAssignee(assignee);
    }

    public TodoItemTask(int id, TodoItem todoItem, Person assignee) {
        this(todoItem, assignee);
        this.id = id;

    }

    //Getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        if (todoItem == null){
           throw new IllegalArgumentException("Not allowed");
        }
        this.todoItem = todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        if (assignee != null) {
            setAssigned(true);
        } else {
            setAssigned(false);
        }
        this.assignee = assignee;
    }

    @Override
    public String toString() {
        return "TodoItemTask{" +
                "id=" + id +
                ", assigned=" + assigned +
                ", todoItem=" + todoItem +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItemTask task = (TodoItemTask) o;
        return id == task.id && assigned == task.assigned && Objects.equals(todoItem, task.todoItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assigned, todoItem);
    }
}
