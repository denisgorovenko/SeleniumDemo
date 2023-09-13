package Hook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {

    private static WebDriver driver = new ChromeDriver();
    private final WebDriverWait webDriverWait;

    public Driver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(15));
     }

     public static WebDriver getDriver() {
        return  driver;
     }

     public void waitElementDisplayed(WebElement element){
         webDriverWait.until(item -> element.isDisplayed());
     }

     public static void setUrl(String url) {
        driver.get(url);
     }

     public static void delay(Integer second) throws InterruptedException {
         Thread.sleep(second*1000L);
     }

     public void deleteCookies(){
        driver.manage().deleteAllCookies();
     }

     public static void tearDown(){
        driver.close();
     }

}
