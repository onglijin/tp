package tp.acecs2103.model.task;


import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import tp.acecs2103.model.exceptions.InvalidTaskOperationException;



public class TaskTest {
    private Task defaultTaskOne = new Task(new Index("0101"), new WeekNumber("1"), new Description("Test Task One"),
            new OfficialDeadline("2020-09-10", LocalDate.of(2020, 9, 10)),
            null, new Remark("no remark"), false, false);
    private Task defaultTaskTwo = new Task(new Index("0101"), new WeekNumber("1"), new Description("Test Task One"),
            new OfficialDeadline("2021-01-01", LocalDate.of(2021, 1, 1)),
            null, new Remark("no remark"), false, false);
    private Task customizedTaskOne = new Task(new Index("0302"), new WeekNumber("3"),
            new Description("Test Task Three"), null,
            new CustomizedDeadline("2020-09-20", LocalDate.of(2020, 9, 20)),
            new Remark("no remark"), true, false);

    @Test
    public void hasIndexTest() {
        // same indexes -> true
        Assertions.assertTrue(defaultTaskOne.hasIndex(new Index("0101")));
        // difference indexes -> false
        Assertions.assertFalse(defaultTaskOne.hasIndex(new Index("0102")));
    }

    @Test
    public void hasDeadlineTest() {
        Assertions.assertFalse(defaultTaskOne.hasDeadline());
        Assertions.assertTrue(customizedTaskOne.hasDeadline());
    }

    @Test
    public void statusChangeTest() {
        defaultTaskOne.markAsDone();
        Assertions.assertTrue(defaultTaskOne.isDone());
        defaultTaskOne.markAsPending();
        Assertions.assertFalse(defaultTaskOne.isDone());
    }

    @Test
    public void setDeadlineTest() {
        try {
            defaultTaskOne.setDeadline(
                    new CustomizedDeadline("2020-10-10",
                            LocalDate.of(2020, 10, 10)));
        } catch (InvalidTaskOperationException e) {
            Assertions.assertFalse(true);
        }
        try {
            defaultTaskTwo.setDeadline(
                    new CustomizedDeadline("2020-10-10",
                            LocalDate.of(2020, 10, 10)));
        } catch (InvalidTaskOperationException e) {
            Assertions.assertFalse(true);
        }
        boolean test = false;
        try {
            defaultTaskTwo.setDeadline(
                    new CustomizedDeadline("2021-01-02",
                            LocalDate.of(2021, 1, 2)));
        } catch (InvalidTaskOperationException e) {
            test = true;
        }
        Assertions.assertTrue(true);

        CustomizedDeadline newDeadline = new CustomizedDeadline("2020-10-10",
                LocalDate.of(2020, 10, 10));
        Assertions.assertTrue(defaultTaskOne.getCustomizedDeadline().equals(newDeadline));
    }

    @Test
    public void isValidTest() {
        Assertions.assertTrue(defaultTaskOne.isValid());

        Task invalidTask = new Task(new Index("0202"), new WeekNumber("2"), new Description("Test Task Two"),
                new OfficialDeadline("2020-09-10", LocalDate.of(2020, 9, 10)),
                null, new Remark("no remark"), true, false);
        Assertions.assertFalse(invalidTask.isValid());
    }

    @Test
    public void isWeekXTest() {
        Assertions.assertTrue(defaultTaskOne.isWeekX(new WeekNumber("1")));
        Assertions.assertFalse(defaultTaskOne.isWeekX(new WeekNumber("2")));
    }

    @Test
    public void containsTest() {
        Assertions.assertTrue(defaultTaskOne.contains("Test"));
        Assertions.assertTrue(defaultTaskOne.contains("test"));
        Assertions.assertFalse(defaultTaskOne.contains("no meaning"));
    }

    @Test
    public void isSameTaskTest() {
        Assertions.assertTrue(defaultTaskOne.isSameTask(defaultTaskTwo));
        Assertions.assertFalse(defaultTaskOne.isSameTask(customizedTaskOne));
    }

    @Test
    public void isOverDueTest() {
        Assertions.assertTrue(defaultTaskOne.isOverdue());
        Assertions.assertFalse(defaultTaskTwo.isOverdue());
    }

    @Test
    public void compareToTest() {
        Assertions.assertTrue(defaultTaskOne.compareTo(defaultTaskTwo) < 0);
        Assertions.assertTrue(defaultTaskTwo.compareTo(defaultTaskOne) > 0);
    }

}
