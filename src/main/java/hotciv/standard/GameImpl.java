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

  private Player currentPlayer = Player.RED;
  private AgingStrategy agingStrategy;
  private WinningStrategy winningStrategy;
  private UnitActionStrategy unitActionStrategy;
  private MoveUnitStrategy moveUnitStrategy;

  private int age;

  public GameImpl(CivFactory TestCivFactory)
  {
    this.age = -4000;
    this.agingStrategy = TestCivFactory.createAgingStrategy();
    this.winningStrategy = TestCivFactory.createWinningStrategy();
    this.unitActionStrategy = TestCivFactory.createUnitActionStrategy();
    this.moveUnitStrategy = TestCivFactory.createMoveUnitStrategy();
    createWorld(TestCivFactory.createWorldLayoutStrategy());
  }

  public Tile getTileAt( Position p ) { return tiles.get(p); }
  public Unit getUnitAt( Position p ) { return units.get(p); }
  public City getCityAt( Position p ) { return cities.get(p); }
  public Player getPlayerInTurn() { return currentPlayer; }

  public Player getWinner() {
    return winningStrategy.getWinner(this.getAge(), this.cities);
  }

  public int getAge() {
    return age;
  }

  public boolean moveUnit( Position from, Position to ) { return moveUnitStrategy.moveUnit(from, to, units); }
  public void endOfTurn() {
    if (currentPlayer == Player.RED) {
      currentPlayer = Player.BLUE;
    }
    else if (currentPlayer == Player.BLUE) {
      currentPlayer = Player.RED;
      this.age = agingStrategy.ageWorld(this.age);

      this.updateCities();
    }
  }

  private void updateCities()
  {
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

  public void changeWorkForceFocusInCityAt( Position p, String balance ) {}
  public void changeProductionInCityAt( Position p, String unitType ) {
    City city = this.getCityAt(p);
    ((CityImpl) city).setProduction(unitType);
  }

  public void performUnitActionAt( Position p ) {
    unitActionStrategy.chooseAction(p, units, cities);
  }

  public void addToWorld( Position p, Unit u ) {
    if (!units.containsKey(p)) {
      units.put(p, u);
    } else {
      System.out.println(units.get(p).getOwner() + " " + units.get(p).getTypeString() + " unit at this position already...");
    }
  }

  public void addToWorld( Position p, City c) {
    if (!cities.containsKey(p)) {
      cities.put(p, c);
    } else {
      System.out.println(cities.get(p).getOwner() + " city at this position already...");
    }
  }

  public void removeFromWorld( Position p, Unit u ) {
    Unit t = units.get(p);
    if (units.containsKey(p) && (t.getTypeString() == u.getTypeString()) && (t.getOwner() == u.getOwner())) {
      units.remove(p);
    } else {
      System.out.println(units.get(p).getTypeString() + " does not exist at this position...");
    }
  }

  public void removeFromWorld( Position p, City c) {
    City t = cities.get(p);
    if (cities.containsKey(p) && (t.getOwner() == c.getOwner())) {
      cities.remove(p);
    } else {
      System.out.println(t.getOwner() + " city does not exist at this position...");
    }
  }

  /**
   * Helper method to create world
   * 
   * @param worldLayoutStrategy
   */
  private void createWorld(WorldLayoutStrategy worldLayoutStrategy) {
    worldLayoutStrategy.createWorld();
    this.tiles = worldLayoutStrategy.getTiles();
    this.units = worldLayoutStrategy.getUnits();
    this.cities = worldLayoutStrategy.getCities();
  }

  /**
   * Helper method to find the first available tile to place a specified unit for a city
   *
   * @param p a Position containing the center of the city
   * @param c a City to place a unit for
   */
  private void placeUnit(Position p, City c) {
    Iterator<Position> positionIterator = Utility.get8neighborhoodIterator(p);
    boolean unitExistsAtPosition = units.containsKey(p);

    if(!unitExistsAtPosition)
    {
      units.put(p, new UnitImpl(c.getProduction(), c.getOwner()));
    }
    else
    {
      Position nextPosition = positionIterator.next();
      unitExistsAtPosition = units.containsKey(nextPosition);

      while(unitExistsAtPosition)
      {
        if(positionIterator.hasNext())
        {
          nextPosition = positionIterator.next();
        }
        else
        {
          return;
        }

        unitExistsAtPosition = units.containsKey(nextPosition);
      }

      units.put(nextPosition, new UnitImpl(c.getProduction(), c.getOwner()));
    }
  }
}
