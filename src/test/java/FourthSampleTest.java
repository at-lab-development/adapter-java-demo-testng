import com.epam.jira.JIRATestKey;
import com.epam.jira.testng.ExecutionListener;
import com.epam.jira.util.JiraInfoProvider;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class FourthSampleTest {
    private final Random random = new Random();

    @JIRATestKey(key = "EPMFARMATS-827")
    @Test ()
    public void testMethod() throws InterruptedException {
        boolean r = random.nextBoolean();
        TimeUnit.SECONDS.sleep(2);

        JiraInfoProvider.saveValue("Value1", "Sample");
        JiraInfoProvider.saveValue("Value2", "Sample");
        JiraInfoProvider.saveValue("Value3", "Sample");
        Assert.assertTrue(true);

    }

}
