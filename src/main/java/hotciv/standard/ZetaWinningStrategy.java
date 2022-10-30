package hotciv.standard;

import hotciv.framework.City;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.WinningStrategy;

import java.util.HashMap;

public class ZetaWinningStrategy implements WinningStrategy {
  private WinningStrategy betaWinningStrategy = new BetaWinningStrategy();
  private WinningStrategy EpsilonWinningStrategy = new EpsilonWinningStrategy();

  @Override
  public Player getWinner(int year, HashMap<Position, City> cities) {

  }
}
