package hotciv.standard;

import hotciv.framework.*;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

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