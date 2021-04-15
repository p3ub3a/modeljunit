package test.java;

import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;

public class GameModel implements FsmModel {
    private GameAdapter gameAdapter = new GameAdapter();
    private enum State {Running, Over, Paused}

    private State state = State.Over;

    public Object getState(){
        return state;
    }

    public void reset(boolean b){
        state = State.Over;
    }

    public boolean winGuard(){
        return state == State.Running;
    }
    @Action
    public void win(){
        gameAdapter.win();
        state = State.Over;
    }

    public boolean loseGuard(){
        return state == State.Running;
    }
    @Action
    public void lose(){
        gameAdapter.lose();
        state = State.Over;
    }

    public boolean startGuard(){
        return state == State.Over;
    }
    @Action
    public void start(){
        gameAdapter.start();
        state = State.Running;
    }

    public boolean pauseGuard(){
        return state == State.Running;
    }
    @Action
    public void pause(){
        gameAdapter.pause();
        state = State.Paused;
    }

    public boolean resumeGuard(){
        return state == State.Paused;
    }
    @Action
    public void resume(){
        gameAdapter.resume();
        state = State.Running;
    }
}
