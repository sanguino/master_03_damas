package usantatecla.draughts.views;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import usantatecla.draughts.controllers.StartController;
import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.GameBuilder;
import usantatecla.draughts.models.State;
import usantatecla.draughts.utils.Console;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class GameViewTest {
    @Mock
    Console console;
    @InjectMocks
    View view;
    @Captor
    ArgumentCaptor<String> argument;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGivenGameViewWhenInteractThenOk() {
        Game game = new GameBuilder().initialBoard().build();
        StartController startController = new StartController(game, new State());
        this.view.write(startController);
        verify(this.console, atLeastOnce()).write(this.argument.capture());
        List<String> board = Arrays.asList(
                " 12345678",
                "1 n n n n",
                "2n n n n ",
                "3 n n n n",
                "4        ",
                "5        ",
                "6b b b b ",
                "7 b b b b",
                "8b b b b ",
                " 12345678"
        );

        List<String> captured = this.argument.getAllValues();
        for(int i = 0; i < captured.size(); i++) {
            assertEquals(board.get(i / 9).charAt(i%9), captured.get(i).charAt(0));
        }
    }

}
