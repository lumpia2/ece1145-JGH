package hotciv.view.tool;

import hotciv.framework.Game;
import hotciv.framework.Position;
import hotciv.view.GfxConstants;
import minidraw.framework.DrawingEditor;
import minidraw.standard.NullTool;

import java.awt.event.MouseEvent;

public class SetFocusTool extends NullTool {
    private DrawingEditor editor;
    private Game game;
    private Position from;

    public SetFocusTool(DrawingEditor editor, Game game) {
        this.editor = editor;
        this.game = game;
    }

    public boolean isUnit(int x, int y) {
        from = GfxConstants.getPositionFromXY(x,y);

        if (game.getUnitAt(from) != null)
            return true;

        return false;
    }

    public boolean isCity(int x, int y) {
        from = GfxConstants.getPositionFromXY(x,y);

        if (game.getCityAt(from) != null)
            return true;

        return false;
    }

    public void mouseUp(MouseEvent e, int x, int y) {
        if(isUnit(x,y) || isCity(x,y)) {
            game.setTileFocus(from);
        }
    }
}
