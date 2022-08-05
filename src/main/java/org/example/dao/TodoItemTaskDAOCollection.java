package org.example.dao;

import org.example.model.TodoItemTask;
import org.example.sequencers.TodoItemTaskIdSequencer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO {

    HashMap<Integer, TodoItemTask> state = new HashMap<>();


    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        todoItemTask.setId(TodoItemTaskIdSequencer.nextId());
        state.put(todoItemTask.getId(), todoItemTask);
        return todoItemTask;
    }

    @Override
    public TodoItemTask findById(int id) {
        return state.get(id);
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return state.values();
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        ArrayList<TodoItemTask> findAssigned = new ArrayList<>();

        for (TodoItemTask t: state.values()) {
            if (t.isAssigned() == status){
                findAssigned.add(t);
            }
        }
        return findAssigned;
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        ArrayList<TodoItemTask> findPerson = new ArrayList<>();
        for (TodoItemTask t: state.values()) {
            if (t.getAssignee().getId() == personId){
                findPerson.add(t);
            }

        }
        return findPerson;
    }

    @Override
    public void remove(int id) {
        state.remove(id);

    }
}
