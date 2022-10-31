package hotciv.framework;

import hotciv.standard.GameImpl;

import java.util.HashMap;

public interface WinningStrategy {
  public Player getWinner(GameImpl game);
}
