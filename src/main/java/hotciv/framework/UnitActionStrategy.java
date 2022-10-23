package hotciv.framework;

import hotciv.framework.*;

import java.util.HashMap;

public interface UnitActionStrategy {
    void chooseAction(Position p, HashMap<Position, Unit> units, HashMap<Position, City> cities);
}
