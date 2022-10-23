/*
 * Copyright (C) 2018 Henrik BÃ¦rbak Christensen, baerbak.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package hotciv.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * At 09 May 2018
 *
 * @author Henrik Baerbak Christensen, CS @ AU
 */
public class Utility {
  public static Iterator<Position> get8neighborhoodIterator(Position center) {
    List<Position> list = new ArrayList<>();
    // Define the 'delta' to add to the row for the 8 positions
    int[] rowDelta = new int[] {-1, -1, 0, +1, +1, +1, 0, -1};
    // Define the 'delta' to add to the colum for the 8 positions
    int[] columnDelta = new int[] {0, +1, +1, +1, 0, -1, -1, -1};

    for (int index = 0; index < rowDelta.length; index++) {
      int row = center.getRow() + rowDelta[index];
      int col = center.getColumn() + columnDelta[index];
      if (row >= 0 && col >= 0
              && row < GameConstants.WORLDSIZE
              && col < GameConstants.WORLDSIZE)
        list.add(new Position(row, col));
    }
    return list.iterator();
  }

  public static Iterable<Position> get8neighborhoodOf(Position center) {
    final Iterator<Position> iterator = get8neighborhoodIterator(center);
    Iterable<Position> iterable = new Iterable<Position>() {
      @Override
      public Iterator<Position> iterator() {
        return iterator;
      }
    };
    return iterable;
  }

    public static interface UnitActionStrategy {
        void chooseAction(Position p, HashMap<Position, Unit> units, HashMap<Position, City> cities);
    }
}