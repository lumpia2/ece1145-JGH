package hotciv.framework;

import hotciv.standard.CityImpl;

import java.util.HashMap;

public interface WinningStrategy {
  public Player getWinner( int year, HashMap<Position, CityImpl> cities);
}
