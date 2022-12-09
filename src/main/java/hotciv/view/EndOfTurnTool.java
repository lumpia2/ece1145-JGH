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


    public EndOfTurnTool(Game game) {
        this.game = game;
    }

    public void mouseDown(MouseEvent e, int x, int y) {
        boolean xShield = (x >= 560) && (x <= 588);
        boolean yShield = (y >= 65) && (y <= 104);

        if (xShield && yShield)
            game.endOfTurn();
    }
}
