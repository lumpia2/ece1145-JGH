package hotciv.standard.actionStrategies;

import hotciv.framework.*;
import hotciv.standard.implementations.CityImpl;
import hotciv.standard.implementations.GameImpl;
import hotciv.standard.implementations.UnitImpl;

public class GammaCivActionStrategy implements UnitActionStrategy {
    public void chooseAction(Position p, GameImpl game) {
        Player currentPlayer = game.getPlayerInTurn();
        Unit unit = game.getUnitAt(p);

        if (unit.getTypeString().equals(GameConstants.SETTLER)) {
            game.removeFromWorld(p, unit);
            game.addToWorld(p, new CityImpl(currentPlayer));
        } else if (unit.getTypeString().equals(GameConstants.ARCHER)) {
            ((UnitImpl) unit).toggleFortified();
            ((UnitImpl) unit).doubleDefensiveStrength();
        }
    }
}
