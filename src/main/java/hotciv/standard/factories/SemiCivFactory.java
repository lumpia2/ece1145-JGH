package hotciv.standard.factories;

import hotciv.framework.*;
import hotciv.standard.agingStrategies.BetaAgingStrategy;
import hotciv.standard.worldLayoutStrategies.DeltaWorldLayoutStrategy;
import hotciv.standard.actionStrategies.GammaCivActionStrategy;
import hotciv.standard.moveUnitStrategies.GammaCivMoveUnitStrategy;
import hotciv.standard.winningStrategies.EpsilonWinningStrategy;

public class SemiCivFactory implements CivFactory {
  @Override
  public AgingStrategy createAgingStrategy() {
    return new BetaAgingStrategy();
  }

  @Override
  public MoveUnitStrategy createMoveUnitStrategy() {
    return new GammaCivMoveUnitStrategy();
  }

  @Override
  public UnitActionStrategy createUnitActionStrategy() {
    return new GammaCivActionStrategy();
  }

  @Override
  public WinningStrategy createWinningStrategy() {
    return new EpsilonWinningStrategy();
  }

  @Override
  public WorldLayoutStrategy createWorldLayoutStrategy() {
    return new DeltaWorldLayoutStrategy();
  }
}
