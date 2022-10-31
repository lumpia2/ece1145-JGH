package hotciv.standard;

import hotciv.framework.*;

import java.util.HashMap;
import java.util.Iterator;

public class Utility2 {
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
        attackWins.put(winner, currentWins + 1);
    }
}
