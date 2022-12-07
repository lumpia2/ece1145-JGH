package hotciv.standard;

import hotciv.framework.AgingStrategy;

import hotciv.standard.agingStrategies.AlphaAgingStrategy;
import org.junit.*;
import static org.junit.Assert.*;

public class TestAlphaAgingStrategy {
  private AgingStrategy agingStrategy;

  @Before
  public void setUp()
  {
    agingStrategy = new AlphaAgingStrategy();
  }

  @Test
  public void endOfRoundDecreases100Years()
  {
    assertEquals(-3900, agingStrategy.ageWorld(-4000));
  }
}
