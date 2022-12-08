package hotciv.view;

import hotciv.framework.Game;
import hotciv.framework.Position;
import minidraw.framework.Drawing;
import minidraw.framework.DrawingEditor;
import minidraw.framework.Figure;
import minidraw.standard.NullTool;

import java.awt.event.MouseEvent;

public class EndOfTurnTool extends NullTool {
    private Game game;
    private DrawingEditor editor;
    protected Position turnShield =
            GfxConstants.getPositionFromXY(GfxConstants.TURN_SHIELD_X, GfxConstants.TURN_SHIELD_Y);


    public  EndOfTurnTool(DrawingEditor editor, Game game) {
        this.editor = editor;
        this.game = game;
    }

    public void mouseUp(MouseEvent e, int x, int y) {
        Drawing model = editor.drawing();

        model.lock();



        Position p = GfxConstants.getPositionFromXY(x,y);

        if (p == turnShield) {
            game.endOfTurn();
            // change shield to player color
        }
    }
}
