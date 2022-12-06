package hotciv.standard;

import hotciv.framework.*;

import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class TestSemiCiv {
  private Game game;

  @Before
  public void setUp() {
    game = new GameImpl(new SemiCivFactory());
  }

  // BETA Aging Tests
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

  // GAMMA Unit Actions
  @Test
  public void settlerActionWorks() {
    game.performUnitActionAt(new Position(4,3));

    assertThat(game.getPlayerInTurn(), is(Player.RED));
    assertThat(game.getCityAt(new Position(4,3)), is(notNullValue()));

    City redCity = game.getCityAt(new Position(4,3));
    assertThat(redCity.getOwner(), is(Player.RED));
  }

  @Test
  public void archerActionWorks() {
    game.performUnitActionAt(new Position(2,0));

    assertThat(game.getPlayerInTurn(), is(Player.RED));
    assertThat(game.moveUnit(new Position(2, 0), new Position(4, 0)), is(false));
    Unit redArcher = game.getUnitAt(new Position(2, 0));
    assertThat(redArcher.getDefensiveStrength(), is(2));
    game.endOfTurn();game.endOfTurn();
    game.performUnitActionAt(new Position(2,0));
    assertThat(game.moveUnit(new Position(2, 0), new Position(3, 1)), is(true));
  }

  // DELTA world layout
  @Test
  public void verifyCitiesLocation() {
    assertThat(game.getCityAt(new Position(4,5)), is(notNullValue()));
    assertThat(game.getCityAt(new Position(8,12)), is(notNullValue()));
  }

  @Test
  public void verifyCityOwnership() {
    assertEquals(game.getCityAt(new Position(4,5)).getOwner(), Player.BLUE);
    assertEquals(game.getCityAt(new Position(8,12)).getOwner(), Player.RED);
  }

  @Test
  public void verifyUnitsLocation() {
    assertEquals(GameConstants.ARCHER, game.getUnitAt(new Position(2,0)).getTypeString());
    assertEquals(GameConstants.LEGION, game.getUnitAt(new Position(3,2)).getTypeString());
    assertEquals(GameConstants.SETTLER, game.getUnitAt(new Position(4,3)).getTypeString());
  }

  @Test
  public void verifyMountainLocations() {
    assertEquals(GameConstants.MOUNTAINS, game.getTileAt(new Position(0,5)).getTypeString());
    assertEquals(GameConstants.MOUNTAINS, game.getTileAt(new Position(2,6)).getTypeString());
    assertEquals(GameConstants.MOUNTAINS, game.getTileAt(new Position(3,3)).getTypeString());
  }

  @Test
  public void verifyHillLocations() {
    assertEquals(GameConstants.HILLS, game.getTileAt(new Position(1,3)).getTypeString());
    assertEquals(GameConstants.HILLS, game.getTileAt(new Position(1,4)).getTypeString());
    assertEquals(GameConstants.HILLS, game.getTileAt(new Position(5,12)).getTypeString());
  }

  @Test
  public void verifyOceanLocations() {
    assertEquals(GameConstants.OCEANS, game.getTileAt(new Position(0,0)).getTypeString());
    assertEquals(GameConstants.OCEANS, game.getTileAt(new Position(15,15)).getTypeString());
    assertEquals(GameConstants.OCEANS, game.getTileAt(new Position(10,10)).getTypeString());
  }

  // EPSILON winning strategy
  @Test
  public void threeWinsWins() {
    Utility2.incrementWinner((GameImpl)game, Player.RED);
    Utility2.incrementWinner((GameImpl)game, Player.RED);
    Utility2.incrementWinner((GameImpl)game, Player.RED);

    assertThat(game.getWinner(), is(Player.RED));
  }

  @Test
  public void firstToThreeWinsWins() {
    Utility2.incrementWinner((GameImpl)game, Player.RED);
    Utility2.incrementWinner((GameImpl)game, Player.RED);
    Utility2.incrementWinner((GameImpl)game, Player.RED);
    Utility2.incrementWinner((GameImpl)game, Player.BLUE);
    Utility2.incrementWinner((GameImpl)game, Player.BLUE);
    Utility2.incrementWinner((GameImpl)game, Player.BLUE);

    assertThat(game.getWinner(), is(Player.RED));
  }

}
