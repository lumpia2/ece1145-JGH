package hotciv.standard;

import hotciv.framework.*;

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
