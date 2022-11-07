package hotciv.standard;

import hotciv.framework.*;

import java.util.HashMap;

public class AlphaCivMoveUnitStrategy implements MoveUnitStrategy {
    public boolean moveUnit(Position from, Position to, GameImpl game) {
        boolean validFrom = (game.getUnitAt(from) != null);
        boolean noMountain = (game.getTileAt(to).getTypeString() != GameConstants.MOUNTAINS);
        Unit movingUnit = game.getUnitAt(from);

        if (validFrom && noMountain) {
            // remove unit from destination if it exists
            if (game.getUnitAt(to) != null) {
                game.removeFromWorld(to, game.getUnitAt(to));
            }
            game.addToWorld(to, movingUnit);
            game.removeFromWorld(from, movingUnit);
            return true;
        } else {
            return false;
        }
    }
}
