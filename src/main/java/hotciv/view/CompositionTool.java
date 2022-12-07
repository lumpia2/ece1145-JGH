package hotciv.view;

import hotciv.framework.Game;
import minidraw.framework.DrawingEditor;
import minidraw.standard.NullTool;

public class CompositionTool extends NullTool {
  private DrawingEditor editor;
  private Game game;

  public CompositionTool(DrawingEditor editor, Game game)
  {
    this.editor = editor;
    this.game = game;


  }


}
