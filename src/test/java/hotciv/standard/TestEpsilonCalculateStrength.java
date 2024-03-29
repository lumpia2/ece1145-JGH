package hotciv.standard;

import hotciv.framework.*;

import hotciv.standard.factories.EpsilonCivFactory;
import hotciv.standard.implementations.GameImpl;
import hotciv.standard.implementations.UnitImpl;
import hotciv.standard.utilities.Utility2;
import org.junit.*;


import static org.junit.Assert.*;

public class TestEpsilonCalculateStrength {

    private Game game;

    @Before
    public void setUp() {
        game = new GameImpl(new EpsilonCivFactory());
    }

    @Test
    public void checkRedArcherValueIs1() {
        assertEquals(Utility2.calculateTotalStrength(new Position(2, 0), game, true), 1);
    }

    @Test
    public void checkRedArcherValueIs2() {
        game.moveUnit(new Position(4,3), new Position(2,1));
        assertEquals(Utility2.calculateTotalStrength(new Position(2, 0), game, true), 2);
    }

    @Test
    public void checkBlueLegionIs2() {
        game.moveUnit(new Position(4,3), new Position(2,1));
        assertEquals(Utility2.calculateTotalStrength(new Position(2, 0), game, true), 2);
    }

    @Test
    public void testTerrainMultiplies2() {
        game.addToWorld(new Position(0,1), new UnitImpl(GameConstants.LEGION, Player.RED));
        game.moveUnit(new Position(4,3), new Position(1,1));
        assertEquals(Utility2.calculateTotalStrength(new Position(0,1), game, true), 4);
    }
}