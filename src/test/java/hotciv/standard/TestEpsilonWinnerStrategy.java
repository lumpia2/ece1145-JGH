package hotciv.standard;

import hotciv.framework.*;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class TestEpsilonWinnerStrategy {

    private Game game;

    @Before
    public void setUp() {
        game = new GameImpl(new EpsilonCivFactory());
    }

    @Test
    public void threeWinsWins() {
        Utility2.incrementWinner((GameImpl)game, Player.RED);
        Utility2.incrementWinner((GameImpl)game, Player.RED);
        Utility2.incrementWinner((GameImpl)game, Player.RED);

        assertThat(game.getWinner(), is(Player.RED));
    }

    @Test
    public void firstToThreeWinsWins() {
        Utility2.incrementWinner((GameImpl)game, Player.RED);
        Utility2.incrementWinner((GameImpl)game, Player.RED);
        Utility2.incrementWinner((GameImpl)game, Player.RED);
        Utility2.incrementWinner((GameImpl)game, Player.BLUE);
        Utility2.incrementWinner((GameImpl)game, Player.BLUE);
        Utility2.incrementWinner((GameImpl)game, Player.BLUE);

        assertThat(game.getWinner(), is(Player.RED));
    }
}