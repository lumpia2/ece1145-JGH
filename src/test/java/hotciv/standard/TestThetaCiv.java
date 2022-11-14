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
        game.addToWorld(new Position(3,1), testUFO);

        // go back to red
        game.endOfTurn();
        game.endOfTurn();

        assertThat(game.getCityAt(new Position(4,1)), notNullValue());
        assertThat(game.moveUnit(new Position(3,1), new Position(4,1)), is(true));
        game.performUnitActionAt(new Position(4,1));
        assertEquals(game.getCityAt(new Position(4,1)), null);
    }

    @Test
    public void deforestation() {
        Unit testUFO = new UnitImpl(GameConstants.UFO, Player.RED);
        game.addToWorld(new Position(3,3), testUFO);

        // go back to red
        game.endOfTurn();
        game.endOfTurn();

        Tile oldTile = game.getTileAt(new Position(3,4));
        Tile forest = new TileImpl(GameConstants.FOREST);
        ((GameImpl) game).removeFromWorld(new Position(3,4), oldTile);
        ((GameImpl) game).addToWorld(new Position(3,4), forest);

        assertEquals(game.getTileAt(new Position(3,4)).getTypeString(), GameConstants.FOREST);
        game.moveUnit(new Position(3,3), new Position(3,4));

        // go back to red
        game.endOfTurn();
        game.endOfTurn();

        game.performUnitActionAt(new Position(3,4));
        assertEquals(game.getTileAt(new Position(3,4)).getTypeString(), GameConstants.PLAINS);
    }

    @Test
    public void canMoveTwoUnitsUFO() {
        Unit testUFO = new UnitImpl(GameConstants.UFO, Player.RED);
        game.addToWorld(new Position(3,3), testUFO);

        // go back to red
        game.endOfTurn();
        game.endOfTurn();

        assertThat(game.moveUnit(new Position(3,3), new Position(5,5)), is(true));
    }

    @Test
    public void cannotMoveThreeUnitsUFO() {
        Unit testUFO = new UnitImpl(GameConstants.UFO, Player.RED);
        game.addToWorld(new Position(3,3), testUFO);

        // go back to red
        game.endOfTurn();
        game.endOfTurn();

        assertThat(game.moveUnit(new Position(3,3), new Position(6,6)), is(false));
    }

    @Test
    public void blueCityWithSettlerGetsBattled() {
        Unit testUFO = new UnitImpl(GameConstants.UFO, Player.RED);
        game.addToWorld(new Position(3,1), testUFO);
        game.endOfTurn();

        Unit newBlueSettler = new UnitImpl(GameConstants.SETTLER, Player.BLUE);
        game.addToWorld(new Position(4,1), newBlueSettler);
        game.endOfTurn();

        Unit blueSettler = game.getUnitAt(new Position(4,1));
        assertThat(blueSettler.getTypeString(), is(GameConstants.SETTLER));

        assertThat(game.moveUnit(new Position(3,1), new Position(4,1)), is(true));
        Unit winningUnit = game.getUnitAt(new Position(4,1));
        assertThat(winningUnit.getTypeString(), is(GameConstants.UFO));
    }
}
