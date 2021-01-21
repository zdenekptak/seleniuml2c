/* Práve si pochopil statické premenné, -> BeforeClass, AfterClass */

package tests;

import base.TestBase;
import categories.ReleaseTest;
import categories.SmokeTest;
import com.google.code.tempusfugit.concurrency.ConcurrentTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/* Pomoci tohoto radku spustim vsechny radky najednou */
@RunWith(ConcurrentTestRunner.class)
public class DummyTest extends TestBase {
    /* definovani promenne numberOfFailedTests */
    static int numberOfFailedTests;
    /* premenna instance */
    int failed = 0;

    /* metoda ktera se vykona pred vsemi testami */
    /* staticka metoda - je vazana na kontretni tridu */
    @BeforeClass
    public static void setUpClass() {
        System.out.println("setupClass");
        /* inicializace promenne numberOfFailedTests */
        numberOfFailedTests = 0;
    }

    /* vytvoreni kategorie testu */
    @Category(SmokeTest.class)
    @Test
    public void testA() {
        getDriver().get(BASE_URL + "waitforit.php");
        System.out.println("A");
        System.out.println("Static " + numberOfFailedTests);
        failed++;
        System.out.println("Failed " + failed);
    }
    @Category({SmokeTest.class, ReleaseTest.class})
    @Test
    public void testB() {
        getDriver().get(BASE_URL + "waitforit.php");
        System.out.println("B");
        numberOfFailedTests = numberOfFailedTests + 1;
        System.out.println("Static " + numberOfFailedTests);
        failed = 10;
        System.out.println("Failed " + failed);
    }
    @Category(ReleaseTest.class)
    @Test
    public void testC() {
        getDriver().get(BASE_URL + "waitforit.php");
        System.out.println("C");
        System.out.println("Static " + numberOfFailedTests);
        System.out.println("Failed " + failed);
    }
}
