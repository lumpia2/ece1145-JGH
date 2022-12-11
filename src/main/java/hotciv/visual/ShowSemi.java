package hotciv.visual;

import hotciv.framework.Game;
import hotciv.standard.factories.SemiCivFactory;
import hotciv.standard.implementations.GameImpl;
import hotciv.view.CompositionTool;
import minidraw.framework.*;
import minidraw.standard.*;

public class ShowSemi {

  public static void main(String[] args) {
    Game game = new GameImpl(new SemiCivFactory());

    DrawingEditor editor =
        new MiniDrawApplication( "Test Game for SemiCiv",
            new HotCivFactory4(game) );

    editor.open();
    editor.showStatus("");

    editor.setTool( new CompositionTool(editor, game) );
  }
}
