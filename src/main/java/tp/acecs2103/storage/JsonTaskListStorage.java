package tp.acecs2103.storage;

import tp.acecs2103.commons.exceptions.DataConversionException;
import tp.acecs2103.model.ReadOnlyAddressBook;
import tp.acecs2103.model.task.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

public class JsonTaskListStorage {


    private Path filePath;

    public JsonTaskListStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getTaskListFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlyAddressBook> readAddressBook() throws DataConversionException {
        return readAddressBook(filePath);
    }
    public TaskStorage(String fileName) {
        String dir = System.getProperty("user.dir");
        this.path = path;
        Path path = Paths.get(dir, "project", fileName);
        File file = path.toFile();
        if (file.exists()) {
            this.file = file;
        } else {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
                this.file = file;
            } catch (IOException e) {
                System.out.println("Failed to create" + fileName);
            }
        }
    }


    public ArrayList<Task> readTaskList() {

    }

    public void writeTaskList(ArrayList<Task> taskList) {

    }

}
