/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sdaproject.toDoList;

import se.kth.sdaproject.toDoList.DBhandler.IOFile;
import se.kth.sdaproject.toDoList.model.Task;
import java.util.ArrayList;
import java.util.List;
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
public class IOFileTest {
    
    public IOFileTest() {
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
     * Test of getTasks method, of class IOFile.
     * @throws java.lang.Exception
     */
     @Test
    public void testGetTasks() throws Exception {
       
        IOFile instance = new IOFile();
        ArrayList<Task> expResult = new ArrayList<>();
         Task task1 = new Task("12", "title", "17:09:13", "projectName");
         expResult.add(task1);
        ArrayList<Task>  result = instance.getTasks();
        assertEquals(expResult, result);
     
    }

    /**
     * Test of saveTasks method, of class IOFile.
     */
    @Test
    public void testSaveTasks() throws Exception {
       
        List<Task> myTasks = new ArrayList<>();
         Task task1 = new Task("12", "title", "17:09:13", "projectName");
         myTasks.add(task1);
        IOFile instance = new IOFile();
        boolean expResult = true;
        boolean result = instance.saveTasks(myTasks);
        assertEquals(expResult, result);
      
    }
    
}
