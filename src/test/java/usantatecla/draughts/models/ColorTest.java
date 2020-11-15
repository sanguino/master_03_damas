package usantatecla.draughts.models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ColorTest {

    @Test
    public void givenAnInitalRowWhenIsInitialRowThenReturnTrue () {
        assertTrue(Color.WHITE.isInitialRow(5));
        assertTrue(Color.BLACK.isInitialRow(2));
    }

    @Test
    public void givenNonInitalRowWhenIsInitialRowThenReturnFalse () {
        assertFalse(Color.WHITE.isInitialRow(2));
        assertFalse(Color.BLACK.isInitialRow(3));
    }
}
