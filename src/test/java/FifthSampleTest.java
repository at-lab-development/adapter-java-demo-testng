import com.epam.jira.JIRATestKey;
import com.epam.jira.testng.ExecutionListener;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;

@Listeners(ExecutionListener.class)
public class FifthSampleTest {
    private final Random random = new Random();

    @Test (dependsOnMethods = "fakeMethod")
    @JIRATestKey(key = "EPMFARMATS-826")
    public void testMethod() {
        throw new RuntimeException("Throwing EX");
    }

}
