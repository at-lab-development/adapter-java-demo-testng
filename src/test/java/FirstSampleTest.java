import com.epam.jira.JIRATestKey;
import com.epam.jira.testng.ExecutionListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;

@Listeners(ExecutionListener.class)
public class FirstSampleTest {
    private final Random random = new Random();

    @Test ()
    @JIRATestKey(key = "EPMFARMATS-826")
    public void testMethod() {
        boolean r = random.nextBoolean();
        Assert.assertTrue(r);

    }

}
