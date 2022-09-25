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

package hotciv.standard;

import hotciv.framework.GameConstants;
import hotciv.framework.Position;
import hotciv.framework.Utility;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TestIterators {

  @Test
  public void shouldHave78AsFirstElement() {
    Iterator<Position> i8 = Utility.get8neighborhoodIterator(new Position(8,8));
    Position p = i8.next();
    assertThat(p, is(new Position(7,8)));
  }

  @Test
  public void shouldHave79AsSecondElement() {
    Iterator<Position> i8 = Utility.get8neighborhoodIterator(new Position(8,8));
    Position p = i8.next();
    p = i8.next();
    assertThat(p, is(new Position(7,9)));
  }

  @Test
  public void shouldHaveTheRestOK() {
    Iterator<Position> i8 = Utility.get8neighborhoodIterator(new Position(8,8));
    Position p = i8.next();
    p = i8.next();

    p = i8.next();
    assertThat(p, is(new Position(8,9)));

    p = i8.next();
    assertThat(p, is(new Position(9,9)));

    p = i8.next();
    assertThat(p, is(new Position(9,8)));

    p = i8.next();
    assertThat(p, is(new Position(9,7)));

    p = i8.next();
    assertThat(p, is(new Position(8,7)));

    p = i8.next();
    assertThat(p, is(new Position(7,7)));

    assertThat(i8.hasNext(), is(false));
  }

  @Test
  public void shouldOnlyHave3ElementsAround00Position() {
    Iterator<Position> i8 = Utility.get8neighborhoodIterator(new Position(0,0));
    Position p = i8.next();
    assertThat(p, is(new Position(0,1)));

    p = i8.next();
    assertThat(p, is(new Position(1,1)));

    p = i8.next();
    assertThat(p, is(new Position(1,0)));

    assertThat(i8.hasNext(), is(false));
  }

  @Test
  public void shouldOnlyHave3ElementsAround15_15Position() {
    Iterator<Position> i8 = Utility.get8neighborhoodIterator(
            new Position(GameConstants.WORLDSIZE - 1, GameConstants.WORLDSIZE - 1));

    Position p = i8.next();
    assertThat(p, is(new Position(14, 15)));

    p = i8.next();
    assertThat(p, is(new Position(15, 14)));

    p = i8.next();
    assertThat(p, is(new Position(14, 14)));

    assertThat(i8.hasNext(), is(false));
  }

  @Test
  public void shouldSupportIterable() {
    List<Position> list = new ArrayList<>();
    for (Position p : Utility.get8neighborhoodOf(new Position(3,4))) {
      list.add(p);
    }
    assertThat(list, hasItems( new Position(2,4),
            new Position(3,3)));
    assertThat(list, not(hasItem(new Position(3,4))));
    assertThat(list.size(), is(8));
  }

}