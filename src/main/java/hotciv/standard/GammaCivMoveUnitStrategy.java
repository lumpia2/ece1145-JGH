package hotciv.standard;

import hotciv.framework.*;
import java.util.HashMap;

public class GammaCivMoveUnitStrategy implements MoveUnitStrategy {
    public boolean moveUnit(Position from, Position to, HashMap<Position, Unit> units, HashMap<Position, Tile> tiles, HashMap<Position, City> cities, Player winner) {
        Unit movingUnit = units.get(from);

        if (movingUnit.getTypeString() == GameConstants.ARCHER && ((UnitImpl) movingUnit).getFortified() == true) {
            return false;
        }
        return true;
    }
}
