package hotciv.standard.factories;

import hotciv.framework.*;
import hotciv.standard.actionStrategies.AlphaCivActionStrategy;
import hotciv.standard.agingStrategies.AlphaAgingStrategy;
import hotciv.standard.moveUnitStrategies.AlphaCivMoveUnitStrategy;
import hotciv.standard.winningStrategies.BetaWinningStrategy;
import hotciv.standard.winningStrategies.EpsilonWinningStrategy;
import hotciv.standard.winningStrategies.ZetaWinningStrategy;
import hotciv.standard.worldLayoutStrategies.AlphaWorldLayoutStrategy;

public class ZetaCivFactory implements CivFactory {
    @Override
    public AgingStrategy createAgingStrategy() {
        return new AlphaAgingStrategy();
    }

    @Override
    public MoveUnitStrategy createMoveUnitStrategy() {
        return new AlphaCivMoveUnitStrategy();
    }

    @Override
    public UnitActionStrategy createUnitActionStrategy() {
        return new AlphaCivActionStrategy();
    }

    @Override
    public WinningStrategy createWinningStrategy() {
        return new ZetaWinningStrategy(new BetaWinningStrategy(), new EpsilonWinningStrategy());
    }

    @Override
    public WorldLayoutStrategy createWorldLayoutStrategy() {
        return new AlphaWorldLayoutStrategy();
    }
}
