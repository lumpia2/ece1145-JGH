package hotciv.standard;

import hotciv.framework.*;

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
