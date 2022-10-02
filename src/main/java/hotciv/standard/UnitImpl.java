package hotciv.standard;

import hotciv.framework.Game;
import hotciv.framework.GameConstants;
import hotciv.framework.Player;
import hotciv.framework.Unit;

public class UnitImpl implements Unit {
    private String type;
    private Player owner;
    private int defensiveStrength;
    private boolean fortified;

    public UnitImpl(String type, Player owner) {
        this.type = type;
        this.owner = owner;
        this.fortified = false;
        this.defensiveStrength = 1;
    }

    @Override
    public String getTypeString() { return type; }

    @Override
    public Player getOwner() { return owner; }

    public int getMoveCount() { return 0; }

    public int getDefensiveStrength() { return defensiveStrength; }

    public int getAttackingStrength() { return 0;}

    public boolean getFortified() { return fortified; }

    public void doubleDefensiveStrength() {
        defensiveStrength+=defensiveStrength;
    }

    public boolean toggleFortified() {
        if (this.type == GameConstants.ARCHER) {
            fortified = !fortified;
            return true;
        }
        return false;
    }
}
