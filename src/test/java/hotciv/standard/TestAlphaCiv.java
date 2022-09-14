package hotciv.standard;

import hotciv.framework.*;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.*;

/** Skeleton class for AlphaCiv test cases

    Updated Oct 2015 for using Hamcrest matchers

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
public class TestAlphaCiv {
  private Game game;

  /** Fixture for alphaciv testing. */
  @Before
  public void setUp() {
    game = new GameImpl();
    game.createMap();
  }

  @Test
  public void oceanAt_1_0() {
    assertEquals(GameConstants.OCEANS, game.getTileAt(new Position(1,0)).getTypeString());
  }

  @Test
  public void hillsAt_0_1() {
    assertEquals(GameConstants.HILLS, game.getTileAt(new Position(0,1)).getTypeString());
  }

  @Test
  public void mountainsAt_2_2() {
    assertEquals(GameConstants.MOUNTAINS, game.getTileAt(new Position(2, 2)).getTypeString());
  }

  // FRS p. 455 states that 'Red is the first player to take a turn'.
  @Test
  public void shouldBeRedAsStartingPlayer() {
    assertThat(game, is(notNullValue()));
    assertThat(game.getPlayerInTurn(), is(Player.RED));
  }

  @Test
  public void redArcherAt_2_0() {
    assertEquals(GameConstants.ARCHER, game.getUnitAt(new Position(2,0)).getTypeString());
  }

  @Test
  public void redSettlerAt_4_3() {
    assertEquals(GameConstants.SETTLER, game.getUnitAt(new Position(4,3)).getTypeString());
  }

  @Test
  public void nextPlayerBlue() {
    game.endOfTurn();
    assertThat(game.getPlayerInTurn(), is(Player.BLUE));
  }

  public void blueLegionAt_3_2() {
    assertEquals(GameConstants.LEGION, game.getUnitAt(new Position(3,2)).getTypeString());
  }
}
