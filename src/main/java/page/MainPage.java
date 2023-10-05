package page;


import hook.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BaseClass {


    @FindBy(xpath = "//div[@class = 'card mt-4 top-card'][1]")
    public WebElement elementPage;
    @FindBy(xpath = "//div[@class = 'card mt-4 top-card'][2]")
    public WebElement formsPage;
    @FindBy(xpath = "//div[@class = 'card mt-4 top-card'][3]")
    public WebElement alertFramePage;
    @FindBy(xpath = "//div[@class = 'card mt-4 top-card'][4]")
    public WebElement widgetsPage;
    @FindBy(xpath = "//div[@class = 'card mt-4 top-card'][5]")
    public WebElement interactionsPage;
    @FindBy(xpath = "//div[@class = 'card mt-4 top-card'][6]")
    public WebElement bookStorePage;



    public MainPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
        PageFactory.initElements(driver,this);
    }

    public void openPage(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }



}
