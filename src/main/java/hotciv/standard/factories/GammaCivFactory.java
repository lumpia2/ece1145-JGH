package hotciv.standard.factories;

import hotciv.framework.*;
import hotciv.standard.actionStrategies.GammaCivActionStrategy;
import hotciv.standard.agingStrategies.AlphaAgingStrategy;
import hotciv.standard.moveUnitStrategies.GammaCivMoveUnitStrategy;
import hotciv.standard.winningStrategies.AlphaWinningStrategy;
import hotciv.standard.worldLayoutStrategies.AlphaWorldLayoutStrategy;

public class GammaCivFactory implements CivFactory {
    @Override
    public AgingStrategy createAgingStrategy() {
        return new AlphaAgingStrategy();
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
        return new AlphaWinningStrategy();
    }

    @Override
    public WorldLayoutStrategy createWorldLayoutStrategy() {
        return new AlphaWorldLayoutStrategy();
    }
}
