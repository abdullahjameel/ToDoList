/*
This class is part of "ToDo list" application on this class will represent 
the command words, how to deal with it and
recognize weather a user entered a valid command or not.
 */
package se.kth.sdaproject.toDoList.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import se.kth.sdaproject.toDoList.DBhandler.IOFile;
import se.kth.sdaproject.toDoList.model.Task;
import se.kth.sdaproject.toDoList.controller.TaskList;


public class CommandWords {

 
    private Scanner reader;
    private TaskList task; 
    
    private IOFile file;

    
    public CommandWords() {
        reader = new Scanner(System.in);
        task = new TaskList();
        file = new IOFile();
  
    }

  
    /**
     * Print valid commands.
     */
    public void showCommands() {

        
            System.out.print("commands : " + "add   show   edit   saq" + "  ");

      
        System.out.println();
    }
/**
 * Print the ToDo list menu.
 */
    public void printMenu() {
        
        System.out.println("Welcome to ToDo list");
        System.out.println("You have : " + task.noOftasksNotdone() + " tasks to do and: " + task.nuOfDone() + " tasks are done ");
        System.out.println("pick an option:");
        System.out.println("1:Show task list.");
        System.out.println("2:Add new task.");
        System.out.println("3:Edit task.");
        System.out.println("4:Save and quit.");
        System.out.print(">> ");
        showCommands();
      
    }

    /*
    Check whether a given String is a valid command word  .
    take the correct commands from the user and call the requirment method to 
    excute the user demands.
     */
    public void action() throws IOException {
        ArrayList<Task> taskList = new ArrayList<>();
        taskList = file.getTasks();
        if (!taskList.isEmpty()) {
            task.setTasks(taskList);
        }
        printMenu();
        String choice = "";
        while (!choice.equals("saq")) {
            
            choice = reader.next();
            switch (choice) {
                case "add":

                    task.addTask(getTaskFromUser());
                    internalMenu();
                    break;

                case "saq":
                    taskList = task.getTasks();
                    file.saveTasks(taskList);
                    break;
                case "show":
                    task.showByDdate();
                    internalMenu();
                    break;
                case "edit":
                    task.edit();
                    internalMenu();
                    break;

                default:
                    System.out.print("Do not recognize the input. Please try again.\n>> ");
            }

        }
    }
/**
 * get the require information from the user to create a task. 
 * @return new Task.
 */
    private Task getTaskFromUser() {
        System.out.println("Enter : TaskID  Title   yy:mm:dd   projectName");
        boolean status = false;
        String taskNu = "";
        String title = "";
        String date = "";
        String projectName = "";
   
        reader.nextLine();
            

        while (status == false) {
            System.out.println("Enter taskID");
            taskNu = reader.nextLine();
           
            System.out.println("Enter tilte");
            title = reader.nextLine();
            
            System.out.println("Enter date yy:mm:dd"); 
            date = reader.nextLine();

            try {
                if (Character.isDigit(date.charAt(0))
                        && Character.isDigit(date.charAt(1)) && Character.isDigit(date.charAt(3))
                        && Character.isDigit(date.charAt(4)) && Character.isDigit(date.charAt(6))
                        && Character.isDigit(date.charAt(7))) {

                    status = true;
                    System.out.println("Enter project name");
                    projectName = reader.nextLine();
                    System.out.println("you have added new task");

                } else {
                    System.out.println("  ");
                    System.out.println("wrong digit date number, try again");
                    
                }
            } catch (Exception e) {
                System.out.println("please enter a correct date form, enter the taskID ,title,date and project name again");
              

            }
             
        }

        return new Task(taskNu, title, date, projectName);
    }

    private void internalMenu() {
        System.out.println("");
        System.out.println("main menu, what next?");
        showCommands();
    }

}
