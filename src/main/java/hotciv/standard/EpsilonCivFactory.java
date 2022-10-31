package hotciv.standard;

import hotciv.framework.*;

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
