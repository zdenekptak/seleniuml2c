/* Ignorant! D8v8me test do karanteny */

package tests;

import base.TestBase;
import categories.SmokeTest;
import com.google.code.tempusfugit.concurrency.RepeatingRule;
import com.google.code.tempusfugit.concurrency.annotations.Repeating;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WaitForItTest extends TestBase {
    /* pomoci Rule definujeme pravidlo */
    @Rule
    /* v ramci nasich testu budu ocekavat nejaku vyjimku(Exception) */
    public ExpectedException expectedException = ExpectedException.none();
    /* Opakovane spousteni jednoho testu */
//    public RepeatingRule rule = new RepeatingRule();

    private static int counter = 0;

    @Category(SmokeTest.class)
    @Test
//    @Repeating(repetition = 5)
    public void checkTitle() {
        getDriver().get(BASE_URL + "waitforit.php");
        /* nastavime si jakou ocekavame vyjimku (vyjimka bude tridy ComparisonFailure.class) */
        expectedException.expect(ComparisonFailure.class);
        /* nastavime ocekavanu zpravu .expectMessage*/
        expectedException.expectMessage("Nesedi titulek");
        /* zprava se nastavi pred ocekavanou hodnotou */
        Assert.assertEquals("Nesedi titulek","WAIT FOR IT !!!", getDriver().findElement(By.xpath("//h1")).getText());
        counter++;
    }
    @Test
    /* @Ignore zadame kdyz chceme nejaky test preskocit, ale chceme ho pocitat do statistik */
    /*  */
    @Ignore
    public void checkLegendary() {
        getDriver().get(BASE_URL + "waitforit.php");
        getDriver().findElement(By.id("startWaitForText")).click();
        System.out.println(getDriver().findElement(By.id("waitForTextInput")).getAttribute("value"));
        new WebDriverWait(getDriver(),5)
                .until(ExpectedConditions.attributeToBe(getDriver().findElement(By.id("startWaitForText")), "value", "dary !!!"));
        Assert.assertEquals("dary !!!", getDriver().findElement(By.id("waitForTextInput")).getAttribute("value"));
    }
}
