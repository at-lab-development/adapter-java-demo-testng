import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class FourthSampleTest {
    private final Random random = new Random();

    @Test (description = "EPMFARMATS-827")
    public void testMethod() {
        boolean r = random.nextBoolean();
        Assert.assertTrue(r);
    }

}
