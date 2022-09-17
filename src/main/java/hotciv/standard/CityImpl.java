package hotciv.standard;

import hotciv.framework.City;
import hotciv.framework.Player;

public class CityImpl implements City {

    // Private variables
    private String WorkForceFocus;
    private String Production;
    private int Size = 1;
    private int Treasury;

    // Member functions
    @Override
    public Player getOwner() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public int getTreasury() {
        return 0;
    }

    @Override
    public String getProduction() {
        return null;
    }

    @Override
    public String getWorkforceFocus() {
        return null;
    }

    // Mutator functions
    public void setWorkForce(String NewFocus) {
    }
}
