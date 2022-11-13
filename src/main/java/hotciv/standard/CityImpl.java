package hotciv.standard;

import hotciv.framework.City;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;

public class CityImpl implements City {

    // Private variables
    private String workForceFocus;
    private String production;
    private int treasury;
    private int population;
    private Player owner;

    public CityImpl(Player owner) {
        this.owner = owner;
        this.population = 1;
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
        return workForceFocus;
    }

    public int getPopulation() {
        return population;
    }

    // Mutator functions
    public void incrementTreasury() { treasury+=6; }

    public void setProduction(String production) {
        this.production = production;
    }

    public void decreaseTreasury(int cost) {
        treasury -= cost;
    }

    public void decrementPopulation() { population -= 1; }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
