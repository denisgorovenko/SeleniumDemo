import hook.Driver;
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
    public final String URL = "https://demoqa.com/";
    @Before
    @DisplayName("Init driver")
    public void init(){
        Driver.intDriver();
        Driver.setURL(URL);
        mainPage = new MainPage(Driver.getDriver(),Driver.webDriverWait);
        mainPage.openPage(mainPage.elementPage);
        elementsPage = new ElementsPage(Driver.getDriver(),Driver.webDriverWait);
    }

    @Test
    @DisplayName("Testing check box field")
    @Severity(SeverityLevel.MINOR)
    public void testPage()  {
        elementsPage.collapseGroupElement("Elements");
        elementsPage.selectGroupItem("Text Box");
        Driver.delay(3);
    }

    @After
    public void close(){
        Driver.tearDown();
    }
}
