package ee.taltech.iti0202.mysticorbs.orb;

import java.util.ArrayList;
import java.util.List;
import ee.taltech.iti0202.mysticorbs.oven.Oven;


public class Orb {
    public String owenName; // ahju nime, milles kuul toodeti.
    public int energy = 0;
    public static List<String> creators = new ArrayList<>();

    public Orb(String creator) {
        this.owenName = creator;
        creators.add(creator);
    }

    public void charge(String resource, int amount) {
        if (!resource.equalsIgnoreCase("dust") && !resource.isBlank()) {
            energy = energy + resource.length() * amount;
        }
    }

    public int getEnergy() {
        return energy;
    }

    public String toString() {
        return "Orb by " + this.owenName;
    }

    public static void main(String[] args) {
        Orb orb = new MagicOrb("CreatorHere");
        System.out.println(orb.getEnergy());
        orb.charge("   ", 2);
        System.out.println(orb.getEnergy());
    }
}
