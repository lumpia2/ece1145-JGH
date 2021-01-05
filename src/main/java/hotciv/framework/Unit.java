package hotciv.framework;

/** Represents a single unit in the game.

Responsibilities:
1) Know its type name.
2) Know its owner.
2) Know its defensive and attacking strengths.

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
public interface Unit {

  /** return the type of the unit
   * @return unit type as a string, valid values are at
   * least those listed in GameConstants, particular variants
   * may define more strings to be valid.
   */
  public String getTypeString();

  /** return the owner of this unit.
   * @return the player that controls this unit.
   */
  public Player getOwner();

  /** return the move distance left (move count).
   * A move count of N means the unit may travel
   * a distance of N in this turn. The move count
   * is reset to the units maximal value before
   * a new turn starts.
   * @return the move count
   */
  public int getMoveCount();
  
  /** return the defensive strength of this unit
   * @return defensive strength
   */
  public int getDefensiveStrength();
  
  /** return the attack strength of this unit
   * @return attack strength
   */
  public int getAttackingStrength();
}
