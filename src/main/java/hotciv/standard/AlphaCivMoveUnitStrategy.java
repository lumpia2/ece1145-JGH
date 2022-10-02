package hotciv.standard;

import hotciv.framework.Position;

import java.util.HashMap;

public class AlphaCivMoveUnitStrategy implements MoveUnitStrategy {
    public boolean moveUnit(Position from, Position to, HashMap<Position, UnitImpl> units) {
        return true;
    }
}
