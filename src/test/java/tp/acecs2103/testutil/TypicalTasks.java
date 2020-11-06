package tp.acecs2103.testutil;


import tp.acecs2103.model.TaskList;
import tp.acecs2103.model.task.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A utility class containing a list of {@code Task} objects to be used in tests.
 */
public class TypicalTasks {

    public static final Admin AdminOne = new TaskBuilder().withIndex("0101").withWeekNumber("1")
            .withDescription("Admin One").withOfficialDeadline("2020-10-10").withCustomizedDeadline(null)
            .withRemark("No remark").withIsCustomized(false).withIsDone(false).buildAdmin();
    public static final Admin AdminTwo = new TaskBuilder().withIndex("0102").withWeekNumber("1")
            .withDescription("Admin Two").withOfficialDeadline(null).withCustomizedDeadline("2020-10-20")
            .withRemark("No remark").withIsCustomized(true).withIsDone(false).buildAdmin();
    public static final Topic TopicOne = new TaskBuilder().withIndex("0201").withWeekNumber("2")
            .withDescription("Topic One").withOfficialDeadline("2020-10-10").withCustomizedDeadline(null)
            .withRemark("No remark").withIsCustomized(false).withIsDone(false).buildTopic();
    public static final Topic TopicTwo = new TaskBuilder().withIndex("0202").withWeekNumber("2")
            .withDescription("Topic Two").withOfficialDeadline(null).withCustomizedDeadline("2020-10-20")
            .withRemark("No remark").withIsCustomized(true).withIsDone(false).buildTopic();
    public static final IP IpOne = new TaskBuilder().withIndex("0301").withWeekNumber("3")
            .withDescription("Ip One").withOfficialDeadline("2020-10-10").withCustomizedDeadline(null)
            .withRemark("No remark").withIsCustomized(false).withIsDone(false).buildIp();
    public static final IP IpTwo = new TaskBuilder().withIndex("0302").withWeekNumber("3")
            .withDescription("Ip Two").withOfficialDeadline(null).withCustomizedDeadline("2020-10-20")
            .withRemark("No remark").withIsCustomized(true).withIsDone(false).buildIp();
    public static final TP TpOne = new TaskBuilder().withIndex("0401").withWeekNumber("4")
            .withDescription("Tp One").withOfficialDeadline("2020-10-10").withCustomizedDeadline(null)
            .withRemark("No remark").withIsCustomized(false).withIsDone(false).buildTp();
    public static final TP TpTwo = new TaskBuilder().withIndex("0402").withWeekNumber("4")
            .withDescription("Tp Two").withOfficialDeadline(null).withCustomizedDeadline("2020-10-20")
            .withRemark("No remark").withIsCustomized(true).withIsDone(false).buildTp();

    public static final Admin AdminExtraOne = new TaskBuilder().withIndex("0103").withWeekNumber("1")
            .withDescription("Admin Extra One").withOfficialDeadline("2020-10-10").withCustomizedDeadline(null)
            .withRemark("No remark").withIsCustomized(false).withIsDone(false).buildAdmin();
    public static final Admin AdminExtraTwo = new TaskBuilder().withIndex("0104").withWeekNumber("1")
            .withDescription("Admin Extra Two").withOfficialDeadline("2020-10-10").withCustomizedDeadline(null)
            .withRemark("No remark").withIsCustomized(false).withIsDone(false).buildAdmin();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalTasks() {} // prevents instantiation

    /**
     * Returns an {@code TaskList} with all the typical tasks.
     */
    public static TaskList getTypicalTaskList() {
        TaskList taskList = new TaskList();
        for (Task task: getTypicalTasks()) {
            taskList.add(task);
        }
        return taskList;
    }

    public static List<Task> getTypicalTasks() {
        return new ArrayList<>(Arrays.asList(AdminOne, AdminTwo, TopicOne, TopicTwo,
                IpOne, IpTwo, TpOne, TpTwo));
    }
}
