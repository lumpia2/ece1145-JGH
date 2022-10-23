package hotciv.standard;

import hotciv.framework.*;
import java.util.HashMap;

public class GammaCivActionStrategy implements UnitActionStrategy {
    public void chooseAction(Position p, HashMap<Position, Unit> units, HashMap<Position, City> cities) {
        Player currentPlayer = units.get(p).getOwner();
        Unit unit = units.get(p);

        if (unit.getTypeString() == GameConstants.SETTLER) {
            units.remove(p);
            cities.put(p, new CityImpl(currentPlayer));
        } else if (unit.getTypeString() == GameConstants.ARCHER) {
            ((UnitImpl) unit).toggleFortified();
            ((UnitImpl) unit).doubleDefensiveStrength();
        }
    }
}
