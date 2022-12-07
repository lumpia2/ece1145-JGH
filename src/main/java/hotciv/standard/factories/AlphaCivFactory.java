package hotciv.standard.factories;

import hotciv.framework.*;
import hotciv.standard.agingStrategies.AlphaAgingStrategy;
import hotciv.standard.actionStrategies.AlphaCivActionStrategy;
import hotciv.standard.moveUnitStrategies.AlphaCivMoveUnitStrategy;
import hotciv.standard.worldLayoutStrategies.AlphaWorldLayoutStrategy;
import hotciv.standard.winningStrategies.AlphaWinningStrategy;

public class AlphaCivFactory implements CivFactory {
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
        return new AlphaWinningStrategy();
    }

    @Override
    public WorldLayoutStrategy createWorldLayoutStrategy() {
        return new AlphaWorldLayoutStrategy();
    }
}
