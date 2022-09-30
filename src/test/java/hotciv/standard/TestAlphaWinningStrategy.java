package hotciv.standard;

import hotciv.framework.Player;
import hotciv.framework.WinningStrategy;

import org.junit.*;
import static org.junit.Assert.*;

public class TestAlphaWinningStrategy {
  private WinningStrategy winningStrategy;

  @Before
  public void setUp()
  {
    winningStrategy = new AlphaWinningStrategy();
  }

  @Test
  public void winnerShouldBeNullWhenYearNot3000()
  {
    assertNull(winningStrategy.getWinner(-4000, null));
  }

  @Test
  public void winnerShouldBeRedWhenYearNeg3000()
  {
    assertEquals(Player.RED, winningStrategy.getWinner(-3000, null));
  }
}
