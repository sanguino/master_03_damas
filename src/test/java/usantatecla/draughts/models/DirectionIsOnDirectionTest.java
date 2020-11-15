package usantatecla.draughts.models;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DirectionIsOnDirectionTest {

    @Parameter(0) public int row;
    @Parameter(1) public int column;
    @Parameter(2) public boolean isNE;
    @Parameter(3) public boolean isSE;
    @Parameter(4) public boolean isSW;
    @Parameter(5) public boolean isNW;

    private Coordinate coordinate;

    @Parameters(name="{index}: [{0}, {1}]")
    public static Collection<Object[]> data() {
        return Arrays
                .asList(new Object[][]{
                        {3, 3, true, false, false, false},
                        {-3, 3, false, true, false, false},
                        {-3, -3, false, false, true, false},
                        {3, -3, false, false, false, true},

                        {1, 2, false, false, false, false},
                        {0, 1, false, false, false, false},
                        {0, 0, false, false, false, false}
                });
    }

    @Before
    public void before() {
        coordinate = new Coordinate(row, column);
    }

    @Test
    public void givenCoordinateWhenIsOnDirectionThenReturnsCorrectly () {
        assertThat(Direction.NE.isOnDirection(coordinate), is(isNE));
        assertThat(Direction.SE.isOnDirection(coordinate), is(isSE));
        assertThat(Direction.SW.isOnDirection(coordinate), is(isSW));
        assertThat(Direction.NW.isOnDirection(coordinate), is(isNW));
    }

}
