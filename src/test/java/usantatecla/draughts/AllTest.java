package usantatecla.draughts;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        usantatecla.draughts.models.AllTest.class,
        usantatecla.draughts.views.AllTest.class,
        usantatecla.draughts.controllers.AllTests.class,
        usantatecla.draughts.models.AllModelTestsDG.class,
        usantatecla.draughts.views.AllViewTestsDG.class
})

public class AllTest {

}
