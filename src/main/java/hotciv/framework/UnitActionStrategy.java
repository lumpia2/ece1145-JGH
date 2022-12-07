package hotciv.framework;

import hotciv.standard.implementations.GameImpl;

public interface UnitActionStrategy {
    void chooseAction(Position p, GameImpl game);
}
