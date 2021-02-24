package ee.taltech.iti0202.mysticorbs.orb;

import java.util.ArrayList;
import java.util.List;

public class Orb {
    public String owenName; // ahju nime, milles kuul toodeti.
    public int energy;
    public static List<String> creators = new ArrayList<>();

    public Orb(String creator) {
        this.owenName = creator;
        creators.add(creator);
    }

    public void charge(String resource, int amount) {
        if (!resource.equals("dust") && !resource.contains(" ")) {
            energy += resource.length() * amount;
        }
    }

    public int getEnergy() {
        return energy;
    }

    public String toString() {
        return "Orb by " + this.owenName;
    }
}
