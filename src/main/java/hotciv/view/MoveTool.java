package hotciv.view;

import hotciv.framework.Game;
import hotciv.framework.Position;
import minidraw.framework.Drawing;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.framework.Tool;
import minidraw.standard.NullTool;
import minidraw.standard.handlers.DragTracker;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MoveTool extends NullTool {
    private Game game;
    private DrawingEditor editor;
    private Position from;
    protected Tool fChild;
    protected Tool cacheNullTool;
    protected Figure draggedFigure;

    public MoveTool(DrawingEditor editor, Game game) {
        this.editor = editor;
        this.game = game;
        fChild = cacheNullTool = new NullTool();
    }

    public void mouseDown(MouseEvent e, int x, int y) {
        Drawing model = editor.drawing();

        model.lock();

        draggedFigure = model.findFigure(x,y);

        // Turn pixel position into tile position
        from = GfxConstants.getPositionFromXY(x,y);


        if (draggedFigure != null && game.getUnitAt(from) != null) {
            fChild = createDragTracker(draggedFigure);
            fChild.mouseDown(e, x, y);
        }
    }

    public void mouseDrag(MouseEvent e, int x, int y) { fChild.mouseDrag(e,x,y); }

    public void mouseMove(MouseEvent e, int x, int y) {
        fChild.mouseMove(e, x, y);
    }

    public void mouseUp(MouseEvent e, int x, int y) {
        // Turn pixel position to tile position
        Position to = GfxConstants.getPositionFromXY(x,y);

        // Checks valid movement, if not return to original spot
        if (game.moveUnit(from, to)) {
            Drawing model = editor.drawing();

            model.unlock();

            int dx = GfxConstants.getXFromColumn(to.getColumn());
            int dy = GfxConstants.getYFromRow(to.getRow());

            fChild.mouseUp(e,dx,dy);
        } else {
            int dx = GfxConstants.getXFromColumn(from.getColumn());
            int dy = GfxConstants.getYFromRow(from.getRow());

            fChild.mouseUp(e,dx,dy);
            fChild = cacheNullTool;
            draggedFigure = null;
        }

    }

    protected Tool createDragTracker(Figure f) {
        return new DragTracker(editor, f);
    }
}
