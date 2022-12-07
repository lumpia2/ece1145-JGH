package hotciv.standard.factories;

import hotciv.framework.*;
import hotciv.standard.actionStrategies.AlphaCivActionStrategy;
import hotciv.standard.agingStrategies.AlphaAgingStrategy;
import hotciv.standard.moveUnitStrategies.EpsilonCivMoveUnitStrategy;
import hotciv.standard.winningStrategies.EpsilonWinningStrategy;
import hotciv.standard.worldLayoutStrategies.AlphaWorldLayoutStrategy;

public class EpsilonCivFactory implements CivFactory {
    @Override
    public AgingStrategy createAgingStrategy() {
        return new AlphaAgingStrategy();
    }

    @Override
    public MoveUnitStrategy createMoveUnitStrategy() { return new EpsilonCivMoveUnitStrategy(); }

    @Override
    public UnitActionStrategy createUnitActionStrategy() {
        return new AlphaCivActionStrategy();
    }

    @Override
    public WinningStrategy createWinningStrategy() {
        return new EpsilonWinningStrategy();
    }

    @Override
    public WorldLayoutStrategy createWorldLayoutStrategy() {
        return new AlphaWorldLayoutStrategy();
    }
}
