package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
    /* Singelton - na jeden test potrebuju jenom jeden driver */
    /* Singelton - vytvori prave jednu instanci danne tridy */

//    private WebDriver driver;
    public static final String BASE_URL = "http://localhost:81/";

    @Before
    public void setUp() {
//        driver = new FirefoxDriver();
    }
    @After
    public void tearDown() {
//        driver.close();
//        driver.quit();
        WebDriverSingelton.getWebdriverInstance();
        WebDriverSingelton.getWebdriverInstance();
    }

    public WebDriver getDriver() {
        return WebDriverSingelton.getWebdriverInstance();
    }

}
