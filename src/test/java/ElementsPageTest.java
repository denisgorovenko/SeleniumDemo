import Hook.Driver;
import Page.MainPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElementsPageTest {

    @Before
    @DisplayName("Init driver")
    public void init(){
        Driver.intDriver();
        Driver.setURL("https://demoqa.com/");
    }

    @Test
    @DisplayName("Open elements page")
    @Severity(SeverityLevel.MINOR)
    public void testPage(){
        MainPage mainPage = new MainPage(Driver.driver,Driver.webDriverWait);
        mainPage.openElementPage();
        Driver.delay(10);
    }


    @After
    public void close(){
        Driver.tearDown();
    }
}
