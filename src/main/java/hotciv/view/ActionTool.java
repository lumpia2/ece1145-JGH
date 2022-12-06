package hotciv.view;

import hotciv.framework.Game;
import hotciv.framework.Position;
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

  public void MouseDown(MouseEvent e, int x, int y)
  {
    if(e.isShiftDown())
    {
      Position p = GfxConstants.getPositionFromXY(x, y);
      if(game.getUnitAt(p) != null)
      {
        game.performUnitActionAt(p);
      }
    }
  }
}
