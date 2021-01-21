package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSingelton {
    /* staticka promenna která bude náš driver */
    private static WebDriver driver;

    /* metoda intitialize() ktera mi driver inicializije */
    private static void intitialize() {
        driver = new FirefoxDriver();
    }

    /* metoda ktera vrati instanci teto tridy */
    public static WebDriver getWebdriverInstance() {
        if (driver == null) {
            intitialize();
        }
        return driver;
    }
}
