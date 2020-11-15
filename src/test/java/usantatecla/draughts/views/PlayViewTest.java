package usantatecla.draughts.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import usantatecla.draughts.controllers.PlayController;
import usantatecla.draughts.models.Color;
import usantatecla.draughts.models.Coordinate;
import usantatecla.draughts.utils.Console;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayViewTest {
    @Mock
    PlayController playController;
    @Mock
    Console console;
    @InjectMocks
    PlayView playView;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenPlayViewWhenInteractEmptyThenError() {
        when(this.playController.getColor()).thenReturn(Color.BLACK);
        when(this.console.readString(ArgumentMatchers.any())).thenReturn("").thenReturn("-1");
        this.playView.interact(this.playController);
        verify(this.console).writeln("Error!!! Formato incorrecto");
    }

    @Test
    public void givenPlayViewWhenInteractBadFormatThenError() {
        when(this.playController.getColor()).thenReturn(Color.BLACK);
        when(this.console.readString(ArgumentMatchers.any())).thenReturn("B2.A1").thenReturn("-1");
        this.playView.interact(this.playController);
        verify(this.console).writeln("Error!!! Formato incorrecto");
    }

    @Test
    public void givenPlayViewWhenInteractDimensionExceedThenError() {
        when(this.playController.getColor()).thenReturn(Color.BLACK);
        when(this.console.readString(ArgumentMatchers.any())).thenReturn("92.01").thenReturn("-1");
        this.playView.interact(this.playController);
        verify(this.console).writeln("Error!!! Formato incorrecto");
    }

    @Test
    public void givenPlayViewWhenInteractLostThenError() {
        when(this.playController.getColor()).thenReturn(Color.BLACK);
        when(this.playController.isBlocked()).thenReturn(true);
        when(this.console.readString(ArgumentMatchers.any())).thenReturn("11.22");
        this.playView.interact(this.playController);
        verify(this.console).writeln("Derrota!!! No puedes mover tus fichas!!!");
    }

    @Test
    public void givenPlayViewWhenInteractMinusOneThenCancel() {
        when(this.playController.getColor()).thenReturn(Color.BLACK);
        when(this.console.readString(ArgumentMatchers.any())).thenReturn("-1");
        this.playView.interact(this.playController);
        verify(this.playController).cancel();
    }

    @Test
    public void givenPlayViewWhenInteractCorrectlyThenMoveCalled() {
        when(this.playController.getColor()).thenReturn(Color.BLACK);
        when(this.console.readString(ArgumentMatchers.any())).thenReturn("12.34");
        this.playView.interact(this.playController);
        verify(this.playController).move(
                new Coordinate(0,1),
                new Coordinate(2,3)
        );

    }

    @Test
    public void givenPlayViewWhenInteractCorrectlyMultipleThenMoveCalled() {
        when(this.playController.getColor()).thenReturn(Color.BLACK);
        when(this.console.readString(ArgumentMatchers.any())).thenReturn("12.34.56.78");
        this.playView.interact(this.playController);
        verify(this.playController).move(
                new Coordinate(0,1),
                new Coordinate(2,3),
                new Coordinate(4,5),
                new Coordinate(6,7)
        );
    }
}
