package hotciv.standard;

import hotciv.framework.*;

import java.util.HashMap;
import java.util.Map;

public class EpsilonWinningStrategy implements WinningStrategy {

    @Override
    public Player getWinner(GameImpl game) {
        HashMap<Player, Integer> attackWins = game.getAttackWins();
        for (Map.Entry<Player, Integer> entry : attackWins.entrySet()) {
            if (entry.getValue() == 3) {
                return entry.getKey();
            }
        }
        return null;
    }

}
