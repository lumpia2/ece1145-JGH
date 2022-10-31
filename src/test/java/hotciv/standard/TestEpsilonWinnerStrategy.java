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
        EpsilonCivMoveUnitStrategy.incrementWinner((GameImpl)game, Player.RED);
        EpsilonCivMoveUnitStrategy.incrementWinner((GameImpl)game, Player.RED);
        EpsilonCivMoveUnitStrategy.incrementWinner((GameImpl)game, Player.RED);

        assertThat(game.getWinner(), is(Player.RED));
    }

    @Test
    public void firstToThreeWinsWins() {
        EpsilonCivMoveUnitStrategy.incrementWinner((GameImpl)game, Player.RED);
        EpsilonCivMoveUnitStrategy.incrementWinner((GameImpl)game, Player.RED);
        EpsilonCivMoveUnitStrategy.incrementWinner((GameImpl)game, Player.RED);
        EpsilonCivMoveUnitStrategy.incrementWinner((GameImpl)game, Player.BLUE);
        EpsilonCivMoveUnitStrategy.incrementWinner((GameImpl)game, Player.BLUE);
        EpsilonCivMoveUnitStrategy.incrementWinner((GameImpl)game, Player.BLUE);

        assertThat(game.getWinner(), is(Player.RED));
    }
}