package hotciv.standard;

import hotciv.framework.*;

import org.junit.*;
import static org.junit.Assert.*;

public class TestZetaCiv {
  private Game game;

  /** Fixture for betaciv testing. */
  @Before
  public void setUp() {
    game = new GameImpl(new BetaCivFactory());
  }

  @Test
  public void winnerIsNullIfNotAllCitiesConquered()
  {
    assertNull(game.getWinner());
  }

  @Test
  public void whenRedOwnsAllCitiesRedIsWinner()
  {
    ((CityImpl) game.getCityAt(new Position(4,1))).setOwner(Player.RED);
    assertEquals(Player.RED, game.getWinner());
  }

  private void endOfRound()
  {
    game.endOfTurn(); game.endOfTurn();
  }
}
