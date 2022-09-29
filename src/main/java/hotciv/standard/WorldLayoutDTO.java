package hotciv.standard;

import hotciv.framework.City;
import hotciv.framework.Position;
import hotciv.framework.Tile;
import hotciv.framework.Unit;

import java.util.HashMap;

public class WorldLayoutDTO {
    private HashMap<Position, Tile> tiles = new HashMap<>();
    private HashMap<Position, Unit> units = new HashMap<>();
    private HashMap<Position, City> cities = new HashMap<>();

    public HashMap<Position, Tile> getTiles() { return tiles; }

    public HashMap<Position, Unit> getUnits() { return units; }

    public HashMap<Position, City> getCities() { return cities; }

    public void setTiles(HashMap<Position, Tile> tiles) { this.tiles = tiles; }

    public void setUnits(HashMap<Position, Unit> units) { this.units = units; }

    public void setCities(HashMap<Position, City> cities) { this.cities = cities; }
}
