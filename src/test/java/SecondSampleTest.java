import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class SecondSampleTest {
    private final Random random = new Random();

    @Test (description = "EPMFARMATS-828")
    public void testMethod() {
        boolean r = random.nextBoolean();
        Assert.assertTrue(r);
    }

}
