/* Spúšťaj si testy podľa kategórie */
/* Pomoci teto tridy spustim vsechny smoke testy */
package suites;

import categories.SmokeTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.DummyTest;
import tests.WaitForItTest;

@RunWith(Categories.class)
/* vypiseme jakou kategorii testu mam na mysli SmokeTest.class */
@Categories.IncludeCategory(SmokeTest.class)
/* definujeme si vsechny testy ktere chceme spustit */
@Suite.SuiteClasses({
        DummyTest.class,
        WaitForItTest.class
})
public class SmokeTestSuite {
}
