package hotciv.standard;

import hotciv.framework.*;
import hotciv.standard.factories.AlphaCivFactory;
import hotciv.standard.implementations.GameImpl;
import hotciv.standard.implementations.UnitImpl;
import hotciv.standard.moveUnitStrategies.AlphaCivMoveUnitStrategy;
import org.junit.*;
import static org.junit.Assert.*;

public class TestAlphaMoveUnitStrategy {
  private MoveUnitStrategy moveUnitStrategy;
  private GameImpl game;

  @Before
  public void setUp()
  {
    moveUnitStrategy = new AlphaCivMoveUnitStrategy();
    game = new GameImpl(new AlphaCivFactory());
  }

  @Test
  public void moveFalseIfDestinationMountains()
  {
    Unit unit1 = new UnitImpl(GameConstants.ARCHER, Player.RED);
    game.addToWorld(new Position(2,1), unit1);
    game.endOfTurn(); game.endOfTurn();
    assertFalse(moveUnitStrategy.moveUnit(new Position(2,1), new Position(2,2), game));
  }

  @Test
  public void moveFalseIfDestinationOcean()
  {
    Unit unit1 = new UnitImpl(GameConstants.ARCHER, Player.RED);
    game.addToWorld(new Position(1,1), unit1);
    game.endOfTurn(); game.endOfTurn();
    assertFalse(moveUnitStrategy.moveUnit(new Position(1,1), new Position(1,0), game));
  }

  @Test
  public void moveFalseIfNoUnitAtOrigin()
  {
    assertFalse(moveUnitStrategy.moveUnit(new Position(1,1), new Position(1,2), game));
  }

  @Test
  public void moveFalseIfFriendlyUnitAtDestination()
  {
    Unit unit1 = new UnitImpl(GameConstants.ARCHER, Player.RED);
    Unit unit2 = new UnitImpl(GameConstants.ARCHER, Player.RED);
    game.addToWorld(new Position(1,1), unit1);
    game.addToWorld(new Position(1,2), unit2);
    game.endOfTurn(); game.endOfTurn();
    assertFalse(game.moveUnit(new Position(1,1), new Position(1,2)));
  }

  @Test
  public void moveTrueIfEnemyUnitAtDestination()
  {
    Unit unit1 = new UnitImpl(GameConstants.ARCHER, Player.RED);
    Unit unit2 = new UnitImpl(GameConstants.ARCHER, Player.GREEN);
    game.addToWorld(new Position(1,1), unit1);
    game.addToWorld(new Position(1,2), unit2);
    game.endOfTurn(); game.endOfTurn();
    assertTrue(moveUnitStrategy.moveUnit(new Position(1,1), new Position(1,2), game));
    assertEquals(game.getUnitAt(new Position(1,2)).getOwner(), Player.RED);
  }

  @Test
  public void moveFalseIfMoveCountZero()
  {
    Unit unit1 = new UnitImpl(GameConstants.ARCHER, Player.RED);
    game.addToWorld(new Position(1,1), unit1);
    assertEquals(0, game.getUnitAt(new Position(1,1)).getMoveCount());
    assertFalse(moveUnitStrategy.moveUnit(new Position(1,1), new Position(1,2), game));
  }

  @Test
  public void moveFalseIfOwnerNotCurrentPlayer()
  {
    Unit unit1 = new UnitImpl(GameConstants.ARCHER, Player.RED);
    game.addToWorld(new Position(1,1), unit1);
    game.endOfTurn(); game.endOfTurn();
    game.endOfTurn();
    assertFalse(moveUnitStrategy.moveUnit(new Position(1,1), new Position(1,2), game));
  }

  @Test
  public void moveFalseIfMoreThanDistanceOne()
  {
    Unit unit1 = new UnitImpl(GameConstants.ARCHER, Player.RED);
    game.addToWorld(new Position(1,1), unit1);
    game.endOfTurn(); game.endOfTurn();
    assertFalse(moveUnitStrategy.moveUnit(new Position(1,1), new Position(1,3), game));
    assertFalse(moveUnitStrategy.moveUnit(new Position(1,1), new Position(3,2), game));
  }

  @Test
  public void moveTrueIfNoUnitAtDestination()
  {
    Unit unit1 = new UnitImpl(GameConstants.ARCHER, Player.RED);
    game.addToWorld(new Position(1,1), unit1);
    game.endOfTurn(); game.endOfTurn();
    assertTrue(moveUnitStrategy.moveUnit(new Position(1,1), new Position(1,2), game));
    assertNull(game.getUnitAt(new Position(1,1)));
    assertNotNull(game.getUnitAt(new Position(1,2)));
    game.endOfTurn();game.endOfTurn();
    assertTrue(moveUnitStrategy.moveUnit(new Position(1,2), new Position(1,1), game));
  }

  @Test
  public void moveFalseIfDestinationOutOfBounds()
  {
    Unit unit1 = new UnitImpl(GameConstants.ARCHER, Player.RED);
    game.addToWorld(new Position(0,0), unit1);
    game.addToWorld(new Position(15,15), unit1);
    game.endOfTurn(); game.endOfTurn();
    assertFalse(moveUnitStrategy.moveUnit(new Position(0,0), new Position(-1,0), game));
    assertFalse(moveUnitStrategy.moveUnit(new Position(0,0), new Position(0,-1), game));
    assertFalse(moveUnitStrategy.moveUnit(new Position(15,15), new Position(15,16), game));
    assertFalse(moveUnitStrategy.moveUnit(new Position(15,15), new Position(16,15), game));
  }

}
