package hotciv.standard.winningStrategies;

import hotciv.framework.Player;
import hotciv.framework.WinningStrategy;
import hotciv.standard.implementations.GameImpl;

public class ZetaWinningStrategy implements WinningStrategy {
  private WinningStrategy betaWinningStrategy;
  private WinningStrategy epsilonWinningStrategy;
  private WinningStrategy currentState;
  private boolean hasBeenReset;

  public ZetaWinningStrategy(WinningStrategy betaWinningStrategy, WinningStrategy epsilonWinningStrategy)
  {
    this.betaWinningStrategy = betaWinningStrategy;
    this.epsilonWinningStrategy = epsilonWinningStrategy;
    this.currentState = null;
    this.hasBeenReset = false;
  }

  @Override
  public Player getWinner(GameImpl game) {
    int round = game.getRound();
    
    if(round < 20)
    {
      currentState = betaWinningStrategy;
    }
    else if (round == 20)
    {
      game.resetAttackCount();
      currentState = epsilonWinningStrategy;
    }
    else
    {
      currentState = epsilonWinningStrategy;
    }

    return currentState.getWinner(game);
  }
}
