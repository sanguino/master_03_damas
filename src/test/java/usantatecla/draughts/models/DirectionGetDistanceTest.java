package usantatecla.draughts.models;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DirectionGetDistanceTest {

    @Test
    public void givenDistanceWhenGetDistanceCoordinateThenReturnsCorrectCoordinate () {
        assertThat(Direction.NE.getDistanceCoordinate(5), is(equalTo(new Coordinate(5, 5))));
        assertThat(Direction.SE.getDistanceCoordinate(3), is(equalTo(new Coordinate(-3, 3))));
        assertThat(Direction.SW.getDistanceCoordinate(6), is(equalTo(new Coordinate(-6, -6))));
        assertThat(Direction.NW.getDistanceCoordinate(1), is(equalTo(new Coordinate(1, -1))));
    }

    @Test
    public void givenNegativeDistanceWhenGetDistanceCoordinateThenReturnsCorrectCoordinate () {
        assertThat(Direction.NW.getDistanceCoordinate(-3), is(equalTo(new Coordinate(-3, 3))));
    }

    @Test
    public void givenZeroDistanceWhenGetDistanceCoordinateThenReturnsZeroZero () {
        assertThat(Direction.NW.getDistanceCoordinate(0), is(equalTo(new Coordinate(0, 0))));
    }
}
