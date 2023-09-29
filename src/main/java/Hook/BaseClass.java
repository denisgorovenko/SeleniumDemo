package Hook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BaseClass {

    public WebDriver driver;
    public WebDriverWait webDriverWait;

    public BaseClass(WebDriver driver,WebDriverWait webDriverWait){
        this.driver = driver;
        this.webDriverWait = webDriverWait;
    }

    public void waitWebElementVisibility(WebElement webElement){
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }





}
