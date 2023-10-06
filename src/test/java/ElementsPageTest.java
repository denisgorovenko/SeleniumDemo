import blocks.TextBox;
import hook.Driver;
import org.junit.Assert;
import page.ElementsPage;
import page.MainPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


@DisplayName("Elements page")
public class ElementsPageTest {

    public MainPage mainPage ;
    public ElementsPage elementsPage;
    public TextBox textBox;
    public final String URL = "https://demoqa.com/";
    @Before
    @DisplayName("Init driver")
    public void init(){
        Driver.intDriver();
        Driver.setURL(URL);
        mainPage = new MainPage(Driver.driver,Driver.webDriverWait);
        mainPage.openPage(mainPage.elementPage);
        elementsPage = new ElementsPage(Driver.driver,Driver.webDriverWait);
        textBox = new TextBox(Driver.driver,Driver.webDriverWait);
    }

    @Test
    @DisplayName("Testing check box field")
    @Severity(SeverityLevel.MINOR)
    public void textBoxField()  {
        elementsPage.collapseGroupElement("Elements");
        elementsPage.selectGroupItem("Text Box");
        textBox.fillFields("test","test@mail.com","test","test").clickSubmit();
        Assert.assertEquals("test",textBox.getOutputInfo().get(0));
        Assert.assertEquals("test@mail.com",textBox.getOutputInfo().get(1));
        Assert.assertEquals("test",textBox.getOutputInfo().get(2));
        Assert.assertEquals("test",textBox.getOutputInfo().get(3));
    }

    @After
    public void close(){
        Driver.tearDown();
    }
}
