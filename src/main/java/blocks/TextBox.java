package blocks;

import hook.BaseClass;
import hook.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class TextBox  extends BaseClass{

    @FindBy(id = "userName")
    private WebElement userName;

    @FindBy(id = "userEmail")
    private WebElement email;

    @FindBy(id = "currentAddress")
    private WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    private WebElement permanentAddress;

    @FindBy(id = "submit")
    private WebElement submitBtn;

    public TextBox(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
        PageFactory.initElements(driver,this);
    }


    public TextBox fillFields(String userName, String email, String currentAddress, String permanentAddress){
        this.userName.sendKeys(userName);
        this.email.sendKeys(email);
        this.currentAddress.sendKeys(currentAddress);
        this.permanentAddress.sendKeys(permanentAddress);
        return this;
    }

    public TextBox clickSubmit(){
        submitBtn.click();
        return this;
    }

    public List<String> getOutputInfo(){
        List<String> list = new ArrayList<>();
        List<WebElement> values = driver.findElements(By.cssSelector(".mb-1, .my-1"));
             for(WebElement items : values){
                 String[] itemsText = items.getText().split(":");
                 list.add(itemsText[1]);
             }
        return list;
    }
}
