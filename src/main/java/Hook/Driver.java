package Hook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {

    private final WebDriver driver;
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

     public WebDriver getDriver() {
        return  driver;
     }

     public void waitElementDisplayed(WebElement element){
         webDriverWait.until(item -> element.isDisplayed());
     }

     public void setUrl(String url) {
        driver.get(url);
     }

     public void delay(Long second) throws InterruptedException {
         Thread.sleep(second);
     }

     public void deleteCookies(){
        driver.manage().deleteAllCookies();
     }

     public void tearDown(){
        driver.close();
     }

}
