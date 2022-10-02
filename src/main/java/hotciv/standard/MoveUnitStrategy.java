package hotciv.standard;

import hotciv.framework.Position;

import java.util.HashMap;

public interface MoveUnitStrategy {
    boolean moveUnit(Position from, Position to, HashMap<Position, UnitImpl> units);
}
