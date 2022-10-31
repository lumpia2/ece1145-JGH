package hotciv.standard;

import hotciv.framework.*;

import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TestZetaCiv {
  private Game game;

  /** Fixture for betaciv testing. */
  @Before
  public void setUp() {
    game = new GameImpl(new ZetaCivFactory());
  }

  @Test
  public void winnerIsNullIfNotAllCitiesConquered()
  {
    assertNull(game.getWinner());
  }

  @Test
  public void whenRedOwnsAllCitiesRedIsWinner()
  {
    ((CityImpl) game.getCityAt(new Position(4,1))).setOwner(Player.RED);
    assertEquals(Player.RED, game.getWinner());
  }

  @Test
  public void noWinnerAfter20RoundsUntil3Attacks()
  {
    for(int i=0; i<20; i++)
    {
      this.endOfRound();
    }

    assertNull(game.getWinner());
  }

  @Test
  public void winnerAfter20RoundsIsFirstToThreeAttacks()
  {
    for(int i=0; i<21; i++)
    {
      this.endOfRound();
    }
    Utility2.incrementWinner((GameImpl)game, Player.RED);
    Utility2.incrementWinner((GameImpl)game, Player.RED);
    Utility2.incrementWinner((GameImpl)game, Player.RED);

    assertThat(game.getWinner(), is(Player.RED));
  }

  @Test
  public void attackCountStartsAfter20Rounds()
  {
    Utility2.incrementWinner((GameImpl)game, Player.RED);
    Utility2.incrementWinner((GameImpl)game, Player.RED);
    Utility2.incrementWinner((GameImpl)game, Player.RED);

    for(int i=0; i<20; i++)
    {
      this.endOfRound();
    }

    assertNull(game.getWinner());

    Utility2.incrementWinner((GameImpl)game, Player.BLUE);
    Utility2.incrementWinner((GameImpl)game, Player.BLUE);
    Utility2.incrementWinner((GameImpl)game, Player.BLUE);
    this.endOfRound();
    assertEquals(game.getWinner(), Player.BLUE);
    //assertThat(game.getWinner(), is(Player.BLUE));
  }

  private void endOfRound()
  {
    game.endOfTurn(); game.endOfTurn();
  }
}
