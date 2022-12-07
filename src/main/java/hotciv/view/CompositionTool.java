package hotciv.view;

import hotciv.framework.Game;
import hotciv.framework.Position;
import minidraw.framework.DrawingEditor;
import minidraw.standard.NullTool;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class CompositionTool extends NullTool {
  private DrawingEditor editor;
  private Game game;
  private ActionTool actionTool;

  public CompositionTool(DrawingEditor editor, Game game)
  {
    this.editor = editor;
    this.game = game;
    this.actionTool = new ActionTool(editor, game);
  }

  public void mouseDown(MouseEvent e, int x, int y)
  {
    Position p = GfxConstants.getPositionFromXY(x, y);

    if(game.getUnitAt(p) != null)
    {
      if(e.isShiftDown())
      {
        // Call ActionTool
        System.out.println("ActionTool called");
        actionTool.mouseDown(e, x, y);
      }
      else
      {
        // Call SetFocusTool
        System.out.println("SetFocusTool called for Unit");

      }
    }
    else if(game.getCityAt(p) != null)
    {
      // Call SetFocusTool
      System.out.println("SetFocusTool called for City");
    }

    // End of Turn
    // Move Unit
  }


}
