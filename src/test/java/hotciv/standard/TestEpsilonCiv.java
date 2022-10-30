package hotciv.standard;

import hotciv.framework.*;

import org.junit.*;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.*;

public class TestEpsilonCiv {

    private Game game;

    @Before
    public void setUp() {
        game = new GameImpl(new EpsilonCivFactory());
    }

    @Test
    public void testRedArcherWins() {
        game.moveUnit(new Position(4,3), new Position(2,1));
        assertThat(game.moveUnit(new Position(2, 0), new Position(3, 2)), is(true));
    }

}