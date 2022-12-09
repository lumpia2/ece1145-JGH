package hotciv.standard.actionStrategies;

import hotciv.framework.*;
import hotciv.standard.implementations.CityImpl;
import hotciv.standard.implementations.GameImpl;
import hotciv.standard.implementations.TileImpl;
import hotciv.standard.implementations.UnitImpl;

public class ThetaCivActionStrategy implements UnitActionStrategy{
    public void chooseAction(Position p, GameImpl game) {
        Player currentPlayer = game.getPlayerInTurn();
        Unit unit = game.getUnitAt(p);
        City city = game.getCityAt(p);

        if (unit.getTypeString() == GameConstants.SETTLER) {
            game.removeFromWorld(p, unit);
            game.addToWorld(p, new CityImpl(currentPlayer));
        } else if (unit.getTypeString() == GameConstants.ARCHER) {
            ((UnitImpl) unit).toggleFortified();
            ((UnitImpl) unit).doubleDefensiveStrength();
        } else if (unit.getTypeString() == GameConstants.UFO) {
            if (city != null) {
                ((CityImpl) city).decrementPopulation();
                if (((CityImpl) city).getPopulation() == 0) {
                    game.removeFromWorld(p, city);
                }
            } else if (game.getTileAt(p).getTypeString() == GameConstants.FOREST) {
                Tile plains = new TileImpl(GameConstants.PLAINS);
                game.removeFromWorld(p, game.getTileAt(p));
                game.addToWorld(p, plains);
            }
        }
    }
}
