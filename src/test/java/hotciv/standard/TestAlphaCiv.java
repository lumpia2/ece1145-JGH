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

    game = new GameImpl(new AlphaCivFactory());

  }
  // Comment for hotfix release 2.1
  @Test
  public void productionOfCityIsArcher() {
    City redCity = game.getCityAt(new Position(1,1));
    game.changeProductionInCityAt(new Position(1,1), GameConstants.ARCHER);
    assertEquals(redCity.getProduction(), GameConstants.ARCHER);
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

  @Test
  public void plainsElsewhere(){
    for (int i = 0; i < GameConstants.WORLDSIZE; i++) {
      for (int j = 0; j < GameConstants.WORLDSIZE; j++) {
        if ((i == 1 && j == 0) || (i == 0 && j == 1) || (i == 2 && j == 2))
          continue;
        assertEquals(GameConstants.PLAINS, game.getTileAt(new Position(i,j)).getTypeString());
      }
    }
  }
  @Test
  public void shouldBeRedAsStartingPlayer() {
    assertThat(game, is(notNullValue()));
    assertThat(game.getPlayerInTurn(), is(Player.RED));
  }

  // Aging test cases
  @Test
  public void startingAgeShouldBeNeg4000() {
      assertThat(game.getAge(), is(-4000));
  }

  @Test
  public void endOfRoundAdvancesAge100Years() {
      game.endOfTurn();
      game.endOfTurn();
      assertThat(game.getAge(), is(-3900));
  }

  // Winning Test Cases
  @Test
  public void winnerIsNullIfGameNotOver() {
      assertThat(game.getWinner(), is(nullValue()));
  }

  @Test
  public void winnerIsRedWhenAge3000() {
      for(int i=0; i<20; i++)
      {
          game.endOfTurn();
      }
      assertThat(game.getWinner(), is(Player.RED));
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

  @Test
  public void blueLegionAt_3_2() {
    assertEquals(GameConstants.LEGION, game.getUnitAt(new Position(3,2)).getTypeString());
  }

  @Test
  public void attackerAlwaysWins() {
    assertThat(game.moveUnit(new Position(2,0 ), new Position(3, 2)), is(true));
  }

  @Test
  public void checkCities() {
    City redCity = game.getCityAt(new Position(1,1));
    City blueCity = game.getCityAt(new Position(4,1));

    assertThat(redCity, is(notNullValue()));
    assertThat(blueCity, is(notNullValue()));
  }
  @Test
  public void checkCitySize() {
    City redCity = game.getCityAt(new Position(1,1));
    City blueCity = game.getCityAt(new Position(4,1));

    assertThat(redCity.getSize(), is(1));
    assertThat(blueCity.getSize(), is(1));
  }

  @Test
  public void checkCityProd() {
    City redCity = game.getCityAt(new Position(1,1));
    City blueCity = game.getCityAt(new Position(4,1));

    assertThat(redCity.getTreasury(), is(0));
    assertThat(blueCity.getTreasury(), is(0));
    game.endOfTurn();
    game.endOfTurn();
    assertThat(redCity.getTreasury(), is(6));
    assertThat(blueCity.getTreasury(), is(6));
  }

  @Test
  public void cityProducesArcher() {
    City redCity = game.getCityAt(new Position(1,1));
    City blueCity = game.getCityAt(new Position(4,1));
    game.changeProductionInCityAt(new Position(1,1), GameConstants.ARCHER);
    game.changeProductionInCityAt(new Position(4,1), GameConstants.ARCHER);

    game.endOfTurn();
    game.endOfTurn();

    game.endOfTurn();
    game.endOfTurn();

    assertEquals(GameConstants.ARCHER, game.getUnitAt(new Position(1,1)).getTypeString());
  }

  @Test
  public void unitAboveCityWhenCenterOccupied() {
    City redCity = game.getCityAt(new Position(1,1));
    game.changeProductionInCityAt(new Position(1,1), GameConstants.ARCHER);

    game.endOfTurn(); game.endOfTurn(); // Treasury 6
    game.endOfTurn(); game.endOfTurn(); // Treasury 2 unit at center
    game.endOfTurn(); game.endOfTurn(); // Treasury 8
    game.endOfTurn(); game.endOfTurn(); // Treasury 4 unit above

    assertEquals(GameConstants.ARCHER, game.getUnitAt(new Position(0,1)).getTypeString());
  }

  @Test
  public void cityTreasuryDecreasesWhenUnitProduced() {
    City redCity = game.getCityAt(new Position(1,1));
    game.changeProductionInCityAt(new Position(1,1), GameConstants.ARCHER);

    game.endOfTurn(); game.endOfTurn(); // Treasury = 6
    game.endOfTurn(); game.endOfTurn(); // Treasury = 12 - 10 for archer production

    assertThat(redCity.getTreasury(), is(2));
  }

  @Test
  public void settlerDoesNothing() {
    game.performUnitActionAt(new Position(4, 3));

    assertThat(game.getCityAt(new Position(4,3)), is(nullValue()));
    assertEquals(GameConstants.SETTLER, game.getUnitAt(new Position(4,3)).getTypeString());
  }
}
