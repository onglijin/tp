package tp.acecs2103.logic.commands;

//import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

//import org.junit.jupiter.api.Test;

import tp.acecs2103.model.task.*;

public class DeadlineCommandTest {

   // @Test
    public void equals() {
        Task taskOne = new Admin(new Index("0101"), new WeekNumber("1"), new Description("Submit pre-lecture quiz"),
                new OfficialDeadline("2020-08-17", LocalDate.of(2020,8,17)), null, new Remark("Nothing here"), false, false);
       Task taskTwo = new Topic(new Index("0101"), new WeekNumber("1"), new Description("Sample topic"),
               new OfficialDeadline("2020-08-17", LocalDate.of(2020,8,17)), null, new Remark("Nothing here"), false, false));
        DeadlineCommand newDeadlineTaskOneCommand = new DeadlineCommand(taskOne.getIndex(),
                new Deadline("2020-12-02",LocalDate.of(2020, 12, 02));
        DeadlineCommand newDeadlineTaskTwoCommand = new DeadlineCommand(taskTwo.getIndex(),
                new Deadline("2020-12-02",LocalDate.of(2020, 12, 02));

        // same object -> returns true
       // assertTrue(newDeadlineTaskOneCommand.getNewDeadline().equals(newDeadlineTaskTwoCommand.getNewDeadline()));
    }
}
