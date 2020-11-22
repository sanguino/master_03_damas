package usantatecla.draughts.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import usantatecla.draughts.controllers.StartController;
import usantatecla.draughts.utils.Console;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class StartViewTestDG {

    @Mock
    private StartController startController;

    @Mock
    protected Console console;

    @InjectMocks
    private View view;

    @Before
    public void before() {
        initMocks(this);
    }

    @Test
    public void test1() {

        view.visit(startController);

        verify(console).writeln(eq("Draughts"));
        verify(startController).start();

    }
}
