package usantatecla.draughts.models;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StateTest {

    @Test
    public void givenNewStateWhenContructedThenStateValuesIsINITIAL () {
        assertThat(new State().getValueState(), is(StateValue.INITIAL));
    }

    @Test
    public void givenInitialStateWhenNextThenStateValuesIsIN_GAME () {
        State state = new State();
        state.next();
        assertThat(state.getValueState(), is(StateValue.IN_GAME));
    }

    @Test (expected = AssertionError.class)
    public void givenExitStateWhenNextThenThrowException () {
        State state = new State();
        state.next();
        state.next();
        state.next();
        state.next();
    }
}
