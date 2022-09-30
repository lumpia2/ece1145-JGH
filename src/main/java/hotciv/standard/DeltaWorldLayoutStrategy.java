package hotciv.standard;

import hotciv.framework.*;

import java.util.HashMap;

public class DeltaWorldLayoutStrategy implements WorldLayoutStrategy {
    private HashMap<Position, Tile> tiles = new HashMap<>();
    private HashMap<Position, Unit> units = new HashMap<>();
    private HashMap<Position, City> cities = new HashMap<>();
    @Override
    public void createWorld() {
        String[] layout =
                new String[] {
                        "...ooMooooo.....",
                        "..ohhoooofffoo..",
                        ".oooooMooo...oo.",
                        ".ooMMMoooo..oooo",
                        "...ofooohhoooo..",
                        ".ofoofooooohhoo.",
                        "...ooo..........",
                        ".ooooo.ooohooM..",
                        ".ooooo.oohooof..",
                        "offfoooo.offoooo",
                        "oooooooo...ooooo",
                        ".ooMMMoooo......",
                        "..ooooooffoooo..",
                        "....ooooooooo...",
                        "..ooohhoo.......",
                        ".....ooooooooo..",
                };
        // Conversion...
        String line;
        for ( int r = 0; r < GameConstants.WORLDSIZE; r++ ) {
            line = layout[r];
            for ( int c = 0; c < GameConstants.WORLDSIZE; c++ ) {
                char tileChar = line.charAt(c);
                String type = "error";
                if ( tileChar == '.' ) { type = GameConstants.OCEANS; }
                if ( tileChar == 'o' ) { type = GameConstants.PLAINS; }
                if ( tileChar == 'M' ) { type = GameConstants.MOUNTAINS; }
                if ( tileChar == 'f' ) { type = GameConstants.FOREST; }
                if ( tileChar == 'h' ) { type = GameConstants.HILLS; }

                if (r==2 && c==0) { units.put(new Position(r,c), new UnitImpl(GameConstants.ARCHER, Player.RED)); }
                if (r==3 && c==2) { units.put(new Position(r,c), new UnitImpl(GameConstants.LEGION, Player.BLUE)); }
                if (r==4 && c==3) { units.put(new Position(r,c), new UnitImpl(GameConstants.SETTLER, Player.RED)); }

                if (r==8 && c==12) { cities.put(new Position(r,c), new CityImpl(Player.RED)); }
                if (r==4 && c==5) { cities.put(new Position(r,c), new CityImpl(Player.BLUE)); }

                Position p = new Position(r,c);
                tiles.put( p, new TileImpl(type));
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
