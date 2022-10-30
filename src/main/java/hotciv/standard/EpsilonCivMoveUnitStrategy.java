package hotciv.standard;

import hotciv.framework.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

public class EpsilonCivMoveUnitStrategy implements MoveUnitStrategy {
    private int A, D, randomNum;
    private int redWins, blueWins;

    @Override
    public boolean moveUnit(Position from, Position to, HashMap<Position, Unit> units, HashMap<Position, Tile> tiles, HashMap<Position, City> cities, Player winner) {
        // check if to is empty
        if (!units.containsKey(to)) {
            units.put(to, units.get(from));
            units.remove(from);
            return true;
        }

        A = calculateTotalStrength(from, units, tiles, cities, true);
        D = calculateTotalStrength(to, units, tiles, cities, false);

        randomNum = ThreadLocalRandom.current().nextInt(1, 7);
        A *= randomNum;
        randomNum = ThreadLocalRandom.current().nextInt(1, 7);
        D *= randomNum;

        if (A > D) {
            units.remove(to);
            units.put(to, units.get(from));
            units.remove(from);
            return true;
        } else {
            units.remove(from);
            return false;
        }
    }

    private int calculateTotalStrength(Position p, HashMap<Position, Unit> units, HashMap<Position, Tile> tiles,  HashMap<Position, City> cities, boolean Attacking) {
        int strength = 0;
        Tile tile = tiles.get(p);
        Unit unit = units.get(p);
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
            if (units.containsKey(nextPosition)) {
                Unit support = units.get(nextPosition);
                if (support.getOwner() == owner) {
                    strength++;
                }
            }
        }

        // check terrain factor
        if (cities.get(p) != null) {
            strength *= 3;
        } else if (tile.getTypeString() == "forest" || tile.getTypeString() == "hills") {
            strength *= 2;
        }

        return strength;
    }

    private void incrementWinner(Position p, HashMap<Position, Unit> units, Player winner) {
        Unit attacker = units.get(p);
        Player owner = attacker.getOwner();

        if (owner == Player.RED) {
            redWins++;
        } else {
            blueWins++;
        }

        if (redWins == 3 || blueWins == 3) {

        }
    }
}
