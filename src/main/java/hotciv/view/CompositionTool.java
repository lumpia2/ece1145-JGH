package hotciv.view;

import hotciv.framework.Game;
import hotciv.framework.Position;
import hotciv.view.tool.ActionTool;
import hotciv.view.tool.EndOfTurnTool;
import hotciv.view.tool.MoveTool;
import hotciv.view.tool.SetFocusTool;
import minidraw.framework.DrawingEditor;
import minidraw.standard.NullTool;

import java.awt.event.MouseEvent;

public class CompositionTool extends NullTool {
  private DrawingEditor editor;
  private Game game;
  private ActionTool actionTool;
  private EndOfTurnTool endOfTurnTool;
  private SetFocusTool setFocusTool;
  private MoveTool moveTool;
  private Position from;
  private boolean dragging = false;

  public CompositionTool(DrawingEditor editor, Game game)
  {
    this.editor = editor;
    this.game = game;
    this.actionTool = new ActionTool(this.editor, this.game);
    this.endOfTurnTool = new EndOfTurnTool(this.game);
    this.setFocusTool = new SetFocusTool(this.editor, this.game);
    this.moveTool = new MoveTool(this.editor, this.game);
  }

  public void mouseDown(MouseEvent e, int x, int y)
  {
    Position p = GfxConstants.getPositionFromXY(x, y);

    boolean xShield = (x >= 560) && (x <= 588);
    boolean yShield = (y >= 65) && (y <= 104);

    if (xShield && yShield) {
      // call endOfturnTool
      System.out.println("EndOfTurnTool called");
      endOfTurnTool.mouseDown(e, x, y);
    }
    else if(game.getUnitAt(p) != null)
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
        moveTool.mouseDown(e,x,y);
        from = p;
      }
    }
    else if(game.getCityAt(p) != null)
    {
      // Call SetFocusTool
      System.out.println("SetFocusTool called for City");
      setFocusTool.mouseUp(e,x,y);
    }
  }

  public void mouseDrag(MouseEvent e, int x, int y)
  {
    dragging = true;
    moveTool.mouseDrag(e, x, y);
  }

  public void mouseUp(MouseEvent e, int x, int y)
  {
    Position p = GfxConstants.getPositionFromXY(x, y);

    if(dragging == true)
    {
      moveTool.mouseUp(e,x,y);
      dragging = false;
    }

    else if(game.getUnitAt(p) != null)
    {
      // Call SetFocusTool
      System.out.println("SetFocusTool called for Unit");
      setFocusTool.mouseUp(e,x,y);
    }
  }


}
