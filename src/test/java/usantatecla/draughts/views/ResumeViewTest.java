package usantatecla.draughts.views;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import usantatecla.draughts.controllers.ResumeController;
import usantatecla.draughts.utils.YesNoDialog;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ResumeViewTest {
    @Mock
    ResumeController resumeController;
    @Mock
    YesNoDialog yesNoDialog;
    @InjectMocks
    View view;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenResumeViewWhenInteractYesThenReset () {
        when(this.yesNoDialog.read(ArgumentMatchers.any())).thenReturn(true);
        this.view.visit(this.resumeController);
        verify(this.resumeController).reset();
    }

    @Test
    public void givenResumeViewWhenInteractYesThenNext () {
        when(this.yesNoDialog.read(ArgumentMatchers.any())).thenReturn(false);
        this.view.visit(this.resumeController);
        verify(this.resumeController).next();
    }

}
