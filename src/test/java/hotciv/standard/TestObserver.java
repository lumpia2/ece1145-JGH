package hotciv.standard;

import hotciv.framework.*;

import hotciv.standard.factories.AlphaCivFactory;
import hotciv.standard.implementations.CityImpl;
import hotciv.standard.implementations.GameImpl;
import hotciv.standard.implementations.TestSpyObserverImpl;
import hotciv.standard.implementations.UnitImpl;
import org.junit.*;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


public class TestObserver {
    private Game game;
    private City city;
    private Unit unit;
    private GameObserver observer;

    @Before
    public void setUp() {
        game = new GameImpl(new AlphaCivFactory());
        observer = new TestSpyObserverImpl();
        game.addObserver(observer);
    }

    @Test
    public void testObserveMoveUnit() {
        assertThat(game.getUnitAt(new Position(2,0)).getTypeString(), is (GameConstants.ARCHER));
        assertTrue(game.moveUnit(new Position(2,0), new Position(2,1)));
        assertThat(((TestSpyObserverImpl) observer).getChangedPos(), is (new Position(2,1)));
    }

    @Test
    public void testNewCity() {
        city = new CityImpl(Player.RED);
        ((GameImpl) game).addToWorld(new Position(0,0), city);

        assertThat(game.getCityAt(new Position(0,0)), is (city));
        assertThat(((TestSpyObserverImpl) observer).getChangedPos(), is(new Position(0,0)));
    }

    @Test
    public void testNewUnit() {
        unit = new UnitImpl(GameConstants.ARCHER, Player.RED);
        ((GameImpl) game).addToWorld(new Position(0,0), unit);

        assertThat(game.getUnitAt(new Position(0,0)), is(unit));
        assertThat(((TestSpyObserverImpl) observer).getChangedPos(), is(new Position(0,0)));
    }

    @Test
    public void testNextPlayer() {
        game.endOfTurn();
        assertThat(((TestSpyObserverImpl) observer).getNextPlayer(), is(Player.RED));
        assertThat(((TestSpyObserverImpl) observer).getAge(), is(-4000));

        game.endOfTurn();
        assertThat(((TestSpyObserverImpl) observer).getNextPlayer(), is(Player.BLUE));
        assertThat(((TestSpyObserverImpl) observer).getAge(), is(-3900));
    }

    @Test
    public void testFocusedTile() {
        game.setTileFocus(new Position(0,0));
        assertThat(((TestSpyObserverImpl) observer).getFocusedPos(), is(new Position(0,0)));

        game.setTileFocus(new Position(5,5));
        assertThat(((TestSpyObserverImpl) observer).getFocusedPos(), is(new Position(5,5)));
    }
}
