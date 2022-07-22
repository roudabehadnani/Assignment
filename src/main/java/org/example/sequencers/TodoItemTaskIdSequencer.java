package org.example.sequencers;

public class TodoItemTaskIdSequencer {

    private static int currentId;

    public static int nextId(){
        currentId++;
        return currentId;
    }


    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        TodoItemTaskIdSequencer.currentId = currentId;
    }
}
