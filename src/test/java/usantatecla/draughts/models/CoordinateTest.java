package usantatecla.draughts.models;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class CoordinateTest {

    @Test
    public void givenInnerCoordinateWhenIsLastThenReturnFalse () {
        assertFalse(new Coordinate(5, 8).isLast());
    }

    @Test
    public void givenEightRowCoordinateWhenIsLastThenReturnTrue () {
        assertTrue(new Coordinate(7, 3).isLast());
    }

    @Test
    public void givenInnerCoordinateWhenIsFirstThenReturnFalse () {
        assertFalse(new Coordinate(5, 8).isFirst());
    }

    @Test
    public void givenZeroRowCoordinateWhenIsFirstThenReturnTrue () {
        assertTrue(new Coordinate(0, 3).isFirst());
    }

    @Test
    public void givenWhiteCoordinateWhenIsBlackThenReturnFalse () {
        assertFalse(new Coordinate(5, 3).isBlack());
        assertFalse(new Coordinate(1, 1).isBlack());
        assertFalse(new Coordinate(0, 0).isBlack());
    }

    @Test
    public void givenBlackCoordinateWhenIsBlackThenReturnTrue () {
        assertTrue(new Coordinate(5, 2).isBlack());
        assertTrue(new Coordinate(2, 1).isBlack());
        assertTrue(new Coordinate(0, 1).isBlack());
    }

    @Test
    public void givenLevelWhenGetDiagonalCoordinatesReturnListDiagonalCoordinates () {
        assertThat(new Coordinate(0, 0).getDiagonalCoordinates(1), containsInAnyOrder(new Coordinate(1,1)));
        assertThat(new Coordinate(0, 0).getDiagonalCoordinates(2), containsInAnyOrder(new Coordinate(2,2)));

        assertThat(new Coordinate(0, 2).getDiagonalCoordinates(1), containsInAnyOrder(
                new Coordinate(1,3),
                new Coordinate(1,1)
        ));

        assertThat(new Coordinate(3, 3).getDiagonalCoordinates(1), containsInAnyOrder(
                new Coordinate(4,4),
                new Coordinate(4,2),
                new Coordinate(2,4),
                new Coordinate(2,2)
        ));
    }

    @Test
    public void givenCoordinateWhenIsOnDiagonalThenReturnTrue () {
        assertTrue(new Coordinate(4,4).isOnDiagonal(new Coordinate(5,3)));
        assertTrue(new Coordinate(0,0).isOnDiagonal(new Coordinate(1,1)));
    }

    @Test
    public void givenCoordinateWhenIsOnDiagonalThenReturnFalse () {
        assertFalse(new Coordinate(4,4).isOnDiagonal(new Coordinate(5,4)));
        assertFalse(new Coordinate(0,0).isOnDiagonal(new Coordinate(0,0)));
    }
}
