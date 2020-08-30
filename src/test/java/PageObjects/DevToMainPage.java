package PageObjects;

import org.openqa.selenium.WebDriver;

public class DevToMainPage {
    public String url = "https://dev.to";
    WebDriver driverInDevToMainPage;

    public DevToMainPage(WebDriver driverFromPageObjectTests) {
        this.driverInDevToMainPage = driverFromPageObjectTests;

        driverInDevToMainPage.get(url);//otwieramy stronę w przeglądarce
    }
}
