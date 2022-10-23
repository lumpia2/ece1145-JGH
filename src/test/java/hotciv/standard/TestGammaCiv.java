package hotciv.standard;

import hotciv.framework.*;

import org.junit.*;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.*;

public class TestGammaCiv {

    private Game game;

    @Before
    public void setUp() {
        game = new GameImpl(new AlphaAgingStrategy(), new AlphaWinningStrategy(), new AlphaWorldLayoutStrategy(), new GammaCivActionStrategy(), new GammaCivMoveUnitStrategy());
    }

    @Test
    public void settlerActionWorks() {
        game.performUnitActionAt(new Position(4,3));

        assertThat(game.getPlayerInTurn(), is(Player.RED));
        assertThat(game.getCityAt(new Position(4,3)), is(notNullValue()));

        City redCity = game.getCityAt(new Position(4,3));
        assertThat(redCity.getOwner(), is(Player.RED));
    }

    @Test
    public void archerActionWorks() {
        game.performUnitActionAt(new Position(2,0));

        assertThat(game.getPlayerInTurn(), is(Player.RED));
        assertThat(game.moveUnit(new Position(2, 0), new Position(4, 0)), is(false));
        Unit redArcher = game.getUnitAt(new Position(2, 0));
        assertThat(redArcher.getDefensiveStrength(), is(2));

        game.performUnitActionAt(new Position(2,0));
        assertThat(game.moveUnit(new Position(2, 0), new Position(4, 0)), is(true));
    }
}