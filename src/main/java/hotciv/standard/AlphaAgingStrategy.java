package hotciv.standard;

import hotciv.framework.AgingStrategy;

public class AlphaAgingStrategy implements AgingStrategy {
    public int ageWorld(int currentAge)
    {
        return currentAge - 100;
    }
}
