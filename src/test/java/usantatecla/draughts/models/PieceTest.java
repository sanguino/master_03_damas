package usantatecla.draughts.models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PieceTest {


    @Test
    public void givenPieceWhenIsLimitThenReturnTrue () {
        Coordinate coordinateHigh = new Coordinate(0, 1);
        Coordinate coordinateLow = new Coordinate(7, 1);
        assertTrue(new Pawn(Color.BLACK).isLimit(coordinateLow));
        assertTrue(new Pawn(Color.WHITE).isLimit(coordinateHigh));
    }

    @Test
    public void givenPieceWhenIsLimitThenReturnFalse () {
        Coordinate coordinateHigh = new Coordinate(0, 1);
        Coordinate coordinateLow = new Coordinate(7, 1);
        Coordinate coordinateOne = new Coordinate(1, 1);
        Coordinate coordinateSix = new Coordinate(6, 1);
        assertFalse(new Pawn(Color.BLACK).isLimit(coordinateHigh));
        assertFalse(new Pawn(Color.WHITE).isLimit(coordinateLow));
        assertFalse(new Pawn(Color.BLACK).isLimit(coordinateOne));
        assertFalse(new Pawn(Color.WHITE).isLimit(coordinateSix));
    }

    @Test
    public void givenPieceWhenIsAdvancedThenReturnTrue () {
        Coordinate coordinateHigh = new Coordinate(1, 1);
        Coordinate coordinateLow = new Coordinate(5, 1);
        assertTrue(new Pawn(Color.WHITE).isAdvanced(coordinateLow, coordinateHigh));
        assertTrue(new Pawn(Color.BLACK).isAdvanced(coordinateHigh, coordinateLow));
    }

    @Test
    public void givenPieceWhenIsAdvancedThenReturnFalse () {
        Coordinate coordinateHigh = new Coordinate(1, 1);
        Coordinate coordinateLow = new Coordinate(5, 1);
        assertFalse(new Pawn(Color.BLACK).isAdvanced(coordinateLow, coordinateHigh));
        assertFalse(new Pawn(Color.WHITE).isAdvanced(coordinateHigh, coordinateLow));
        assertFalse(new Pawn(Color.BLACK).isAdvanced(coordinateHigh, coordinateHigh));
        assertFalse(new Pawn(Color.WHITE).isAdvanced(coordinateLow, coordinateLow));
    }
}
