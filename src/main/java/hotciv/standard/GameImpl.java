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

  private HashMap<Position, TileImpl> tiles = new HashMap<>();
  private HashMap<Position, UnitImpl> units = new HashMap<>();

  private HashMap<Position, CityImpl> cities = new HashMap<>();

  private Player currentPlayer = Player.RED;

  private int age;

  public GameImpl()
  {
    this.age = 4000;
  }

  public Tile getTileAt( Position p ) { return tiles.get(p); }
  public Unit getUnitAt( Position p ) { return units.get(p); }
  public City getCityAt( Position p ) { return cities.get(p); }
  public Player getPlayerInTurn() { return currentPlayer; }

  public Player getWinner() {
    if(this.getAge() == 3000)
    {
      return Player.RED;
    }
    else
    {
      return null;
    }
  }

  public int getAge() {
    return age;
  }

  public boolean moveUnit( Position from, Position to ) {
    return true;
  }
  public void endOfTurn() {
    if (currentPlayer == Player.RED) {
      currentPlayer = Player.BLUE;
    }
    else if (currentPlayer == Player.BLUE) {
      currentPlayer = Player.RED;
      this.age -= 100;

      for (Position i : cities.keySet()) {
        City city = this.getCityAt(i);

        ((CityImpl) city).incrementTreasury();
      }
    }
  }

  public void changeWorkForceFocusInCityAt( Position p, String balance ) {}
  public void changeProductionInCityAt( Position p, String unitType ) {}
  public void performUnitActionAt( Position p ) {}

  public void createMap() {

    for (int i = 0; i < GameConstants.WORLDSIZE; i++) {
      for (int j = 0; j < GameConstants.WORLDSIZE; j++) {
        String tileType = GameConstants.PLAINS;
        if (i == 1 && j == 0) {
          tileType = GameConstants.OCEANS;
        } else if (i == 0 && j == 1) {
          tileType = GameConstants.HILLS;
        } else if (i == 2 && j == 2) {
          tileType = GameConstants.MOUNTAINS;
        }

        if (i==2 && j==0) { units.put(new Position(i,j), new UnitImpl(GameConstants.ARCHER, Player.RED)); }
        if (i==3 && j==2) { units.put(new Position(i,j), new UnitImpl(GameConstants.LEGION, Player.BLUE)); }
        if (i==4 && j==3) { units.put(new Position(i,j), new UnitImpl(GameConstants.SETTLER, Player.RED)); }

        if (i==1 && j==1) { cities.put(new Position(i,j), new CityImpl(Player.RED)); }
        if (i==4 && j==1) { cities.put(new Position(i,j), new CityImpl(Player.BLUE)); }

        tiles.put(new Position(i, j), new TileImpl(tileType));
      }
    }
  }
}
