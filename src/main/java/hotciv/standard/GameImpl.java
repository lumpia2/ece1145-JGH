package hotciv.standard;

import hotciv.framework.*;
import java.util.HashMap;

/** Skeleton implementation of HotCiv.
 
   This source code is from the book 
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Department of Computer Science
     Aarhus University
   
   Please visit http://www.baerbak.com/ for further information.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
 
       http://www.apache.org/licenses/LICENSE-2.0
 
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/

public class GameImpl implements Game {
  public HashMap<Position, TileImpl> tiles = new HashMap<Position, TileImpl>();
  public Tile getTileAt( Position p ) { return tiles.get(p); }
  public Unit getUnitAt( Position p ) { return null; }
  public City getCityAt( Position p ) { return null; }
  public Player getPlayerInTurn() { return Player.RED; }
  public Player getWinner() { return null; }
  public int getAge() { return 0; }
  public boolean moveUnit( Position from, Position to ) {
    return false;
  }
  public void endOfTurn() {}
  public void changeWorkForceFocusInCityAt( Position p, String balance ) {}
  public void changeProductionInCityAt( Position p, String unitType ) {}
  public void performUnitActionAt( Position p ) {}

  public void createMap() {
    String type = GameConstants.PLAINS;

    for (int i = 0; i < GameConstants.WORLDSIZE; i++) {
      for (int j = 0; j < GameConstants.WORLDSIZE; j++) {
        if (i == 1 && j == 0) {
          type = GameConstants.OCEANS;
        } else if (i == 0 && j == 1) {
          type = GameConstants.HILLS;
        } else if (i == 2 && j == 2) {
          type = GameConstants.MOUNTAINS;
        }

        tiles.put(new Position(i, j), new TileImpl(type));
      }
    }
  }
}
