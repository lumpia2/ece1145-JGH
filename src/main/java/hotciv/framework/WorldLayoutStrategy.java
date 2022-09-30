package hotciv.framework;

import java.util.HashMap;

public interface WorldLayoutStrategy {
    public void createWorld();

    public HashMap<Position, Tile> getTiles();

    public HashMap<Position, Unit> getUnits();

    public HashMap<Position, City> getCities();
}
