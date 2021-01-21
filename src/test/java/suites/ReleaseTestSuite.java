/* Spúšťaj si testy podľa kategórie */

package suites;

import categories.ReleaseTest;
import categories.SmokeTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.DummyTest;
import tests.WaitForItTest;

@RunWith(Categories.class)
/* vypiseme jakou kategorii testu chceme sputit ReleaseTest.class */
@Categories.IncludeCategory(ReleaseTest.class)
/* cypiseme jake kategorie nechceme spustit */
@Categories.ExcludeCategory(SmokeTest.class)
/* definujeme si vsechny testy ktere chceme spustit */
@Suite.SuiteClasses({
        DummyTest.class,
        WaitForItTest.class
})

public class ReleaseTestSuite {
}
