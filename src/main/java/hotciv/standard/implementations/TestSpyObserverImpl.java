package hotciv.standard.implementations;

import hotciv.framework.GameObserver;
import hotciv.framework.Player;
import hotciv.framework.Position;

public class TestSpyObserverImpl implements GameObserver {

    Position changedPos;
    Position focusedPos;
    Player nextPlayer;
    int age;

    public TestSpyObserverImpl() {}
    @Override
    public void worldChangedAt(Position pos) {
        System.out.print("Position changed at" + pos + "\n");
        this.changedPos = pos;
    }

    @Override
    public void turnEnds(Player nextPlayer, int age) {
        System.out.print("Next player: " + nextPlayer + ". Game age: " + age + "\n");
        this.nextPlayer = nextPlayer;
        this.age = age;
    }

    @Override
    public void tileFocusChangedAt(Position position) {
        System.out.print("Position focused at" + position + "\n");
        this.focusedPos = position;
    }

    public Position getChangedPos() {
        return changedPos;
    }

    public Position getFocusedPos() {
        return focusedPos;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    public int getAge() {
        return age;
    }

}