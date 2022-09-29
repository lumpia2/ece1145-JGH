package hotciv.standard;

import hotciv.framework.*;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TestDeltaCiv {
    private Game game;

    @Before
    public void setUp() {
        game = new GameImpl(new DeltaWorldLayoutStrategy());
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
}
