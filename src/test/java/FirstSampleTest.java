import com.epam.jira.JIRATestKey;
import com.epam.jira.core.JiraInfoProvider;
import com.epam.jira.testng.ExecutionListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Random;

@Listeners(ExecutionListener.class)
public class FirstSampleTest {
    private final Random random = new Random();


    @Test ()
    public void fakeMethod() {
        Assert.assertTrue(false);

    }

    @Test (dependsOnMethods = "fakeMethod")
    @JIRATestKey(key = "EPMFARMATS-826")
    public void testMethod() {
        JiraInfoProvider.saveFile(new File("C:\\Users\\Uladzimir_Pryhazhana\\IdeaProjects\\sample-tests\\.gitignore"));
        JiraInfoProvider.saveFile(new File("C:\\Users\\Uladzimir_Pryhazhana\\IdeaProjects\\sample-tests\\.gitignore"));
        boolean r = random.nextBoolean();
        Assert.assertTrue(r);

    }

}
