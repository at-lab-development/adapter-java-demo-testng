package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.net.MalformedURLException;
import java.net.URL;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class DriverManager {

    private static DriverManager instance;

    private WebDriver driver;

    public static DriverManager getInstance() {
        if (instance == null) {
            synchronized (DriverManager.class) {
                if (instance == null)
                    instance = new DriverManager();
            }
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (null == driver) {
            createDriver();
        }
        return driver;
    }

    private void createDriver() {
        String urlAddress = "http://localhost:4444/wd/hub";
        URL url;

        try {
            url = new URL(urlAddress);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Illegal URL address: " + urlAddress, e);
        }

        driver = new RemoteWebDriver(url, DesiredCapabilities.chrome());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
    }


    public void open(String URL) {
        getDriver().get(URL);
    }

    public void quit() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

    public void waitUntilVisible(WebElement element) {
        FluentWait wait = new FluentWait<>(driver)
                .withTimeout(20, SECONDS)
                .pollingEvery(100, MILLISECONDS);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
