package hotciv.stub;

import hotciv.framework.*;

import java.util.HashMap;
import java.util.Map;

/** Test stub for game for visual testing of
 * minidraw based graphics.

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

public class StubGame1 implements Game {

  public StubGame1() { 
    world = defineWorld(); 
  }

  public Unit getUnitAt( Position p ) { return null; }
  public City getCityAt( Position p ) { return null; }
  public Player getPlayerInTurn() { return null; }
  public Player getWinner() { return null; }
  public int getAge() { return 0; }  
  public boolean moveUnit( Position from, Position to ) { return true; }
  public void endOfTurn() {}
  public void changeWorkForceFocusInCityAt( Position p, String balance ) {}
  public void changeProductionInCityAt( Position p, String unitType ) {}
  public void performUnitActionAt( Position p ) {}

  public void addToWorld(Position p, Unit u) {

  }

  public void addToWorld(Position p, City c) {

  }

  public void removeFromWorld(Position p, Unit u) {

  }

  public void removeFromWorld(Position p, City c) {

  }

  public void addObserver(GameObserver observer) {} 
  public void setTileFocus(Position position) {}

  // A simple implementation to draw the map of DeltaCiv
  protected Map<Position,Tile> world; 
  public Tile getTileAt( Position p ) { return world.get(p); }


  /** Define the world as the DeltaCiv layout */
  private Map<Position,Tile> defineWorld() {
    // Basically we use a 'data driven' approach - code the
    // layout in a simple semi-visual representation, and
    // convert it to the actual Game representation.
    String[] layout =
      new String[] {
          "...ooMooooo.....",
          "..ohhoooofffoo..",
          ".oooooMooo...oo.",
          ".ooMMMoooo..oooo",
          "...ofooohhoooo..",
          ".ofoofooooohhoo.",
          "...ooo..........",
          ".ooooo.ooohooM..",
          ".ooooo.oohooof..",
          "offfoooo.offoooo",
          "oooooooo...ooooo",
          ".ooMMMoooo......",
          "..ooooooffoooo..",
          "....ooooooooo...",
          "..ooohhoo.......",
          ".....ooooooooo..",
         };
    // Conversion...
    Map<Position,Tile> theWorld = new HashMap<Position,Tile>();
    String line;
    for ( int r = 0; r < GameConstants.WORLDSIZE; r++ ) {
      line = layout[r];
      for ( int c = 0; c < GameConstants.WORLDSIZE; c++ ) {
        char tileChar = line.charAt(c);
        String type = "error";
        if ( tileChar == '.' ) { type = GameConstants.OCEANS; }
        if ( tileChar == 'o' ) { type = GameConstants.PLAINS; }
        if ( tileChar == 'M' ) { type = GameConstants.MOUNTAINS; }
        if ( tileChar == 'f' ) { type = GameConstants.FOREST; }
        if ( tileChar == 'h' ) { type = GameConstants.HILLS; }
        Position p = new Position(r,c);
        theWorld.put( p, new StubTile(type));
      }
    }
    return theWorld;
  }
}
