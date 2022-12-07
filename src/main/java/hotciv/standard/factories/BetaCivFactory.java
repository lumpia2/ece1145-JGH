package hotciv.standard.factories;

import hotciv.framework.*;
import hotciv.standard.actionStrategies.AlphaCivActionStrategy;
import hotciv.standard.moveUnitStrategies.AlphaCivMoveUnitStrategy;
import hotciv.standard.worldLayoutStrategies.AlphaWorldLayoutStrategy;
import hotciv.standard.agingStrategies.BetaAgingStrategy;
import hotciv.standard.winningStrategies.BetaWinningStrategy;

public class BetaCivFactory implements CivFactory {
    @Override
    public AgingStrategy createAgingStrategy() {
        return new BetaAgingStrategy();
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
        return new BetaWinningStrategy();
    }

    @Override
    public WorldLayoutStrategy createWorldLayoutStrategy() {
        return new AlphaWorldLayoutStrategy();
    }
}
