package hotciv.standard;
import java.io.*;

import hotciv.framework.*;

public class GammaCivActionStrategy implements UnitActionStrategy {
    public void chooseAction(Position p, GameImpl game) {
        Player currentPlayer = game.getPlayerInTurn();
        Unit unit = game.getUnitAt(p);

        if (unit.getTypeString() == GameConstants.SETTLER) {
            game.removeFromWorld(p, unit);
            game.addToWorld(p, new CityImpl(currentPlayer));
        } else if (unit.getTypeString() == GameConstants.ARCHER) {
            ((UnitImpl) unit).toggleFortified();
            ((UnitImpl) unit).doubleDefensiveStrength();
        }
    }
}
