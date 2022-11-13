package hotciv.framework;

import hotciv.framework.*;
import hotciv.standard.GameImpl;

public interface UnitActionStrategy {
    void chooseAction(Position p, GameImpl game);
}
