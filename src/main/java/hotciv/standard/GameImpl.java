package hotciv.standard;

import hotciv.framework.*;

import java.util.HashMap;
import java.util.Iterator;

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

  private HashMap<Position, Tile> tiles = new HashMap<>();
  private HashMap<Position, Unit> units = new HashMap<>();
  private HashMap<Position, City> cities = new HashMap<>();

//  private HashMap<Position, Tile> tiles;
//  private HashMap<Position, Unit> units;
//  private HashMap<Position, City> cities;

  private Player currentPlayer = Player.RED;


  private int age;

  public GameImpl()
  {
    this.age = 4000;
  }

  public GameImpl(WorldLayoutStrategy worldLayoutStrategy) {
    this.age = 4000;
    WorldLayoutDTO mapData = worldLayoutStrategy.createWorld();
    this.tiles = mapData.getTiles();
    this.units = mapData.getUnits();
    this.cities = mapData.getCities();
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
        int  productionCost = 0;

        ((CityImpl) city).incrementTreasury();

        if(city.getProduction() != null)
        {
          switch(city.getProduction()) {
            case(GameConstants.ARCHER):
              productionCost = GameConstants.ARCHER_COST;
              break;
            case(GameConstants.LEGION):
              productionCost = GameConstants.LEGION_COST;
              break;
            case(GameConstants.SETTLER):
              productionCost = GameConstants.SETTLER_COST;
              break;
          }

          if(city.getTreasury() >= productionCost)
          {
            this.placeUnit(i, city);

            ((CityImpl) city).decreaseTreasury(productionCost);
          }
        }
      }
    }
  }

  public void changeWorkForceFocusInCityAt( Position p, String balance ) {}
  public void changeProductionInCityAt( Position p, String unitType ) {
    City city = this.getCityAt(p);
    ((CityImpl) city).setProduction(unitType);
  }

  public void performUnitActionAt( Position p ) {}

  /**
   * Helper method to find the first available tile to place a specified unit for a city
   *
   * @param p a Position containing the center of the city
   * @param c a City to place a unit for
   */
  private void placeUnit(Position p, City c) {
    Iterator<Position> i8 = Utility.get8neighborhoodIterator(p);

    if(!units.containsKey(p))
    {
      units.put(p, new UnitImpl(c.getProduction(), c.getOwner()));
    }
    else
    {
      Position nextPosition = i8.next();

      while(units.containsKey(nextPosition))
      {
        if(i8.hasNext())
        {
          nextPosition = i8.next();
        }
        else
        {
          return;
        }
      }

      units.put(nextPosition, new UnitImpl(c.getProduction(), c.getOwner()));
    }
  }
}
