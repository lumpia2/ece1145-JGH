package hotciv.standard;

import hotciv.framework.Tile;

public class TileImpl implements Tile {
    private String type;

    public  TileImpl(String type) { this.type = type; }

    @Override
    public  String getTypeString(){
        return type;
    }
}
