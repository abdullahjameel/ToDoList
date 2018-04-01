/**Class Task is represent the user task for ToDo list project.

* the class will create the a task contain of the taskID, the title, date
* and project name.
*  the variable done refer to the task status if its done or not and
* by default the variable done are false.  

 
 */
package se.kth.sdaproject.toDoList.model;


import java.io.IOException;
import java.util.Scanner;

public class Task {

    private String taskNu;
    private String title;
    private String date;
    private String projectName;
    private boolean done;

    /**
     * @param taskNu to store the taskID.
     * @param title to store the task title.
     * @param date to store the task due date.
     * @param project to store the project name.
     * <code> if</code> will accept the date values only 
     * if the user entered a digits number other wise
     * <code> else</code> will show that its wrong value. 
     */
    public Task(String taskNu, String title, String date, String project) {

        this.date = date;

        this.taskNu = taskNu;
        this.title = title;

        projectName = project;
        done = false;
    }

    public String getTitle() {
        return title;

    }

    public String getTaskNu() {
        return taskNu;
    }

    public String getDate() {
        return date;
    }

    public String getProjectName() {
        return projectName;
    }
/**
 * Mark the task as done.
 */
    public void setStatus() {

        this.done = true;
    }

    public String toString() {
        String done = "";
        if (this.done) {
            done = "Yes";
        } else {
            done = "No";
        }

        String output = String.format("%8s %30s %12s %30s %5s",
                this.taskNu, this.title, this.date, this.projectName, done);

        return output;
    }
/**
 * set new title if the user edit the title.
 * @param newTitle 
 */
    public void setTitle(String newTitle) {
        title = newTitle;
    }
/**
 * set the new taskID if the user edit the taskID.
 * @param newTaskID 
 */
    public void setTaskID(String newTaskID) {
        taskNu = newTaskID;
    }
/**
 * 
 * @return the task status . 
 */
    public boolean getStatus() {

        return done;
    }
/**
 * set the new date if the user edit the date, accept only interger value.
 * @param newDate 
 */
    public void setDate(String newDate) {
        try {
            if (Character.isDigit(newDate.charAt(0))
                    && Character.isDigit(newDate.charAt(1)) && Character.isDigit(newDate.charAt(3))
                    && Character.isDigit(newDate.charAt(4)) && Character.isDigit(newDate.charAt(6))
                    && Character.isDigit(newDate.charAt(7))) {

                date = newDate;
                System.out.println("task date are updated");
            } else {
                System.out.println("  ");
                System.out.println("wrong digit date number, try again");
            }
        } catch (Exception e) {
            System.out.println("wrong value");
        }

    }
/**
 * set new project name if the user edit project name.
 * @param newProject 
 */
    public void setProjectName(String newProject) {
        projectName = newProject;
    }

}
