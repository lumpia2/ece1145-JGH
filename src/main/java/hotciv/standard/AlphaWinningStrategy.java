package hotciv.standard;

import hotciv.framework.City;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.WinningStrategy;

import java.util.HashMap;

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
