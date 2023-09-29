package Hook;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;


    public static void intDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(15));
     }


     public static void setURL(String url){
        driver.get(url);
     }

     public static void delay(Integer second)  {
         try {
             Thread.sleep(second*1000);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
     }


     public static void tearDown(){
        driver.close();
     }

}
