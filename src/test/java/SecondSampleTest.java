import com.epam.jira.JIRATestKey;
import com.epam.jira.testng.ExecutionListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;


public class SecondSampleTest {
    private final Random random = new Random();

    @JIRATestKey(key = "EPMFARMATS-828")
    @Test ()
    public void testMethod() {
        boolean r = random.nextBoolean();
        Assert.assertTrue(r);
    }

}
