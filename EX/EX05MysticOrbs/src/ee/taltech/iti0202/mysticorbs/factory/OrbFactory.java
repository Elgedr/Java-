package ee.taltech.iti0202.mysticorbs.factory;

import ee.taltech.iti0202.mysticorbs.exceptions.CannotFixException;
import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.oven.Oven;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


/**
 * Class.
 */
public class OrbFactory {
    public ResourceStorage resourceStorage;
    public LinkedList<Oven> ovens = new LinkedList<>();
    public LinkedList<Orb> orbs = new LinkedList<>();

    /**
     * @param resourceStorage .
     */
    public OrbFactory(ResourceStorage resourceStorage) {
        this.resourceStorage = resourceStorage;
    }

    /**
     * @param oven .
     */
    public void addOven(Oven oven) {
        if (!ovens.contains(oven) && oven.resourceStorage == this.resourceStorage) {
            this.ovens.add(oven);
        }
    }

    /**
     * @return .
     */
    public List<Oven> getOvens() {
        return this.ovens;
    }

    /**
     * @return .
     */
    public List<Orb> getAndClearProducedOrbsList() {
        List<Orb> copy = new LinkedList<>(orbs);
        orbs.clear();
        return copy;
    }

    /**
     * @return .
     */
    public int produceOrbs() {
        if (ovens.size() > 0) {
            for (Oven oven : ovens) {
                oven.craftOrb();
                if (oven.craftOrb().isPresent()) {
                    orbs.add(oven.craftOrb().get());
                }
            }
        }
        return orbs.size();
    }

    /**
     * @param cycles .
     * @return .
     */
    public int produceOrbs(int cycles) {
        for (int i = 0; i < cycles; i++) {
            if (ovens.size() > 0) {
                for (Oven oven : ovens) {
                    if (!oven.isBroken()) {
                        Optional<Orb> orb = oven.craftOrb();
                        orb.ifPresent(value -> orbs.add(value));
                    } else {
                        try {oven.fix();
                            Optional<Orb> orb = oven.craftOrb();
                            orb.ifPresent(value -> orbs.add(value));
                        } catch (CannotFixException ignored) {
                        }
                    }
                }
            }
        }
        return orbs.size();
    }

    public void getOvensThatCannotBeFixed(){
    }

    public void getRidOfOvensThatCannotBeFixed(){

    }

    public void optimizeOvensOrder(){

    }

}
