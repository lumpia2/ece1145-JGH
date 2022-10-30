package hotciv.standard;

import hotciv.framework.City;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.WinningStrategy;

import java.util.HashMap;

public class BetaWinningStrategy implements WinningStrategy {
  @Override
  public Player getWinner(int year, HashMap<Position, City> cities, HashMap<Player, Integer> attackWins, int round) {
    Player lastOwner = null;

    for(City city : cities.values())
    {
      if(lastOwner == null)
      {
        lastOwner = city.getOwner();
      }
      else
      {
        if(city.getOwner() != lastOwner)
        {
          return null;
        }
      }
    }

    return lastOwner;
  }
}
