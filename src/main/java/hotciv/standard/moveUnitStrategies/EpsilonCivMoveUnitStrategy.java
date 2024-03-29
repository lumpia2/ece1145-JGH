package hotciv.standard.moveUnitStrategies;

import hotciv.framework.*;
import hotciv.standard.implementations.GameImpl;
import hotciv.standard.utilities.Utility2;

import java.util.concurrent.ThreadLocalRandom;

public class EpsilonCivMoveUnitStrategy implements MoveUnitStrategy {
    private int A, D, randomNum;
    private Utility2 utility2;
    @Override
    public boolean moveUnit(Position from, Position to, Game game) {
        // check if to is empty
        boolean noMountain = (game.getTileAt(to).getTypeString() != GameConstants.MOUNTAINS);
        if (!noMountain) {
            return false;
        } else if (game.getUnitAt(to) == null) {
            game.addToWorld(to, game.getUnitAt(from));
            game.removeFromWorld(from, game.getUnitAt(from));
            return true;
        }

        A = utility2.calculateTotalStrength(from, game, true);
        D = utility2.calculateTotalStrength(to, game, false);

        randomNum = ThreadLocalRandom.current().nextInt(1, 7);
        A *= randomNum;
        randomNum = ThreadLocalRandom.current().nextInt(1, 7);
        D *= randomNum;

        if (A > D) {
            utility2.incrementWinner((GameImpl) game, game.getPlayerInTurn());
            game.removeFromWorld(to, game.getUnitAt(to));
            game.addToWorld(to, game.getUnitAt(from));
            game.removeFromWorld(from, game.getUnitAt(from));
            return true;
        } else {
            game.removeFromWorld(from, game.getUnitAt(from));
            return false;
        }
    }
}

