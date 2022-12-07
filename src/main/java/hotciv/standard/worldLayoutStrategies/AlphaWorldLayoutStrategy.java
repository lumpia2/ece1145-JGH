package hotciv.standard.worldLayoutStrategies;

import hotciv.framework.*;
import hotciv.standard.implementations.CityImpl;
import hotciv.standard.implementations.TileImpl;
import hotciv.standard.implementations.UnitImpl;

import java.util.HashMap;

public class AlphaWorldLayoutStrategy implements WorldLayoutStrategy {
    private HashMap<Position, Tile> tiles = new HashMap<>();
    private HashMap<Position, Unit> units = new HashMap<>();
    private HashMap<Position, City> cities = new HashMap<>();
    @Override
    public void createWorld() {
        for (int i = 0; i < GameConstants.WORLDSIZE; i++) {
            for (int j = 0; j < GameConstants.WORLDSIZE; j++) {
                String tileType = GameConstants.PLAINS;
                if (i == 1 && j == 0) {
                    tileType = GameConstants.OCEANS;
                } else if (i == 0 && j == 1) {
                    tileType = GameConstants.HILLS;
                } else if (i == 2 && j == 2) {
                    tileType = GameConstants.MOUNTAINS;
                }

                if (i==2 && j==0) { units.put(new Position(i,j), new UnitImpl(GameConstants.ARCHER, Player.RED)); }
                if (i==3 && j==2) { units.put(new Position(i,j), new UnitImpl(GameConstants.LEGION, Player.BLUE)); }
                if (i==4 && j==3) { units.put(new Position(i,j), new UnitImpl(GameConstants.SETTLER, Player.RED)); }

                if (i==1 && j==1) { cities.put(new Position(i,j), new CityImpl(Player.RED)); }
                if (i==4 && j==1) { cities.put(new Position(i,j), new CityImpl(Player.BLUE)); }

                tiles.put(new Position(i, j), new TileImpl(tileType));
            }
        }
    }

    @Override
    public HashMap<Position, Tile> getTiles() {
        return tiles;
    }

    @Override
    public HashMap<Position, Unit> getUnits() {
        return units;
    }

    @Override
    public HashMap<Position, City> getCities() {
        return cities;
    }
}
