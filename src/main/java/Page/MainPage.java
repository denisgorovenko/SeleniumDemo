package Page;


import Hook.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BaseClass {


    @FindBy(xpath = "//div[@class = 'card mt-4 top-card'][1]")
    private WebElement elementPage;
    private WebElement formsPage;
    private WebElement alertFramePage;
    private WebElement widgetsPage;
    private WebElement interactionsPage;
    private WebElement bookStorePage;


    public MainPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
        PageFactory.initElements(driver,this);
    }

    public void openElementPage() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", elementPage);
    }
}
