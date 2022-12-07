package hotciv.standard;

import hotciv.framework.*;

import hotciv.standard.worldLayoutStrategies.DeltaWorldLayoutStrategy;
import org.junit.*;
import static org.junit.Assert.*;

public class TestDeltaWorldLayoutStrategy {

    private WorldLayoutStrategy worldLayout;

    @Before
    public void setUp() {
        worldLayout = new DeltaWorldLayoutStrategy();
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
