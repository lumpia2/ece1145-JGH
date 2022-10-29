package hotciv.standard;

import hotciv.framework.City;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.WinningStrategy;

import org.junit.*;

import java.util.HashMap;

import static org.junit.Assert.*;

public class TestBetaWinningStrategy {
  private WinningStrategy winningStrategy;

  @Before
  public void setUp()
  {
    winningStrategy = new BetaWinningStrategy();
  }

  @Test
  public void winnerShouldBeNullWhenCitiesHaveDifferentOwners()
  {
    HashMap<Position, City> cities = new HashMap<>();
    cities.put(new Position(1,1), new CityImpl(Player.RED));
    cities.put(new Position(1,2), new CityImpl(Player.BLUE));

    assertNull(winningStrategy.getWinner(0, cities, 0));
  }

  @Test
  public void winnerShouldBeRedWhenRedOwnsAllCities()
  {
    HashMap<Position, City> cities = new HashMap<>();
    cities.put(new Position(1,1), new CityImpl(Player.RED));
    cities.put(new Position(1,2), new CityImpl(Player.RED));

    assertEquals(Player.RED, winningStrategy.getWinner(0, cities, 0));
  }
}
