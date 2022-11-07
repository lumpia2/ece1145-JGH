package hotciv.standard;

import hotciv.framework.*;

import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class TestThetaCiv {
    private Game game;

    @Before
    public void setUp() {
        game = new GameImpl(new ThetaCivFactory());
    }

    @Test
    public void changeProductionToUFO() {
        game.changeProductionInCityAt(new Position(1,1), GameConstants.UFO);
        City redCity = game.getCityAt(new Position(1,1));

        assertEquals(redCity.getProduction(), GameConstants.UFO);
    }

    @Test
    public void checkUFOStrengths() {
        Unit testUFO = new UnitImpl(GameConstants.UFO, Player.RED);

        assertEquals(testUFO.getAttackingStrength(), 1);
        assertEquals(testUFO.getDefensiveStrength(), 8);
    }

    @Test
    public void abductionWorks() {
        Unit testUFO = new UnitImpl(GameConstants.UFO, Player.RED);
        game.addToWorld(new Position(3,3), testUFO);

        assertThat(game.getCityAt(new Position(4,1)), notNullValue());
        game.moveUnit(new Position(3,3), new Position(4,1));
        game.performUnitActionAt(new Position(4,1));
        assertEquals(game.getCityAt(new Position(4,1)), null);
    }

    @Test
    public void deforestation() {
        Unit testUFO = new UnitImpl(GameConstants.UFO, Player.RED);
        game.addToWorld(new Position(3,3), testUFO);
        
        Tile oldTile = game.getTileAt(new Position(3,4));
        Tile forest = new TileImpl(GameConstants.FOREST);
        ((GameImpl) game).removeFromWorld(new Position(3,4), oldTile);
        ((GameImpl) game).addToWorld(new Position(3,4), forest);

        assertEquals(game.getTileAt(new Position(3,4)).getTypeString(), GameConstants.FOREST);
        game.moveUnit(new Position(3,3), new Position(3,4));
        game.performUnitActionAt(new Position(3,4));
        assertEquals(game.getTileAt(new Position(3,4)).getTypeString(), GameConstants.PLAINS);
    }
}
