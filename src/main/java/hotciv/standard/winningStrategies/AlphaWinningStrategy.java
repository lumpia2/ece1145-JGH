package hotciv.standard.winningStrategies;

import hotciv.framework.Player;
import hotciv.framework.WinningStrategy;
import hotciv.standard.implementations.GameImpl;

public class AlphaWinningStrategy implements WinningStrategy {
  @Override
  public Player getWinner(GameImpl game) {
    if(game.getAge() == -3000)
    {
      return Player.RED;
    }
    return null;
  }
}
