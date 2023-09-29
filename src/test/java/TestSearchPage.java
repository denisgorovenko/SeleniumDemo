import Page.SearchPage;
import Hook.Driver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static Hook.Driver.getDriver;


public class TestSearchPage  {

    public SearchPage searchPage;



    @Before
    public void init(){
        searchPage = new SearchPage(getDriver());
    }

    @AfterClass
    public static void close(){
        Driver.tearDown();
    }

    @Test
    public void searchTest() throws InterruptedException {
        Driver.setUrl("https://www.google.by/");
        searchPage.typeTextIntoField("Selenium");
        searchPage.submit();
    }

    @Test
    public void searchTest1() throws InterruptedException {
        Driver.setUrl("https://www.google.by/");
        searchPage.typeTextIntoField("Allure");
        searchPage.submit();
    }


}
