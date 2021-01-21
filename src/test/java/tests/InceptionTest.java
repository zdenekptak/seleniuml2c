package tests;

import base.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InceptionTest extends TestBase {

    @Test
    public void testDeeper() throws InterruptedException {
        getDriver().get(BASE_URL + "inception.php");
        /* ulozime si uvodni okno */
        String parentWindow = getDriver().getWindowHandle();
        System.out.println(parentWindow);
        getDriver().findElement(By.id("letsGoDeeper")).click();
        /* .numberOfWindowsToBe() - pocka na to ze okna budou 2 */
        new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.numberOfWindowsToBe(2));
        /* .getWindowHandles() - ziskame hashove oznaceni oken a pomoci for cyklu jimi projdeme */
        getDriver().getWindowHandles();
        for (String windowHandle : getDriver().getWindowHandles()) {
            /* prepnuti do jineho okna */
            System.out.println(windowHandle);
            getDriver().switchTo().window(windowHandle);
        }
        getDriver().findElement(By.xpath("//input[1]")).sendKeys("Sangala je nevinny");
        Thread.sleep(3000);
        /* zavereme otvrene okno a vratime se do uvodniho */
        getDriver().close();
        /* prepnuti do jineho okna */
        getDriver().switchTo().window(parentWindow);
        getDriver().findElement(By.id("letsGoDeeper")).click();

    }

}
