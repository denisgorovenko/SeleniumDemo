package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage  extends PageFactory {

    @FindBy(name = "q")
    public WebElement searchField;

    public SearchPage(WebDriver driver){
           initElements(driver , this);
    }

    public void typeTextIntoField(String text){
        searchField.sendKeys(text);
    }

    public void submit(){
        searchField.submit();
    }

}
