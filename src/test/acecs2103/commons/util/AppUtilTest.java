package tp.acecs2103.commons.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static tp.acecs2103.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;
import tp.acecs2103.testutil.Assert;

public class AppUtilTest {

    @Test
    public void getImage_exitingImage() {
        assertNotNull(AppUtil.getImage("/images/ace_cs2103.png"));
    }

    @Test
    public void getImage_nullGiven_throwsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> AppUtil.getImage(null));
    }

    @Test
    public void checkArgument_true_nothingHappens() {
        AppUtil.checkArgument(true);
        AppUtil.checkArgument(true, "");
    }

    @Test
    public void checkArgument_falseWithoutErrorMessage_throwsIllegalArgumentException() {
        Assert.assertThrows(IllegalArgumentException.class, () -> AppUtil.checkArgument(false));
    }

    @Test
    public void checkArgument_falseWithErrorMessage_throwsIllegalArgumentException() {
        String errorMessage = "error message";
        Assert.assertThrows(IllegalArgumentException.class, errorMessage, () -> AppUtil.checkArgument(false, errorMessage));
    }
}