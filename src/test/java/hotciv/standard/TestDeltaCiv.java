package hotciv.standard;

import hotciv.framework.*;

import hotciv.standard.factories.DeltaCivFactory;
import hotciv.standard.implementations.GameImpl;
import hotciv.standard.implementations.UnitImpl;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TestDeltaCiv {
    private Game game;

    @Before
    public void setUp() {
        game = new GameImpl(new DeltaCivFactory());
    }

    @Test
    public void verifyCitiesLocation() {
        assertThat(game.getCityAt(new Position(4,5)), is(notNullValue()));
        assertThat(game.getCityAt(new Position(8,12)), is(notNullValue()));
    }

    @Test
    public void verifyCityOwnership() {
        assertEquals(game.getCityAt(new Position(4,5)).getOwner(), Player.BLUE);
        assertEquals(game.getCityAt(new Position(8,12)).getOwner(), Player.RED);
    }

    @Test
    public void verifyUnitsLocation() {
        assertEquals(GameConstants.ARCHER, game.getUnitAt(new Position(2,0)).getTypeString());
        assertEquals(GameConstants.LEGION, game.getUnitAt(new Position(3,2)).getTypeString());
        assertEquals(GameConstants.SETTLER, game.getUnitAt(new Position(4,3)).getTypeString());
    }

    @Test
    public void verifyMountainLocations() {
        assertEquals(GameConstants.MOUNTAINS, game.getTileAt(new Position(0,5)).getTypeString());
        assertEquals(GameConstants.MOUNTAINS, game.getTileAt(new Position(2,6)).getTypeString());
        assertEquals(GameConstants.MOUNTAINS, game.getTileAt(new Position(3,3)).getTypeString());
    }

    @Test
    public void verifyHillLocations() {
        assertEquals(GameConstants.HILLS, game.getTileAt(new Position(1,3)).getTypeString());
        assertEquals(GameConstants.HILLS, game.getTileAt(new Position(1,4)).getTypeString());
        assertEquals(GameConstants.HILLS, game.getTileAt(new Position(5,12)).getTypeString());
    }

    @Test
    public void verifyOceanLocations() {
        assertEquals(GameConstants.OCEANS, game.getTileAt(new Position(0,0)).getTypeString());
        assertEquals(GameConstants.OCEANS, game.getTileAt(new Position(15,15)).getTypeString());
        assertEquals(GameConstants.OCEANS, game.getTileAt(new Position(10,10)).getTypeString());
    }

    @Test
    public void addUnitToWorld() {
        game.addToWorld(new Position(3,3), new UnitImpl(GameConstants.ARCHER, Player.BLUE));
        assertEquals(GameConstants.ARCHER, game.getUnitAt(new Position(3,3)).getTypeString());
        assertEquals(Player.BLUE, game.getUnitAt(new Position(3,3)).getOwner());
    }

    @Test
    public void removeUnitFromWorld() {
        game.addToWorld(new Position(3,3), new UnitImpl(GameConstants.ARCHER, Player.BLUE));
        assertEquals(GameConstants.ARCHER, game.getUnitAt(new Position(3,3)).getTypeString());
        assertEquals(Player.BLUE, game.getUnitAt(new Position(3,3)).getOwner());
        game.removeFromWorld(new Position(3,3), new UnitImpl(GameConstants.ARCHER, Player.BLUE));
        assertNull(game.getUnitAt(new Position(3,3)));
    }
}
