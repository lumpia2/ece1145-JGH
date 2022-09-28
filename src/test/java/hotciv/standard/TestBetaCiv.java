package hotciv.standard;

import hotciv.framework.*;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TestBetaCiv {
  private Game game;

  /** Fixture for alphaciv testing. */
  @Before
  public void setUp() {
    game = new GameImpl( new BetaAgingStrategy(), new AlphaWinningStrategy());
    game.createMap();
  }

  @Test
  public void endOfRoundDecreases100Years() {
    this.endOfRound();
    assertEquals(game.getAge(), -3900);
  }

  @Test
  public void agingAroundBirthOfChrist()
  {
    this.passTenRounds(); //3000BC
    this.passTenRounds(); //2000BC
    this.passTenRounds(); //1000BC
    this.endOfRound(); this.endOfRound(); this.endOfRound(); // 700BC
    this.endOfRound(); this.endOfRound(); this.endOfRound(); // 400BC
    this.endOfRound(); this.endOfRound(); this.endOfRound(); // 100BC

    this.endOfRound();
    assertEquals(-1, game.getAge());

    this.endOfRound();
    assertEquals(1, game.getAge());

    this.endOfRound();
    assertEquals(50, game.getAge());
  }

  @Test
  public void agingPasses50YearsPerRound()
  {
    this.passTenRounds(); //3000BC
    this.passTenRounds(); //2000BC
    this.passTenRounds(); //1000BC
    this.passTenRounds(); //1BC
    this.passTenRounds(); //450
    this.endOfRound();
    assertEquals(500, game.getAge());
  }

  @Test
  public void agingPasses25YearsPerRound()
  {
    this.passTenRounds(); //3000BC
    this.passTenRounds(); //2000BC
    this.passTenRounds(); //1000BC
    this.passTenRounds(); //1BC
    this.passTenRounds(); //450
    this.passTenRounds(); //950
    this.passTenRounds(); //1450
    this.endOfRound(); this.endOfRound(); //1550
    this.endOfRound(); this.endOfRound(); //1650
    this.endOfRound(); this.endOfRound(); //1750

    this.endOfRound();
    assertEquals(1775, game.getAge());
  }

  @Test
  public void agingPasses5YearsPerRound()
  {
    this.passTenRounds(); //3000BC
    this.passTenRounds(); //2000BC
    this.passTenRounds(); //1000BC
    this.passTenRounds(); //1BC
    this.passTenRounds(); //450
    this.passTenRounds(); //950
    this.passTenRounds(); //1450
    this.endOfRound(); this.endOfRound(); //1550
    this.endOfRound(); this.endOfRound(); //1650
    this.endOfRound(); this.endOfRound(); //1750

    this.endOfRound(); this.endOfRound(); //1800
    this.endOfRound(); this.endOfRound(); //1850
    this.endOfRound(); this.endOfRound(); //1900

    this.endOfRound();
    assertEquals(1905, game.getAge());
  }

  @Test
  public void agingPasses1YearPerRound()
  {
    this.passTenRounds(); //3000BC
    this.passTenRounds(); //2000BC
    this.passTenRounds(); //1000BC
    this.passTenRounds(); //1BC
    this.passTenRounds(); //450
    this.passTenRounds(); //950
    this.passTenRounds(); //1450
    this.passTenRounds(); //1850
    this.passTenRounds(); //1940
    this.endOfRound(); this.endOfRound(); //1950
    this.endOfRound(); this.endOfRound(); //1960
    this.endOfRound(); this.endOfRound(); //1970

    this.endOfRound();
    assertEquals(1971, game.getAge());
  }



  private void endOfRound()
  {
    game.endOfTurn(); game.endOfTurn();
  }

  private void passTenRounds()
  {
    endOfRound(); endOfRound();
    endOfRound(); endOfRound();
    endOfRound(); endOfRound();
    endOfRound(); endOfRound();
    endOfRound(); endOfRound();
  }
}
