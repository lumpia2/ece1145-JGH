package hotciv.standard.factories;

import hotciv.framework.*;
import hotciv.standard.actionStrategies.ThetaCivActionStrategy;
import hotciv.standard.agingStrategies.AlphaAgingStrategy;
import hotciv.standard.moveUnitStrategies.ThetaCivMoveUnitStrategy;
import hotciv.standard.winningStrategies.AlphaWinningStrategy;
import hotciv.standard.worldLayoutStrategies.AlphaWorldLayoutStrategy;

public class ThetaCivFactory implements CivFactory {
    @Override
    public AgingStrategy createAgingStrategy() {
        return new AlphaAgingStrategy();
    }

    @Override
    public MoveUnitStrategy createMoveUnitStrategy() {
        return new ThetaCivMoveUnitStrategy();
    }

    @Override
    public UnitActionStrategy createUnitActionStrategy() {
        return new ThetaCivActionStrategy();
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
