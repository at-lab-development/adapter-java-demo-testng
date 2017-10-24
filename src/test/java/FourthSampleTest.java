import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class FourthSampleTest {
    private final Random random = new Random();

    @Test
    public void testMethod() {
        boolean r = random.nextBoolean();
        Assert.assertTrue(r);
    }

}
