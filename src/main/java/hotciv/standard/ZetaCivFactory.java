package hotciv.standard;

import hotciv.framework.*;

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
