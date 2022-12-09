package hotciv.view.tool;

import hotciv.framework.Game;
import hotciv.framework.Position;
import hotciv.view.GfxConstants;
import minidraw.framework.Drawing;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.framework.Tool;
import minidraw.standard.NullTool;
import minidraw.standard.SelectionTool;
import minidraw.standard.handlers.DragTracker;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MoveTool extends SelectionTool {
    private Game game;
    private DrawingEditor editor;
    private Position from;

    public MoveTool(DrawingEditor editor, Game game) {
        super(editor);
        this.game = game;
    }

    public boolean isUnit(int x, int y) {
        from = GfxConstants.getPositionFromXY(x,y);

        if (game.getUnitAt(from) != null)
            return true;

        return false;
    }

    public void mouseDown(MouseEvent e, int x, int y) {
        if (isUnit(x,y))
            super.mouseDown(e,x,y);
    }

    public void mouseDrag(MouseEvent e, int x, int y) {
        if (isUnit(x,y))
            super.mouseDrag(e,x,y); }

    public void mouseUp(MouseEvent e, int x, int y) {

        if (isUnit(x,y)) {
            super.mouseUp(e,x,y);

            // Turn pixel position to tile position
            Position to = GfxConstants.getPositionFromXY(x,y);
            game.moveUnit(from,to);
        }
    }
}
