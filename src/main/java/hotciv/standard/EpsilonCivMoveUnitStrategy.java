package hotciv.standard;

import hotciv.framework.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class EpsilonCivMoveUnitStrategy implements MoveUnitStrategy {
    private int A, D, randomNum;

    @Override
    public boolean moveUnit(Position from, Position to, Game game) {
        // check if to is empty
        if (game.getUnitAt(to) == null) {
            game.addToWorld(to, game.getUnitAt(from));
            game.removeFromWorld(from, game.getUnitAt(from));
            return true;
        }

        A = calculateTotalStrength(from, game, true);
        D = calculateTotalStrength(to, game, false);

        randomNum = ThreadLocalRandom.current().nextInt(1, 7);
        A *= randomNum;
        randomNum = ThreadLocalRandom.current().nextInt(1, 7);
        D *= randomNum;

        if (A > D) {
            incrementWinner((GameImpl)game, game.getPlayerInTurn());
            game.removeFromWorld(to, game.getUnitAt(to));
            game.addToWorld(to, game.getUnitAt(from));
            game.removeFromWorld(from, game.getUnitAt(from));
            return true;
        } else {
            game.removeFromWorld(from, game.getUnitAt(from));
            return false;
        }
    }

    public static int calculateTotalStrength(Position p, Game game, boolean Attacking) {
        int strength = 0;
        Tile tile = game.getTileAt(p);
        Unit unit = game.getUnitAt(p);
        Player owner = unit.getOwner();
        Iterator<Position> positionIterator = Utility.get8neighborhoodIterator(p);

        // check unit strength
        if (Attacking) {
            strength = unit.getAttackingStrength();
        } else {
            strength = unit.getDefensiveStrength();
        }

        // check supporting strength
        while (positionIterator.hasNext()) {
            Position nextPosition = positionIterator.next();
            if (game.getUnitAt(nextPosition) != null) {
                Unit support = game.getUnitAt(nextPosition);
                if (support.getOwner() == owner) {
                    strength++;
                }
            }
        }

        // check terrain factor
        if (game.getCityAt(p) != null) {
            strength *= 3;
        } else if (tile.getTypeString() == "forest" || tile.getTypeString() == "hills") {
            strength *= 2;
        }

        return strength;
    }

    public static void incrementWinner(GameImpl game, Player winner) {
        HashMap<Player, Integer> attackWins = game.getAttackWins();

        // check if already a winner
        for (Integer value : attackWins.values()) {
            if (value == 3) {
                return;
            }
        }

        int currentWins = attackWins.get(winner);
        attackWins.put(winner, currentWins+1);
    }
}
