package com.mobile.taskmanagement;

public class MyTask {

    String TaskTitle;
    String Description;
    String Deadlines;

    public MyTask() {
    }

    public MyTask(String taskTitle, String description, String deadlines) {
        TaskTitle = taskTitle;
        Description = description;
        Deadlines = deadlines;
    }

    public String getTaskTitle() {
        return TaskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        TaskTitle = taskTitle;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDeadlines() {
        return Deadlines;
    }

    public void setDeadlines(String deadlines) {
        Deadlines = deadlines;
    }
}
