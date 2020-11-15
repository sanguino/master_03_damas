package usantatecla.draughts.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ColorTest.class,
        DirectionGetDistanceTest.class,
        DirectionIsOnDirectionTest.class,
        PieceTest.class,
        StateTest.class,
        TurnTest.class,
        CoordinateTest.class,
        GameTest.class
})
public class AllTest {

}
