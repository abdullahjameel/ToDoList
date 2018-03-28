/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sdaproject.toDoList;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author tmp-sda-1172
 */
public class TaskListTest {

    final private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private PrintStream originalSysOut;

    public TaskListTest() {
    }

    @Before
    public void setUpStream() {
        originalSysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @After
    public void cleanUpStream() {
        //outContent = null;
        System.setOut(originalSysOut);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getTasks method, of class TaskList.
     */
    @Test
    public void testGetTasks() {

        TaskList instance = new TaskList();
        Task task1 = new Task("12", "title", "17:09:13", "projectName");
        ArrayList<Task> result = new ArrayList<>();
        result.add(task1);
        instance.addTask(task1);
        ArrayList<Task> expResult = instance.getTasks();
        assertEquals(expResult, result);

    }

    /**
     * Test the first option of edit method, of class TaskList. its delete the
     * task according to taskID
     */
    @Test
    public void testEditDelete() {

        String input = "1 12";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        TaskList instance = new TaskList();
        Task task1 = new Task("12", "title", "17:09:13", "projectName");
        instance.addTask(task1);
        instance.edit();
        assertEquals(0, instance.getTasks().size());

    }

    /**
     * Test the second option of edit method, of class TaskList. its mark the
     * task as done according to taskID
     */
    @Test
    public void testEditMarkDone() {

        String input = "2 12";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        TaskList instance = new TaskList();

        Task task1 = new Task("12", "title", "17:09:13", "projectName");
        instance.addTask(task1);
        instance.edit();
        assertEquals(true, task1.getStatus());
    }

    /**
     * Test the third option of edit method, of class TaskList. itupdate the
     * task according to taskID
     */
    @Test
    public void testEditUpdateTask() {

        String input = "3 12 1 3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        TaskList instance = new TaskList();

        Task task1 = new Task("12", "title", "17:09:13", "projectName");
        instance.addTask(task1);
        instance.edit();
        assertEquals("3", task1.getTaskNu());
    }

    /**
     * Test of showByDdate method, of class TaskList. it test the first case
     * when the tasks list is empty.
     */
    @Test
    public void testShowByDdateEmpty() {

        TaskList instance = new TaskList();
        instance.showByDdate();

        String result = outContent.toString();
        assertEquals(" your task list empty!\n", result);
    }

    /**
     * Test of showByDdate method, of class TaskList. it test the second case
     * when the tasks list is not empty and it sort the tasks by date.
     */
    @Test
    public void testShowByDdateNotEmpty() {

        TaskList instance = new TaskList();
        Task task1 = new Task("12", "title", "17:09:13", "projectName");
        Task task2 = new Task("15", "title1", "18:09:13", "projectName1");
        instance.addTask(task1);
        instance.addTask(task2);
        instance.showByDdate();
//  String expResult= String.format("%8s %30s %12s %30s %5s", 
  //             "ID", "Title", "Date", "Project", "Done");
        
        String e1 = " \nyour tasks:\n \n";
        String e2 = String.format("%8s %30s %12s %30s %5s", 
               "ID", "Title", "Date", "Project", "Done");
        String e3 = "\n \n" + task1.toString() + "\n" + task2.toString();
  
        String expected = e1 + e2 + e3 + "\n"; 
        String expResult = " " + "\nyour tasks:" + "\n " +"\n"+String.format("%8s %30s %12s %30s %5s", 
               "ID", "Title", "Date", "Project", "Done\n") + task1.toString()+"\n" + task2.toString();
  
  
  // String expResult = " " + "\nyour tasks:" + "\n "
         //       + "\ntaskID  title  date  project name  status" + "\n \n"
           //     + task1.toString() + "\n" + task2.toString() + "\n";
        String result = outContent.toString();
        assertEquals(expected, result);
    }

    /**
     * Test of markDone method, of class TaskList. in case a valid taskId
     */
    @Test
    public void testMarkDoneValid() {
        String input = "12";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        TaskList instance = new TaskList();

        Task task1 = new Task("12", "title", "17:09:13", "projectName");
        instance.addTask(task1);
        instance.markDone();
        assertEquals(true, task1.getStatus());

    }

    /**
     * Test of markDone method, of class TaskList. 
     * in case a not valid taskId.
     */
    @Test
    public void testMarkDoneNotValid() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        TaskList instance = new TaskList();

        Task task1 = new Task("12", "title", "17:09:13", "projectName");
        instance.addTask(task1);
        instance.markDone();
        String expResult ="Please enter the taskID to mark it as done\n"+"your taskID does not exist\n";
        String result = outContent.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of nuOfDone method, of class TaskList.
     * Test number of the tasks are done.
     */
    @Test
    public void testNuOfDone() {
        
        TaskList instance = new TaskList();
         Task task1 = new Task("12", "title", "17:09:13", "projectName");
         instance.addTask(task1);
         task1.setStatus();
        int expResult = 1;
        int result = instance.nuOfDone();
        assertEquals(expResult, result);
       
    }

  

    /**
     * Test of noOftasksNotdone method,of class TaskList.
     */
    @Test
    public void testNoOftasksNotdone() {
        
        TaskList instance = new TaskList();
        Task task1 = new Task("12", "title", "17:09:13", "projectName");
        instance.addTask(task1);
        
        int expResult = 1;
        int result = instance.noOftasksNotdone();
        assertEquals(expResult, result);
      
    }

}
