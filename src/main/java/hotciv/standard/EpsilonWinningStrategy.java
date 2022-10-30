package hotciv.standard;

import hotciv.framework.*;

import java.util.HashMap;
import java.util.Map;

public class EpsilonWinningStrategy implements WinningStrategy {

    @Override
    public Player getWinner(int year, HashMap<Position, City> cities, HashMap<Player, Integer> attackWins, int round) {
        for (Map.Entry<Player, Integer> entry : attackWins.entrySet()) {
            if (entry.getValue() == 3) {
                return entry.getKey();
            }
        }
        return null;
    }

}
