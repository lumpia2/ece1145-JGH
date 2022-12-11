package hotciv.view.tool;

import hotciv.framework.Game;
import hotciv.framework.Position;
import hotciv.view.GfxConstants;
import hotciv.view.UnitFigure;
import minidraw.framework.Drawing;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.framework.Tool;
import minidraw.standard.NullTool;
import minidraw.standard.SelectionTool;
import minidraw.standard.handlers.DragTracker;

import java.awt.event.MouseEvent;


public class MoveTool extends NullTool {
    private Game game;
    private DrawingEditor editor;
    private Figure draggedFigure;
    private Tool fChild;
    private Tool cachedNullTool;
    private int fromX;
    private int fromY;


    public MoveTool(DrawingEditor editor, Game game) {
        this.editor = editor;
        this.game = game;
        fChild = cachedNullTool = new NullTool();
    }

    @Override
    public void mouseDown(MouseEvent e, int x, int y){
        Drawing model = editor.drawing();
        model.lock();
        fromX = x;
        fromY = y;

        draggedFigure = model.findFigure(x, y);
        if(draggedFigure != null && draggedFigure instanceof UnitFigure) {
            fChild = createDragTracker(draggedFigure);
            fChild.mouseDown(e, x, y);
        }
    }

    @Override
    public void mouseDrag(MouseEvent e, int x, int y){
        fChild.mouseDrag(e, x, y);
    }

    @Override
    public void mouseMove(MouseEvent e, int x, int y) {
        fChild.mouseMove(e, x, y);
    }


    @Override
    public void mouseUp(MouseEvent e, int x, int y){
        editor.drawing().unlock();
        boolean canMove;

        if(draggedFigure instanceof UnitFigure){
            Position from = GfxConstants.getPositionFromXY(fromX, fromY);
            Position to = GfxConstants.getPositionFromXY(x,y);

            canMove = game.moveUnit(from, to);

            if(!canMove){
                draggedFigure.moveBy(fromX - x, fromY - y);
            }


        }

        fChild.mouseUp(e, x, y);
        fChild = cachedNullTool;
        draggedFigure = null;
    }
    private Tool createDragTracker(Figure draggedFigure) {
        return new DragTracker(editor, draggedFigure);
    }
}
