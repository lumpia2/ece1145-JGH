package hotciv.standard;

import hotciv.framework.*;

import hotciv.standard.worldLayoutStrategies.AlphaWorldLayoutStrategy;
import org.junit.*;
import static org.junit.Assert.*;

public class TestAlphaWorldLayoutStrategy {
    private WorldLayoutStrategy worldLayout;

    @Before
    public void setUp() {
        worldLayout = new AlphaWorldLayoutStrategy();
        worldLayout.createWorld();
    }

    @Test
    public void tilesNotNull() {
        assertNotNull(worldLayout.getTiles());
    }

    @Test
    public void unitsNotNull() {
        assertNotNull(worldLayout.getUnits());
    }

    @Test
    public void citiesNotNull() {
        assertNotNull(worldLayout.getCities());
    }
}
