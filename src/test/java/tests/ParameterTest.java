/* Parametrizuj, návrat Optimusa */
/* Budeme mit jeden test ktery spustime tolikrak kolik budeme mit vstupnich parametru */

package tests;

import base.TestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Arrays;
import java.util.List;

/* vytvorime anotacii */
@RunWith(Parameterized.class)
public class ParameterTest extends TestBase {
    int number;
    String expectedPrime;

    /* vytvorime anotacii */
    @Parameterized.Parameters
    /* vytvorime statickou metodu ktera nam vraci list objektu*/
    public static List<Object[]> getData() {
        return Arrays.asList(new Object[][]{{1,"true"}, {2,"true"}, {56,"false"}, {85,"false"}});
    }
    /*
    Vytvorime konstruktor ktery vezme hodnoty a priradi je do int number a do expectedPrime;
    Poté se k němu muže dostat náš test testOptimusUsingParameters
    */
    public ParameterTest(int number, String expectedPrime) {
        this.number = number;
        this.expectedPrime = expectedPrime;
    }

    @Test
    public void testOptimusUsingParameters() {
        getDriver().get(BASE_URL + "primenumber.php");
        WebElement numberInput = getDriver().findElement(By.xpath("//input[@type='number']"));
        WebElement button = getDriver().findElement(By.cssSelector("button.btn"));

            /* akce ktere provadime */
            numberInput.clear();
            numberInput.sendKeys(String.valueOf(number));
            button.click();
            /* ocekavany vysledek */
            checkResult(expectedPrime);

    }
    private void checkResult(String expectedPrime) {
        if (Boolean.valueOf(expectedPrime)) {
            /* kontrolujeme zda se objevi spravna hlaska */
            new WebDriverWait(getDriver(),5)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Optimus approves']")));
        } else {
            new WebDriverWait(getDriver(),5)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Optimus is sad']")));
        }
    }
}
