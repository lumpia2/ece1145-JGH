package hotciv.view;

import hotciv.framework.Game;
import minidraw.framework.DrawingEditor;
import minidraw.standard.NullTool;

public class MoveTool extends NullTool {
    private Game game;
    private DrawingEditor editor;
    public MoveTool(DrawingEditor editor, Game game) {
        this.editor = editor;
        this.game = game;
    }
}
