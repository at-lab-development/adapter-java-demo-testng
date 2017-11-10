import com.epam.jira.JIRATestKey;
import com.epam.jira.util.JiraInfoProvider;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Random;

@Listeners(com.epam.jira.testng.ExecutionListener.class)
public class SimpleTest {

    @Test
    @JIRATestKey(key = "EPMFARMATS-1010")
    public void checkArtifacts() {
        Random random = new Random();

        JiraInfoProvider.saveValue("Random number", String.valueOf(random.nextInt()));
        JiraInfoProvider.saveValue("Random boolean", String.valueOf(random.nextBoolean()));
        JiraInfoProvider.saveValue("Some static string", "Hello, world!");
        JiraInfoProvider.saveFile(new File(".\\src\\test\\resources\\jenkins-oops.jpg"));
        JiraInfoProvider.saveFile(new File(".\\src\\test\\resources\\jenkins-oops.jpg"));

        int result  = 100 / 0;
        JiraInfoProvider.saveValue("100 / 0 = ", String.valueOf(result));
    }

    @Test(enabled = false)
    @JIRATestKey(key = "EPMFARMATS-1011")
    public void untestedTest() {
        Assert.assertTrue(true);
    }

}