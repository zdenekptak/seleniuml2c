/* Vytvárame objekt hriechu / Sin City */
/* Posielame objekt hriechu do metódy */
/* Zoznam tagov, vytvárame objekt v objekte */

package tests;

import base.TestBase;
import models.Sin;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class SinCityTest extends TestBase {

    @Test
    public void testNewSin() {
        getDriver().get(BASE_URL + "/sincity.php");
        /* vytvorime objekt spiderSin */
        Sin spiderSin = new Sin("Zabil jsem pavouka", "Zdenek", "Zabil jsem pistoli");

        /* vytvorime objekt spiderSinTags */
        List<String> spiderSinTags = new ArrayList<String>();
        /* do seznamu spiderSinTags pridame hodnoty pomoci .add (priradime co chceme zaskrtnout) */
        spiderSinTags.add("murder");
        spiderSinTags.add("hijack");

        /* spiderSin nastavime tagy z spiderSinTags */
        spiderSin.setTags(spiderSinTags);

        /* vyplnime sin metodoou fillSinInformation */
        fillSinInformation(spiderSin);

        /* tagy pomoci markTag */
        markTag(spiderSin.getTags());
    }

    //    /* vytvorime metodu pro zadani hrichu, ktera prijima 3 parametry */
//    private void fillSinInformation(String title, String author, String message) {
//        driver.findElement(By.name("title")).sendKeys(title);
//        driver.findElement(By.name("author")).sendKeys(author);
//        driver.findElement(By.name("message")).sendKeys(message);
//    }
    /* vytvorime metodu pro zadani hrichu, ktera bude potrebovat jen jeden parametr Sin */
    /* k hodnotam pristupujeme pomoci getter (getTitle, getAuthor,...) */
    private void fillSinInformation(Sin sin) {
        getDriver().findElement(By.name("title")).sendKeys(sin.getTitle());
        getDriver().findElement(By.name("author")).sendKeys(sin.getAuthor());
        getDriver().findElement(By.name("message")).sendKeys(sin.getMessage());
    }

    private void markTag(List<String> tags) {
        for (String tag : tags) {
            getDriver().findElement(By.xpath("//input[@value='" + tag + "']")).click();
        }
    }

}
