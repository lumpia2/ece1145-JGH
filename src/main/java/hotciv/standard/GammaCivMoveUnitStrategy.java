
package hotciv.standard;

import hotciv.framework.*;
import hotciv.standard.UnitImpl;

import java.util.HashMap;
import java.lang.Math;

public class GammaCivMoveUnitStrategy implements MoveUnitStrategy {
    public boolean moveUnit(Position from, Position to, Game game) {
        // If no unit at origin return false
        if(game.getUnitAt(from)==null)
        {
            return false;
        }

        // If unit is archer and fortified, return false
        if (game.getUnitAt(from).getTypeString() == GameConstants.ARCHER && ((UnitImpl) game.getUnitAt(from)).getFortified() == true) {
            return false;
        }

        if(to.getColumn() < 0 || to.getColumn() >= GameConstants.WORLDSIZE)
        {
            return false;
        }

        if(to.getRow() < 0 || to.getRow() >= GameConstants.WORLDSIZE)
        {
            return false;
        }

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
            ((UnitImpl) fromUnit).decreaseMoveCount();
            game.removeFromWorld(from, fromUnit);
            return true;
        }

        // If unit at destination, remove unit at destination. add from unit to destination, and remove from origin
        if(game.getUnitAt(to) != null)
        {
            Unit toUnit = game.getUnitAt(to);
            Unit fromUnit = game.getUnitAt(from);
            game.removeFromWorld(to, toUnit);
            game.addToWorld(to, fromUnit);
            ((UnitImpl) fromUnit).decreaseMoveCount();
            game.removeFromWorld(from, fromUnit);
            return true;
        }

        return false;
    }
}

