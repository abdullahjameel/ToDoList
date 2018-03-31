/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sdaproject.toDoList;

import se.kth.sdaproject.toDoList.model.Task;
import se.kth.sdaproject.toDoList.controller.TaskList;
import se.kth.sdaproject.toDoList.view.CommandWords;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
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
public class CommandWordsTest {
    
    public CommandWordsTest() {
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
     * Test of action method, of class CommandWords.
     * @throws java.lang.Exception
     */
   @Test
    public void testAction() throws Exception {
        String input = "add 45 title 18:09:13 project";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        TaskList task = new TaskList();
        Task task1 = new Task("12", "title", "17:09:13", "projectName");
     // ArrayList<Task> tasks= new ArrayList<>();
        CommandWords instance = new CommandWords();
        instance.action();
       // tasks.add(task1);
         task.addTask(task1);
         String result = task1.toString();
       String expResult="45 title 18:09:13 project";
       assertEquals(expResult, result);
    }
    
}
