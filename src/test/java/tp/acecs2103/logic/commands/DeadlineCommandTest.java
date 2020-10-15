package tp.acecs2103.logic.commands;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import tp.acecs2103.commons.core.index.Index;
import tp.acecs2103.model.task.Task;

public class DeadlineCommandTest {
    
    @Test
    public void equals() {
        Task taskOne = new Task("00101", 10, "Week 10 Admin", 
                LocalDate.of(2020,12,02),null, "Nothing here");
        Task taskTwo = new Task("00101", 10, "Week 10 Admin", 
                LocalDate.of(2020,12,02),null, "Nothing here");
        DeadlineCommand newDeadlineTaskOneCommand = new DeadlineCommand(new Index(taskOne.getIndex()), 
                LocalDate.of(2020,12,02));
        DeadlineCommand newDeadlineTaskTwoCommand = new DeadlineCommand(new Index(taskTwo.getIndex()), 
                LocalDate.of(2020,12,02));
        
        // same object -> returns true
        assertTrue(newDeadlineTaskOneCommand.getNewDeadline().equals(newDeadlineTaskTwoCommand.getNewDeadline()));
    }
}
