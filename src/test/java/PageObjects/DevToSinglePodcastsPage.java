package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DevToSinglePodcastsPage {
    @FindBy(className = "record-wrapper")
    WebElement recordBtn;
    WebDriver driverInDevToSinglePodcastPage;
    WebDriverWait wait;
    public void isPodcastPlaying;

    public DevToSinglePodcastsPage(WebDriver driverFromDevToPodcastsPage, WebDriverWait _wait) {
      this.driverInDevToSinglePodcastPage = driverFromDevToPodcastsPage;
        PageFactory.initElements(driverInDevToSinglePodcastPage, this);

        this.wait = _wait;
    }

    public void playPodcast(){
        recordBtn.click();
        wait.until(ExpectedConditions.invisibilityOf(driverInDevToSinglePodcastPage.findElement(By.className("status-message"))));
        String recordBtnClassAttribute = recordBtn.getAttribute("class");
        isPodcastPlaying = recordBtnClassAttribute.contains("playing");
    }

}
