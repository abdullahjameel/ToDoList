/**
 * This class is a part of ToDo project classes
 * which will create a file, read and save date. 
 */
package se.kth.sdaproject.toDoList.DBhandler;


import se.kth.sdaproject.toDoList.model.Task;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;

import java.util.ArrayList;
import java.util.List;

public class IOFile {

    private final static String Task_Lists = "Tasks.txt";

    public ArrayList<Task> getTasks() throws IOException {

        ArrayList<Task> myTasks = new ArrayList<Task>();
        Charset charset = Charset.forName("US-ASCII");
        Path path = Paths.get(Task_Lists);
        if (Files.exists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS})) {
            BufferedReader reader = Files.newBufferedReader(path, charset);
            String details;
            while ((details = reader.readLine()) != null) {
                String[] sections = details.split(",");
                Task task = new Task(
                        sections[0],
                        sections[1],
                        sections[2],
                        sections[3]);

                if (Boolean.parseBoolean(sections[4])) {
                    task.setStatus();
                }

                myTasks.add(task);

            }
        }
        else {
        Files.createFile(path);
        }
        return myTasks;
    }

    public boolean saveTasks(List<Task> myTasks) throws IOException {
        Path resultsFile = Paths.get(Task_Lists).toAbsolutePath();
        FileWriter writer = new FileWriter(resultsFile.toString());
        for (Task details : myTasks) {
            writer.write(details.getTaskNu() + "," + details.getTitle() + "," + details.getDate() + "," + details.getProjectName() + "," + details.getStatus());
            writer.write('\n');

        }
        writer.close();

        File file = new File(Task_Lists);
        return file.exists();
    }
}
