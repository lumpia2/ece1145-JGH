package hotciv.standard;

import hotciv.framework.Position;
import hotciv.framework.Unit;

import java.util.HashMap;

public class AlphaCivMoveUnitStrategy implements MoveUnitStrategy {
    public boolean moveUnit(Position from, Position to, HashMap<Position, Unit> units) {
        return true;
    }
}
