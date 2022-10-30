package hotciv.standard;

import hotciv.framework.*;

import java.util.HashMap;

public class EpsilonWinningStrategy implements WinningStrategy {

    private Player winner;
    @Override
    public Player getWinner(int year, HashMap<Position, City> cities) {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
