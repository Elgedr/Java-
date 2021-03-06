package ee.taltech.iti0202.mysticorbs.orb;

import java.util.ArrayList;
import java.util.List;



public class Orb {
    public String owenName; // ahju nime, milles kuul toodeti.
    public int energy = 0;
    public static List<String> creators = new ArrayList<>();

    /**
     *
     * @param creator .
     */
    public Orb(String creator) {
        this.owenName = creator;
        creators.add(creator);
    }

    /**
     *
     * @param resource .
     * @param amount .
     */
    public void charge(String resource, int amount) {
        if (!resource.equalsIgnoreCase("dust") && !resource.isBlank() && amount > 0) {
            energy = energy + resource.length() * amount;
        }
    }

    /**
     *
     * @return .
     */
    public int getEnergy() {
        return energy;
    }

    /**
     *
     * @return .
     */
    public String toString() {
        return "Orb by " + this.owenName;
    }

}
