package ee.taltech.iti0202.mysticorbs.orb;

public class SpaceOrb extends Orb { // Kuul, mida ei saa laadida, aga tal on oskus neelata nõrgemaid kuule.

    /**
     *
     * @param creator .
     */
    public SpaceOrb(String creator) {
        super(creator);
        super.energy = 100;
    }

    @Override
    public void charge(String resource, int amount) {
    }

    /**
     *
     * @return .
     */
    public String toString() {
        return "SpaceOrb by " + super.owenName;
    }

    /**
     *
     * @param orb .
     * @return .
     */
    public boolean absorb(Orb orb) {
        if (orb.getEnergy() < super.getEnergy()) {
            super.energy += orb.energy;
            orb.energy = 0;
            return true;
        }
        return false;
    }
}
