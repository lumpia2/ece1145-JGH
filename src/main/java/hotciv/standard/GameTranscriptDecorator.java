package hotciv.standard;

import hotciv.framework.*;

public class GameTranscriptDecorator implements Game {
    private Game game;

    public GameTranscriptDecorator(Game game) {
        
    }
    @Override
    public Tile getTileAt(Position p) {
        return null;
    }

    @Override
    public Unit getUnitAt(Position p) {
        return null;
    }

    @Override
    public City getCityAt(Position p) {
        return null;
    }

    @Override
    public Player getPlayerInTurn() {
        return null;
    }

    @Override
    public Player getWinner() {
        return null;
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public boolean moveUnit(Position from, Position to) {
        return false;
    }

    @Override
    public void endOfTurn() {

    }

    @Override
    public void changeWorkForceFocusInCityAt(Position p, String balance) {

    }

    @Override
    public void changeProductionInCityAt(Position p, String unitType) {

    }

    @Override
    public void performUnitActionAt(Position p) {

    }

    @Override
    public void addToWorld(Position p, Unit u) {

    }

    @Override
    public void addToWorld(Position p, City c) {

    }

    @Override
    public void removeFromWorld(Position p, Unit u) {

    }

    @Override
    public void removeFromWorld(Position p, City c) {

    }
}
