package hotciv.standard;

import hotciv.framework.*;

import java.util.HashMap;

public class GameTranscriptDecorator implements Game {
    private Game game;

    public GameTranscriptDecorator(Game game)
    {
        this.game = game;
        Player currPlayer = game.getPlayerInTurn();

        System.out.println("Game created.");
        System.out.println(currPlayer.toString() + " player starts first.");
    }
    @Override
    public Tile getTileAt(Position p)
    {
        Tile currTile = game.getTileAt(p);

        if (currTile != null)
        {
            System.out.println(currTile.toString() + " at " + p.toString() + ".");

        } else
        {
            System.out.println("Tile doesn't exist at " + p.toString() + ".");
        }

        return currTile;
    }

    @Override
    public Unit getUnitAt(Position p)
    {
        Unit currUnit = game.getUnitAt(p);

        if (currUnit != null)
        {
            System.out.println(currUnit.toString() + " at " + p.toString() + ".");
        } else
        {
            System.out.println("No unit at " + p.toString() + ".");
        }

        return currUnit;
    }

    @Override
    public City getCityAt(Position p)
    {
        City currCity = game.getCityAt(p);

        if (currCity != null)
        {
            System.out.println(currCity.toString() + " at " + p.toString() + ".");
        } else
        {
            System.out.println("No city at " + p.toString() + ".");
        }

        return currCity;
    }

    @Override
    public Player getPlayerInTurn()
    {
        Player currPlayer = game.getPlayerInTurn();

        System.out.println(currPlayer + " player is at turn now.");

        return currPlayer;
    }

    @Override
    public Player getWinner()
    {
        Player winner = game.getWinner();

        if (winner != null)
        {
            System.out.println(winner.toString() + " is the winner.");
        } else
        {
            System.out.println("No one is the winner yet.");
        }

        return winner;
    }

    @Override
    public int getAge()
    {
        return game.getAge();
    }

    @Override
    public boolean moveUnit(Position from, Position to)
    {
        Player currPlayer = game.getPlayerInTurn();
        Unit currUnit = game.getUnitAt(from);
        boolean hasMoved = game.moveUnit(from, to);

        if (hasMoved)
        {
            System.out.println(currPlayer.toString() + " player moves " + currUnit.toString() +
                    " from " + from.toString() + " to " + to.toString());
        } else
        {
            System.out.println(currPlayer.toString() + " player could not move " + currUnit.toString() +
                    " from " + from.toString() + " to " + to.toString());
        }

        return hasMoved;
    }

    @Override
    public void endOfTurn()
    {
        Player currPlayer = game.getPlayerInTurn();

        System.out.println(currPlayer.toString() + " player ends turn.");

        game.endOfTurn();
    }

    @Override
    public void changeWorkForceFocusInCityAt(Position p, String balance)
    {
        Player currPlayer = game.getPlayerInTurn();

        System.out.println(currPlayer.toString() + " player changes work force focus in city at " +
                p.toString() + " to " + balance + ".");

        game.changeWorkForceFocusInCityAt(p, balance);
    }

    @Override
    public void changeProductionInCityAt(Position p, String unitType)
    {
        Player currPlayer = game.getPlayerInTurn();

        System.out.println(currPlayer.toString() + " player changes production in city at " +
                p.toString() + " to " + unitType + ".");

        game.changeProductionInCityAt(p, unitType);
    }

    @Override
    public void performUnitActionAt(Position p)
    {
        Player currPlayer = game.getPlayerInTurn();
        Unit currUnit = game.getUnitAt(p);

        System.out.println(currPlayer.toString() + " player performs unit action at " +
                p.toString() + ".");

        game.performUnitActionAt(p);
    }

    @Override
    public void addToWorld(Position p, Unit u)
    {
        System.out.println(u.toString() + " added at " + p.toString() + ".");

        game.addToWorld(p, u);
    }

    @Override
    public void addToWorld(Position p, City c)
    {
        System.out.println(c.toString() + " added at " + p.toString() + ".");

        game.addToWorld(p, c);
    }

    @Override
    public void removeFromWorld(Position p, Unit u)
    {
        System.out.println(u.toString() + " removed from " + p.toString() + ".");

        game.removeFromWorld(p, u);
    }

    @Override
    public void removeFromWorld(Position p, City c)
    {
        System.out.println(c.toString() + " removed from " + p.toString() + ".");

        game.removeFromWorld(p, c);
    }

    public void addObserver(GameObserver observer) {

    }

    public void setTileFocus(Position position) {

    }
}
