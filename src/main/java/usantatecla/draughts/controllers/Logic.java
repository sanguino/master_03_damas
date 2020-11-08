package usantatecla.draughts.controllers;

import usantatecla.draughts.models.Game;
import usantatecla.draughts.models.State;
import usantatecla.draughts.models.StateValue;

import java.util.HashMap;
import java.util.Map;

public class Logic {

    private Game game;
    private State state;
    private Map<StateValue, InteractorController> controllers;

    public Logic() {
        this.game = new Game();
        this.state = new State();
        this.controllers = new HashMap<StateValue, InteractorController>();
        this.controllers.put(StateValue.INITIAL, new StartController(this.game, this.state));
        this.controllers.put(StateValue.IN_GAME, new PlayController(this.game, this.state));
        this.controllers.put(StateValue.FINAL, new ResumeController(this.game, this.state));
        this.controllers.put(StateValue.EXIT, null);
    }

    public InteractorController getController() {
        return this.controllers.get(this.state.getValueState());
    }

}
