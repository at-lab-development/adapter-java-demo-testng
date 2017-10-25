import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class FirstSampleTest {
    private final Random random = new Random();

    @Test (description = "EPMFARMATS-826")
    public void testMethod() {
        boolean r = random.nextBoolean();
        Assert.assertTrue(r);

    }

}
