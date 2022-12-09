package hotciv.view.tool;

import hotciv.framework.Game;
import hotciv.framework.Position;
import hotciv.view.GfxConstants;
import minidraw.framework.DrawingEditor;
import minidraw.standard.NullTool;

import java.awt.event.MouseEvent;

public class ActionTool extends NullTool {
  private Game game;
  private DrawingEditor editor;

  public ActionTool(DrawingEditor editor, Game game) {
    this.editor = editor;
    this.game = game;
  }

  public void mouseDown(MouseEvent e, int x, int y)
  {
    if(e.isShiftDown())
    {
      Position p = GfxConstants.getPositionFromXY(x, y);
      if(game.getUnitAt(p) != null)
      {
        game.performUnitActionAt(p);
        System.out.println("Unit Action Performed at" + p.toString());
      }
    }
  }
}
