/**
 * This class is a part of "ToDo list" application.
 * this class will hold information of different tasks and store it
 * in an ArrayList of type object.
 * also have some methods to handle different application demands
 * which is shown below.
 */
package se.kth.sdaproject.toDoList.controller;

import java.util.stream.Collectors;
import java.util.*;
import java.util.Scanner;
import se.kth.sdaproject.toDoList.model.Task;

public class TaskList {

    private ArrayList<Task> tasks;
    private Scanner input;


    /**
     * constructor create TaskList object which consist of
     * creating ArratyList object and scanner object to take the inputs from the user.
     */
    
    public TaskList() {
        tasks = new ArrayList<>();
        input = new Scanner(System.in);

    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /** this method to add new task
    @param taskRequirment will hold the taskID, title, date and project name. 
    */
    public void addTask(Task taskRequirment) {

        tasks.add(taskRequirment);

    }

    /**
     * This method is to return number of tasks.
     * @return 
     */
    public int getNumberOfTasks() {
        return tasks.size();
    }

    public void edit() {
        showByDdate();
        System.out.println(" ");
        System.out.println("Enter 1 to delete\nEnter 2 to mark as done\nEnter 3 to edit task");
        String in = input.next();
        if (in.equals("1")) {
            System.out.println("Please enter your taskID");
            String in1 = input.next();
            //  tasks.stream().filter(value -> value != null).forEach(System.out::println);
            tasks.removeIf((Task t) -> t.getTaskNu().equals(in1));
        } else if (in.equals("2")) {
            markDone();

        } else if (in.equals("3")) {
            upDate();
        } else {
            System.out.println("wrong choice number");
            System.out.println(" ");
        }
    }

    /**
     * showByDate method  to sort the tasks by dates.
     */
    public void showByDdate() {
        if (tasks.isEmpty()) {
            System.out.println(" your task list empty!");
        } else {
            System.out.println(" ");
            System.out.println("your tasks:");
            System.out.println(" ");

            String x = String.format("%8s %30s %12s %30s %5s",
                    "ID", "Title", "Date", "Project", "Done");
            System.out.println(x);
            System.out.println(" ");
            tasks.stream()
                    .sorted(Comparator.comparing(Task::getDate))
                    .forEach(e -> System.out.println(e.toString()));
        }
    }

    /**
     * markDone method is to mark the task as done it will mark the specific
     * task as done according to the given valid taskID from the user.
     *
     */
    public void markDone() {
        System.out.println("Please enter the taskID to mark it as done");
        String read = input.next();
        boolean match = false;
        for (Task t : tasks) {
            String taskNu = t.getTaskNu();
            if (read.equals(taskNu)) {
                match = true;
                break;
            }
        }
        if (match) {
            tasks.stream().filter((Task t) -> t.getTaskNu()
                    .equals(read)).forEach(s -> s.setStatus());
            System.out.println(" ");
            System.out.println("task are marked as done!");
        } else {
            System.out.println("your taskID does not exist");
        }
    }

    /**
     *
     * @return the number of the tasks are done.
     */
    public int nuOfDone() {
        int i = 0;

        for (Task s : tasks) {
            boolean status = s.getStatus();

            if (status) {
                i++;
            }

        }
        return i;
    }

    /**
     * update method is to update a specific task depending on the user demands.
     *
     * @return
     */
    public boolean upDate() {

        System.out.println("Enter the taskID of the task you want to update");
        String in1 = input.next();

        Task match = null;
        for (Task t : tasks) {
            if (in1.equals(t.getTaskNu())) {
                match = t;
            }

        }

        if (match != null) {

            System.out.println("press 1 to update the taskID\npress 2 to update the title\npress 3 to update the date\npress 4 to update the project name");
            String in2 = input.next();
            if (in2.equals("1")) {
                System.out.println("Enter new TaskID");
                String in3 = input.next();
                match.setTaskID(in3);
                System.out.println("taskID are updated");
            } else if (in2.equals("2")) {
                // String newtitle = match.getTitle();
                System.out.println("Enter new title");
                String in3 = input.next();
                match.setTitle(in3);
                System.out.println(" ");
                System.out.println("task title are updated!");

            } else if (in2.equals("3")) {
                System.out.println("Enter new date as the form yy:mm:dd");
                String in4 = input.next();
                match.setDate(in4);
                System.out.println(" ");

            } else if (in2.equals("4")) {
                System.out.println("Enter new project name");
                String in5 = input.next();
                match.setProjectName(in5);
                System.out.println(" ");
                System.out.println("project name are updated");
            } else {
                System.out.println("you have entered wrong value");
            }
            return true;
        }

        System.out.println("Not Found");

        return false;

    }

    /**
     * This method will return the number of the tasks are not marked as done.
     *
     * @return
     */
    public int noOftasksNotdone() {
        int i = 0;
        for (Task t : tasks) {
            if (!t.getStatus()) {
                i++;
            }
        }
        return i;
    }

}
