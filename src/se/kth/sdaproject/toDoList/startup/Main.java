
package se.kth.sdaproject.toDoList.startup;




import se.kth.sdaproject.toDoList.view.CommandWords;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            CommandWords s = new CommandWords();
            s.action();
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

}
