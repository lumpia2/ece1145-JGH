package hotciv.framework;

public interface CivFactory {

    // Creation of strategies
    public AgingStrategy createAgingStrategy();
    public MoveUnitStrategy createMoveUnitStrategy();
    public UnitActionStrategy createUnitActionStrategy();
    public WinningStrategy createWinningStrategy();
    public WorldLayoutStrategy createWorldLayoutStrategy();
}
