package tp.acecs2103.commons.util;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import javafx.scene.image.Image;
import tp.acecs2103.MainApp;


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
        LocalDate currentTime = LocalDate.now();
        LocalDate weekOne = LocalDate.of(2020, 8, 10);
        int difference = (int) weekOne.until(currentTime, ChronoUnit.DAYS);
        return difference / 7 + 1;
    }
}
