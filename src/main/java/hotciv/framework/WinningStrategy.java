package hotciv.framework;

import java.util.HashMap;

public interface WinningStrategy {
  public Player getWinner(int year, HashMap<Position, City> cities);
}
