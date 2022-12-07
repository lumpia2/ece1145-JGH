package hotciv.standard;

import hotciv.framework.Player;
import hotciv.framework.WinningStrategy;

import hotciv.standard.factories.AlphaCivFactory;
import hotciv.standard.implementations.GameImpl;
import hotciv.standard.winningStrategies.AlphaWinningStrategy;
import org.junit.*;
import static org.junit.Assert.*;

public class TestAlphaWinningStrategy {
  private WinningStrategy winningStrategy;
  private GameImpl game;

  @Before
  public void setUp()
  {
    winningStrategy = new AlphaWinningStrategy();
    game = new GameImpl(new AlphaCivFactory());
  }

  @Test
  public void winnerShouldBeNullWhenYearNot3000()
  {
    assertNull(winningStrategy.getWinner(this.game));
  }

  @Test
  public void winnerShouldBeRedWhenYearNeg3000()
  {
    for(int i=0; i<20; i++)
    {
      game.endOfTurn();
    }
    
    assertEquals(Player.RED, winningStrategy.getWinner(this.game));
  }
}
