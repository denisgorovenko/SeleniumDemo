package page;

import hook.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsPage extends BaseClass {


    public ElementsPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
        PageFactory.initElements(driver,this);
    }

    private WebElement groupElement(String element){
        return driver.findElement(By.xpath("//div[text() = '"+element+"']//ancestor::div[@class = 'element-group']"));
    }

    private boolean isCollapseList(String element) throws NoSuchElementException {
        try {
           return groupElement(element).findElement(By.xpath(".//div[contains(@class , 'show')]")).isDisplayed();
        } catch (NoSuchElementException e){
           return false;
        }
    }

    public void collapseGroupElement(String element){
        System.out.println(isCollapseList(element)+ " / " +element);
        if(!isCollapseList(element)){
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", groupElement(element));
            Actions actions = new Actions(driver);
            actions.moveToElement(groupElement(element)).click().build().perform();
        }
    }

    public void selectGroupItem(String item){
        driver.findElement(By.xpath("//span[text() = '"+item+"']")).click();
    }
}
