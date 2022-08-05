package org.example.dao;


import org.example.model.TodoItem;
import org.example.sequencers.TodoItemIdSequencer;

import java.time.LocalDate;
import java.util.*;

public class TodoItemDAOCollection implements TodoItemDAO {

    HashMap<Integer, TodoItem> state = new HashMap<>();



    @Override
    public TodoItem persist(TodoItem todoItem) {
        todoItem.setId(TodoItemIdSequencer.nextId());
        state.put(todoItem.getId(), todoItem);
        return todoItem;
    }

    @Override
    public TodoItem findById(int id) {
        return state.get(id);
    }

    @Override
    public Collection<TodoItem> findAll() {
        return state.values();
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
        ArrayList<TodoItem> findAllDone = new ArrayList<>();
        for (TodoItem t: state.values()) {
            if (t.isDone() == done){
                findAllDone.add(t);
            }
        }
        return findAllDone;
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        ArrayList<TodoItem> findTitle = new ArrayList<>();

        for (TodoItem m : state.values()) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                findTitle.add(m);
            }
        }
        return findTitle;
    }


    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        ArrayList<TodoItem> findPerson = new ArrayList<>();

        for (TodoItem t: state.values()) {
            if (t.getCreator().getId() == personId){
                findPerson.add(t);
            }

        }

        return findPerson;
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate date) {
        ArrayList<TodoItem> findBefore = new ArrayList<>();
        for (TodoItem t: state.values()) {
            if (t.getDeadLine().isBefore(date)){
                findBefore.add(t);
            }
        }
        return findBefore;
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate date) {
        ArrayList<TodoItem> findAfter = new ArrayList<>();
        for (TodoItem t: state.values()) {
            if (t.getDeadLine().isAfter(date)){
                findAfter.add(t);
            }

        }
        return findAfter;
    }

    @Override
    public void remove(int id) {
     state.remove(id);

    }
}
