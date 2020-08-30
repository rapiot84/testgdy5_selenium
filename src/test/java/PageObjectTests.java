import PageObjects.DevToMainPage;
import PageObjects.DevToPodcastsPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PageObjectTests {
    WebDriver driverInPageObjectTests;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium drivers\\chromedriver.exe");//wskazanie chromedriver
        driverInPageObjectTests = new ChromeDriver();
        driverInPageObjectTests.manage().window().maximize();
        driverInPageObjectTests.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        DevToMainPage devToMainPage = new DevToMainPage(driverInPageObjectTests);


        DevToPodcastsPage devToPodcastsPage = devToMainPage.selectPodcasts();
        devToPodcastsPage.SelectPodcastFromList(2);
    }

}
