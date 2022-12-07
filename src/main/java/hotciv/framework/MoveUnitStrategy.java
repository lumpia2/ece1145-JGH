package hotciv.framework;

public interface MoveUnitStrategy {
    boolean moveUnit(Position from, Position to, Game game);
}
