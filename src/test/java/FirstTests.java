import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

    }

    @Test
    public void firstTest(){
driver.get("https://dev.to");
        WebElement podcastBtn = driver.findElement(By.xpath("//a[@href='/pod']"));
        highlightElement(driver,podcastBtn);
    }

    @Test
    public void secondTest(){
    }

}
