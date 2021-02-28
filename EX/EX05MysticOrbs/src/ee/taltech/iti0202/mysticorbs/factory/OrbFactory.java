package ee.taltech.iti0202.mysticorbs.factory;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.oven.Oven;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static ee.taltech.iti0202.mysticorbs.oven.Oven.allOrbs;

public class OrbFactory {
    public ResourceStorage resourceStorage;
    public LinkedList<Oven> ovens = new LinkedList<>();
    public LinkedList<Orb> orbs = new LinkedList<>();

    public OrbFactory(ResourceStorage resourceStorage) {
        this.resourceStorage = resourceStorage;
    }

    public void addOven(Oven oven) {
        if (!ovens.contains(oven) && oven.resourceStorage == this.resourceStorage) {
            this.ovens.add(oven);
        }
    }

    public List<Oven> getOvens() {
        return this.ovens;
    }

    public List<Orb> getAndClearProducedOrbsList() {
        List<Orb> copy = new LinkedList<>(orbs);
        orbs.clear();
        return copy;
    }

    public int produceOrbs() {
        for (Oven oven : ovens) {
            oven.craftOrb();
            if (oven.craftOrb().isPresent()) {
                orbs.add(oven.craftOrb().get());
            }
        }
        return orbs.size();
    }

    public int produceOrbs(int cycles) {
        int res = 0;
        for (int i = 0; i < cycles; i++) {
            res = +produceOrbs();
        }
        return res;
    }

}
