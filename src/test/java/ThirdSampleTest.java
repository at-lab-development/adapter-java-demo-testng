import com.epam.jira.JIRATestKey;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class ThirdSampleTest {
    private final Random random = new Random();

    @JIRATestKey(key = "WRONGKEY")
    @Test
    public void testMethod() {
        boolean r = random.nextBoolean();
        Assert.assertTrue(r);
    }

}
