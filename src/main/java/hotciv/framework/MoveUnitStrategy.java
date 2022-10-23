package hotciv.framework;

import hotciv.framework.Position;

import java.util.HashMap;

public interface MoveUnitStrategy {
    boolean moveUnit(Position from, Position to, HashMap<Position, hotciv.framework.Unit> units);
}
