import Page.SearchPage;
import Hook.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestSearchPage {

    public Driver driver;
    public SearchPage searchPage;

    @Before
    public void init(){
        driver = new Driver();
        searchPage = new SearchPage(driver.getDriver());
        driver.setUrl("https://www.google.by/");
    }

    @After
    public void close(){
        driver.tearDown();
    }

    @Test
    public void searchTest() throws InterruptedException {
        searchPage.typeTextIntoField("Selenium");
        searchPage.submit();
        driver.delay(8000L);
    }



}
