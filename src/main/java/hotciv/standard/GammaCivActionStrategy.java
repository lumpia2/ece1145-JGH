package hotciv.standard;

import hotciv.framework.*;

import java.util.HashMap;

public class GammaCivActionStrategy implements UnitActionStrategy {
    public void chooseAction(Position p, HashMap<Position, UnitImpl> units, HashMap<Position, CityImpl> cities) {
        Player currentPlayer = units.get(p).getOwner();

        units.remove(p);
        cities.put(p, new CityImpl(currentPlayer));
    }
}
