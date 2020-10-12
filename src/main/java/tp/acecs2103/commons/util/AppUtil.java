package tp.acecs2103.commons.util;

import static java.util.Objects.requireNonNull;

import javafx.scene.image.Image;
import tp.acecs2103.MainApp;

import java.time.Duration;
import java.time.LocalDate;

/**
 * A container for App specific utility functions
 */
public class AppUtil {

    /**
     * Gets an {@code Image} from the specified path.
     */
    public static Image getImage(String imagePath) {
        requireNonNull(imagePath);
        return new Image(MainApp.class.getResourceAsStream(imagePath));
    }

    /**
     * Checks that {@code condition} is true. Used for validating arguments to methods.
     *
     * @throws IllegalArgumentException if {@code condition} is false.
     */
    public static void checkArgument(Boolean condition) {
        if (!condition) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Checks that {@code condition} is true. Used for validating arguments to methods.
     *
     * @throws IllegalArgumentException with {@code errorMessage} if {@code condition} is false.
     */
    public static void checkArgument(Boolean condition, String errorMessage) {
        if (!condition) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    /**
     * Gets current week number based on local time.
     * @return current week number.
     */
    public static int getCurrentWeekNumber() {
//        LocalDate currentTime = LocalDate.now();
//        LocalDate weekOne = LocalDate.of(2020, 8, 10);
//        Duration duration = Duration.between(weekOne, currentTime);
//        int difference = (int) duration.toDays();
//        return difference / 7;
        return 1;
    }
}
