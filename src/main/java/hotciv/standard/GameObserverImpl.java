package hotciv.standard;

import hotciv.framework.GameObserver;
import hotciv.framework.Player;
import hotciv.framework.Position;

public class GameObserverImpl implements GameObserver {

    public GameObserverImpl() {}
    @Override
    public void worldChangedAt(Position pos) {

    }

    @Override
    public void turnEnds(Player nextPlayer, int age) {

    }

    @Override
    public void tileFocusChangedAt(Position position) {

    }
}
