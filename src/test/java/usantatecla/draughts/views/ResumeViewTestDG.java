package usantatecla.draughts.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.utils.Console;
import usantatecla.draughts.utils.YesNoDialog;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ResumeViewTestDG {

    @Mock
    private YesNoDialog yesNoDialog;

    @Mock
    private ResumeController resumeController;

    @InjectMocks
    private View view;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testResetGame() {

        when(this.yesNoDialog.read(anyString())).thenReturn(true);
        view.visit(resumeController);
        verify(resumeController).reset();

    }

    @Test
    public void testFinishGame() {

        when(this.yesNoDialog.read(anyString())).thenReturn(false);
        view.visit(resumeController);
        verify(resumeController).next();

    }

}
