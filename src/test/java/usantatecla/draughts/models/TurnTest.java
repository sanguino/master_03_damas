package usantatecla.draughts.models;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TurnTest {

    @Test
    public void givenNewTurnWhenGetColorThenIsWhite () {
        assertThat(new Turn().getColor(), is(Color.WHITE));
    }

    @Test
    public void givenNewTurnWhenChangeThenGetColorIsBlack () {
        Turn turn = new Turn();
        turn.change();
        assertThat(turn.getColor(), is(Color.BLACK));
    }
}
