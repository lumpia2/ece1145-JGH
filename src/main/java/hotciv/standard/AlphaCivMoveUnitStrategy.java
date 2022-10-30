package hotciv.standard;

import hotciv.framework.*;

import java.util.HashMap;

public class AlphaCivMoveUnitStrategy implements MoveUnitStrategy {
    public boolean moveUnit(Position from, Position to, HashMap<Position, Unit> units, HashMap<Position, Tile> tiles, HashMap<Position, City> cities, Player winner) {
        return true;
    }
}
