package hotciv.framework;

import hotciv.standard.GameImpl;

public interface MoveUnitStrategy {
    boolean moveUnit(Position from, Position to, Game game);
}
