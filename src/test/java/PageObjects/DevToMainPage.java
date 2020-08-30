package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DevToMainPage {
    public String url = "https://dev.to";
    WebDriver driverInDevToMainPage;
    @FindBy(xpath = "//a[@href='/pod']")
    WebElement podcastBtn;

    public DevToMainPage(WebDriver driverFromPageObjectTests) {
        this.driverInDevToMainPage = driverFromPageObjectTests;

        driverInDevToMainPage.get(url);//otwieramy stronę w przeglądarce
        PageFactory.initElements(driverInDevToMainPage, this);
    }

    public DevToPodcastsPage selectPodcasts() {
        podcastBtn.click();
        return new DevToPodcastsPage(driverInDevToMainPage);
    }
}
