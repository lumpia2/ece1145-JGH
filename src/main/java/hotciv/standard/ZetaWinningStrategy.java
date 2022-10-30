package hotciv.standard;

import hotciv.framework.City;
import hotciv.framework.Player;
import hotciv.framework.Position;
import hotciv.framework.WinningStrategy;

import java.util.HashMap;

public class ZetaWinningStrategy implements WinningStrategy {
  private WinningStrategy betaWinningStrategy;
  private WinningStrategy epsilonWinningStrategy;
  private WinningStrategy currentState;

  public ZetaWinningStrategy(WinningStrategy betaWinningStrategy, WinningStrategy epsilonWinningStrategy)
  {
    this.betaWinningStrategy = betaWinningStrategy;
    this.epsilonWinningStrategy = epsilonWinningStrategy;
    this.currentState = null;
  }

  @Override
  public Player getWinner(GameImpl game) {
    int round = game.getRound();
    
    if(round < 20)
    {
      currentState = betaWinningStrategy;
    }
    else
    {
      currentState = epsilonWinningStrategy;
    }

    return currentState.getWinner(game);
  }
}
