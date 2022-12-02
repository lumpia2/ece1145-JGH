package hotciv.framework;

/** Defines the Observer role for a Game.
 * 

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
public interface GameObserver {
  /** invoked every time some change occurs on a position
   * in the world - a unit disappears or appears, a
   * city appears, a city changes player color, or any
   * other event that requires the GUI to redraw the
   * graphics on a particular position.
   * @param pos the position in the world that has changed state
   */
  public void worldChangedAt(Position pos);

  /** invoked just after the game's end of turn is called
   * to signal the new "player in turn" and world age state.
   * @param nextPlayer the next player that may move units etc.
   * @param age the present age of the world
   */
  public void turnEnds(Player nextPlayer, int age);
    
  /** invoked whenever the user changes focus to another
   * tile (for inspecting the tile's unit and city
   * properties.)
   * @param position the position of the tile that is
   * now inspected/has focus.
   */
  public void tileFocusChangedAt(Position position);
}
