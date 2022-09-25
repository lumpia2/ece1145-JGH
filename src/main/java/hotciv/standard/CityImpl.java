package hotciv.standard;

import hotciv.framework.City;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;

public class CityImpl implements City {

    // Private variables
    private String workForceFocus;
    private String production;
    private int treasury;
    private Player owner;

    public CityImpl(Player owner) {
        this.owner = owner;
    }
    // Member functions
    @Override
    public Player getOwner() {
        return this.owner;
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public int getTreasury() {
        return treasury;
    }

    @Override
    public String getProduction() {
        return production;
    }

    @Override
    public String getWorkforceFocus() {
        return null;
    }

    // Mutator functions
    public void incrementTreasury() { treasury+=6; }

    public void setProduction(String production) {
        this.production = production;
    }
}
