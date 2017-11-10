import com.epam.jira.JIRATestKey;
import com.epam.jira.util.JiraInfoProvider;
import com.epam.jira.util.Screenshoter;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.DriverManager;
import pages.YoutubePage;

@Listeners(com.epam.jira.testng.ExecutionListener.class)
public class YoutubeTest {

    @BeforeClass
    public void initialize() {
        Screenshoter.initialize(DriverManager.getInstance().getDriver());
    }

    @Test
    @JIRATestKey(key = "EPMFARMATS-829")
    public void alwaysPassedTest() {
        YoutubePage page = new YoutubePage("https://www.youtube.com/watch?v=UKKYpdWPSL8");
        String author = page.getAuthorName();

        JiraInfoProvider.saveValue("Author", author);
        JiraInfoProvider.saveValue("Title", page.getVideoTitle());

        Assert.assertEquals(author, "EPAM Systems Global");
    }

    @Test
    @JIRATestKey(key = "EPMFARMATS-845")
    public void alwaysFailedTest() {
        YoutubePage page = new YoutubePage("https://www.youtube.com/watch?v=sU4i4DTr1HQ");
        String author = page.getAuthorName();
        String title = page.getVideoTitle();

        JiraInfoProvider.saveValue("Author", author);
        JiraInfoProvider.saveValue("Title", title);

        Assert.assertEquals("Atlassian", author);
    }

    @Test(dependsOnMethods = "alwaysFailedTest")
    @JIRATestKey(key = "EPMFARMATS-844")
    public void alwaysBlockedTest() {
        Assert.assertTrue(true);
    }

    @AfterClass
    public void close() {
        Screenshoter.initialize(null);
        DriverManager.getInstance().quit();
    }
}
