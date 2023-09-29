package Page;


import Hook.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BaseClass {


    @FindBy(xpath = "//div[@class = 'card mt-4 top-card'][1]")
    public WebElement elementPage;
    public WebElement formsPage;
    public WebElement alertFramePage;
    public WebElement widgetsPage;
    public WebElement interactionsPage;
    public WebElement bookStorePage;


    public MainPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
        PageFactory.initElements(driver,this);
    }

}
