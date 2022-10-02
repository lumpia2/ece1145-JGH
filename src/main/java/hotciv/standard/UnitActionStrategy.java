package hotciv.standard;

import hotciv.framework.*;

import java.util.HashMap;

public interface UnitActionStrategy {
    void chooseAction(Position p, HashMap<Position, UnitImpl> units, HashMap<Position, CityImpl> cities);
}
