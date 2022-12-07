package hotciv.standard;

import hotciv.framework.AgingStrategy;

import hotciv.standard.agingStrategies.BetaAgingStrategy;
import org.junit.*;
import static org.junit.Assert.*;

public class TestBetaAgingStrategy {
  private AgingStrategy agingStrategy;

  @Before
  public void setUp()
  {
    agingStrategy = new BetaAgingStrategy();
  }

  @Test
  public void endOfRoundDecreases100Years()
  {
    assertEquals(-3900, agingStrategy.ageWorld(-4000));
  }

  @Test
  public void agingAroundBirthOfChrist()
  {
    assertEquals(-100, agingStrategy.ageWorld(-200));
    assertEquals(-1, agingStrategy.ageWorld(-100));
    assertEquals(1, agingStrategy.ageWorld(-1));
    assertEquals(50, agingStrategy.ageWorld(1));
  }

  @Test
  public void endOfRoundIncreases50Years()
  {
    assertEquals(100, agingStrategy.ageWorld(50));
  }

  @Test
  public void endOfRoundIncreases25Years()
  {
    assertEquals(1775, agingStrategy.ageWorld(1750));
  }

  @Test
  public void endOfRoundIncreases5Years()
  {
    assertEquals(1905, agingStrategy.ageWorld(1900));
  }

  @Test
  public void endOfRoundIncreases1Year()
  {
    assertEquals(2001, agingStrategy.ageWorld(2000));
  }
}
