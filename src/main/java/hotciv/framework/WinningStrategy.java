package hotciv.framework;

import hotciv.standard.implementations.GameImpl;

public interface WinningStrategy {
  public Player getWinner(GameImpl game);
}
