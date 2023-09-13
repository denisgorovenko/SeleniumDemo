import Page.SearchPage;
import Hook.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestSearchPage {

    public SearchPage searchPage;

    @Before
    public void init(){
        searchPage = new SearchPage(Driver.getDriver());
        Driver.setUrl("https://www.google.by/");
    }

    @After
    public void close(){
        Driver.tearDown();
    }

    @Test
    public void searchTest() throws InterruptedException {
        searchPage.typeTextIntoField("Selenium");
        searchPage.submit();
        Driver.delay(8);
    }



}
