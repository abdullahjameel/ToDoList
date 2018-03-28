
package se.kth.sdaproject.toDoList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;


public class TaskTest {

    public TaskTest() {
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
     * Test of toString method ,of class Task. In case the task is not marked as
     * done while the field done is false
     *
     */
    @Test
    public void testToStringNotDoneTask() {

        Task instance = new Task("12", "title", "17:09:13", "projectName");

       String expResult= String.format("%8s %30s %12s %30s %5s", 
                "12", "title", "17:09:13", "projectName", "No");
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method ,of class Task. In case the task marked as done
     * while the field done is true
     *
     */
    @Test
    public void testToStringDoneTask() {

        Task instance = new Task("12", "title", "17:09:13", "projectName"+"Yes");
        instance.setStatus();
     
         String expResult= String.format("%8s %30s %12s %30s %5s", 
                "12", "title", "17:09:13", "projectNameYes", "Yes");
       
        String result = instance.toString();
        assertEquals(expResult, result);

    }

}
