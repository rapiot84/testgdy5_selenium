import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class FirstTests {

    WebDriver driver; // inicjalizacja pustej przegladarki
    public void highlightElement(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 3px solid blue;');", element);
    }

    @Before//sekcja before, a wlasciwie metoda setup wykona sie przed kazdym testem
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\selenium drivers\\chromedriver.exe");//wskazanie chromedriver
        driver=new ChromeDriver(); //przypisanie do pustej przegladarki, przegladarki chrome
        driver.manage().window().maximize();
        driver.get("https://dev.to");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //przed kazdym kolejnym findElements poczekaj 10 s zanim wywalisz error, co sekunde sprawdzaj czy element jest juz dostepny


    }

    @Test
    public void goToPodcastsAndSelectThirdOneAndPlayIt(){
        WebElement podcastBtn = driver.findElement(By.xpath("//a[@href='/pod']"));
        highlightElement(driver,podcastBtn);
        podcastBtn.click();
        String podcastUrl = driver.getCurrentUrl();
        //przejscie na strone z podcastami
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.urlToBe("https://dev.to/pod"));

        List<WebElement> podcasts = driver.findElements(By.tagName("h3"));
       // for (WebElement podcast: podcasts){
      //      highlightElement(driver,podcast);
      //  }
        WebElement thirdPodcast = podcasts.get(2);
        thirdPodcast.click();
        WebElement recordBtn = driver.findElement(By.className("record-wrapper"));
        recordBtn.click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("status-message"))));
       String recordBtnClassAttribute = recordBtn.getAttribute("class");
       boolean isPlaying = recordBtnClassAttribute.contains("playing");
       assertTrue( "podcast wasn't played", recordBtnClassAttribute.contains("playing"));

    }


        @Test public void secondTest(){
            WebElement weekBtn = driver.findElement(By.xpath("//*[@id=\"on-page-nav-controls\"]/div/nav/a[2]"));
        weekBtn.click(); WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe("dev.to/top/week"));
        WebElement firstArticle= driver.findElement(By.xpath("//*[@id=\"article-link-434803\"]"));
        firstArticle.click();
    }}


