package hotciv.standard;

import hotciv.framework.City;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.WinningStrategy;

import java.util.HashMap;

public class BetaWinningStrategy implements WinningStrategy {
  @Override
  public Player getWinner(GameImpl game) {
    Player lastOwner = null;

    HashMap<Position, City> cities = game.getCities();

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
