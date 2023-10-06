package hook;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v117.network.Network;
import org.openqa.selenium.devtools.v117.network.model.RequestId;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Optional;

public class Driver {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    private static DevTools devTools;

    public static void intDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(10));
     }

     public static void setURL(String url){
        driver.get(url);
     }

     public static void delay(Integer second)  {
         try {
             Thread.sleep(second*1000);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
     }

     public static void tearDown(){
        driver.close();
     }

     public static String getCurrentUrl(){
        return driver.getCurrentUrl();
     }

     public static void getLogs() {
         DevTools devTools = ((HasDevTools)driver).getDevTools();
         RequestId[] requestIds = new RequestId[1];
         devTools.createSession();
         devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
         devTools.addListener(
                 Network.responseReceived(),
                 response -> {
                         if(response.getType().toString().equals("Script")) {
                             requestIds[0] = response.getRequestId();
                             if(devTools.send(Network.getResponseBody(requestIds[0])).getBody().contains("Minification")){
                                 System.out.println(response.getResponse().getUrl());
                             }
                         }
                 }
         );
     }
}
