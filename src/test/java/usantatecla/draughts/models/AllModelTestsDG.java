package usantatecla.draughts.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        CoordinateTestDG.class,
        DirectionTestDG.class,
        DraughtTestDG.class,
        GameTestDG.class,
        PawnTestDG.class,
        StateTestDG.class,
        TurnTestDG.class
})
public class AllModelTestsDG {
}
