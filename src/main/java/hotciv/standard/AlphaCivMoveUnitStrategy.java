package hotciv.standard;

import hotciv.framework.*;

import java.util.HashMap;
import java.lang.Math;

public class AlphaCivMoveUnitStrategy implements MoveUnitStrategy {
    public boolean moveUnit(Position from, Position to, Game game) {
        // If trying to move to mountains or ocean return false
        if(game.getTileAt(to).getTypeString().equals(GameConstants.MOUNTAINS) || game.getTileAt(to).getTypeString().equals(GameConstants.OCEANS))
        {
            return false;
        }

        // If there is a unit at the destination and it belongs to the player return false
        if(game.getUnitAt(to) != null && (game.getUnitAt(to).getOwner().equals(game.getPlayerInTurn())))
        {
            return false;
        }

        // If unit being moved does not belong to player return false
        if(!game.getUnitAt(from).getOwner().equals(game.getPlayerInTurn()))
        {
            return false;
        }

        // If unit trying to be moved does not have any moves left
        if(game.getUnitAt(from).getMoveCount() == 0)
        {
            return false;
        }

        // If trying to move more than 1 tile return false
        if(Math.abs(to.getRow() - from.getRow()) > 1 || Math.abs(to.getColumn() - from.getColumn()) > 1)
        {
            return false;
        }

        // If no unit at destination add unit at destination and remove from origin
        if(game.getUnitAt(to) == null)
        {
            Unit fromUnit = game.getUnitAt(from);
            game.addToWorld(to, fromUnit);
            game.removeFromWorld(from, fromUnit);
        }

        // If unit at destination, remove unit at destination. add from unit to destination, and remove from origin
        if(game.getUnitAt(to) != null)
        {
            Unit toUnit = game.getUnitAt(to);
            Unit fromUnit = game.getUnitAt(from);
            game.removeFromWorld(to, toUnit);
            game.addToWorld(to, fromUnit);
            game.removeFromWorld(from, fromUnit);

        }

        return true;
    }
}
