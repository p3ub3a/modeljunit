package test.java;

import main.java.Game;
import main.java.Player;

public class GameAdapter {
    private Game game = new Game();
    private Player player = new Player();

    public void win(){
        player.win(game);
    }

    public void lose(){
        player.lose(game);
    }

    public void start(){
        player.start(game);
    }

    public void pause(){
        player.pause(game);
    }

    public void resume(){
        player.resume(game);
    }
}
