package hotciv.framework;

import java.util.HashMap;

public interface MoveUnitStrategy {
    boolean moveUnit(Position from, Position to, HashMap<Position, Unit> units, HashMap<Position, Tile> tiles, HashMap<Position, City> cities, Player winner);
}
