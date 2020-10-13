package tp.acecs2103.model.util;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import tp.acecs2103.model.AddressBook;
import tp.acecs2103.model.ReadOnlyAddressBook;
import tp.acecs2103.model.TaskList;
import tp.acecs2103.model.task.*;
import tp.acecs2103.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Task[] getSampleTasks() {
        return new Task[] {
            new Admin("0101", 1, "Week 1 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("0102", 1, "Week 1 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("0103", 1, "Week 1 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("0104", 1, "Week 1 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("0105", 1, "Week 1 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("0106", 1, "Week 1 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("0107", 1, "Week 1 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("0108", 1, "Week 1 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("0201", 2, "Week 2 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("0202", 2, "Week 2 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("0203", 2, "Week 2 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("0204", 2, "Week 2 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("0205", 2, "Week 2 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("0206", 2, "Week 2 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("0207", 2, "Week 2 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("0208", 2, "Week 2 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("0301", 3, "Week 3 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("0302", 3, "Week 3 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("0303", 3, "Week 3 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("0304", 3, "Week 3 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("0305", 3, "Week 3 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("0306", 3, "Week 3 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("0307", 3, "Week 3 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("0308", 3, "Week 3 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("0401", 4, "Week 4 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("0402", 4, "Week 4 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("0403", 4, "Week 4 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("0404", 4, "Week 4 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("0405", 4, "Week 4 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("0406", 4, "Week 4 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("0407", 4, "Week 4 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("0408", 4, "Week 4 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("0501", 5, "Week 5 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("0502", 5, "Week 5 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("0503", 5, "Week 5 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("0504", 5, "Week 5 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("0505", 5, "Week 5 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("0506", 5, "Week 5 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("0507", 5, "Week 5 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("0508", 5, "Week 5 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("0601", 6, "Week 6 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("0602", 6, "Week 6 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("0603", 6, "Week 6 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("0604", 6, "Week 6 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("0605", 6, "Week 6 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("0606", 6, "Week 6 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("0607", 6, "Week 6 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("0608", 6, "Week 6 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("0701", 7, "Week 7 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("0702", 7, "Week 7 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("0703", 7, "Week 7 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("0704", 7, "Week 7 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("0705", 7, "Week 7 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("0706", 7, "Week 7 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("0707", 7, "Week 7 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("0708", 7, "Week 7 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("0801", 8, "Week 8 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("0802", 8, "Week 8 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("0803", 8, "Week 8 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("0804", 8, "Week 8 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("0805", 8, "Week 8 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("0806", 8, "Week 8 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("0807", 8, "Week 8 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("0808", 8, "Week 8 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("0901", 9, "Week 9 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("0902", 9, "Week 9 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("0903", 9, "Week 9 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("0904", 9, "Week 9 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("0905", 9, "Week 9 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("0906", 9, "Week 9 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("0907", 9, "Week 9 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("0908", 9, "Week 9 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("01001", 10, "Week 10 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("01002", 10, "Week 10 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("01003", 10, "Week 10 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("01004", 10, "Week 10 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("01005", 10, "Week 10 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("01006", 10, "Week 10 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("01007", 10, "Week 10 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("01008", 10, "Week 10 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("01101", 11, "Week 11 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("01102", 11, "Week 11 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("01103", 11, "Week 11 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("01104", 11, "Week 11 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("01105", 11, "Week 11 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("01106", 11, "Week 11 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("01107", 11, "Week 11 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("01108", 11, "Week 11 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("01201", 12, "Week 12 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("01202", 12, "Week 12 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("01203", 12, "Week 12 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("01204", 12, "Week 12 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("01205", 12, "Week 12 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("01206", 12, "Week 12 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("01207", 12, "Week 12 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("01208", 12, "Week 12 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("01301", 13, "Week 13 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("01302", 13, "Week 13 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("01303", 13, "Week 13 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("01304", 13, "Week 13 TP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Admin("01305", 13, "Week 13 Admin", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new Topic("01306", 13, "Week 13 Topic", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new IP("01307", 13, "Week 13 IP", LocalDate.of(2020, 12, 2), null, "Nothing here"),
            new TP("01308", 13, "Week 13 TP", LocalDate.of(2020, 12, 2), null, "Nothing here")
        };
    }

    public static TaskList getSampleTaskList() {
        TaskList sampleTaskList = new TaskList();
        for (Task sampleTask : getSampleTasks()) {
            sampleTaskList.add(sampleTask);
        }
        return sampleTaskList;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
