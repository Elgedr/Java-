package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;

import static ee.taltech.iti0202.mysticorbs.orb.Orb.creators;

public class Oven {
    public String name;
    public ResourceStorage resourceStorage;
    public Boolean isMagic = false;
    public Boolean isSpace = false;
    private int orbsMadeInOven = 0;
    public static LinkedList<Orb> allOrbs = new LinkedList<>();

    public Oven(String name, ResourceStorage resourceStorage) {
        this.name = name;
        this.resourceStorage = resourceStorage;
    }

    public String getName() {
        return name;
    }

    public ResourceStorage getResourceStorage() {
        return resourceStorage;
    }

    public int getCreatedOrbsAmount() {
        return Collections.frequency(creators, this.name);
    }

    public boolean isBroken() {
        return orbsMadeInOven >= 15;
    }

    public Optional<Orb> craftOrb() {
        if (!isBroken() && resourceStorage.hasEnoughResource("pearl", 1)
                && resourceStorage.hasEnoughResource("silver", 1)) {
            Orb newObject = new Orb(this.name);
            newObject.charge("pearl", 1);
            newObject.charge("silver", 1);
            resourceStorage.takeResource("pearl", 1);
            resourceStorage.takeResource("silver", 1);
            allOrbs.add(newObject);
            orbsMadeInOven++;
            return Optional.of(newObject);
        }
        return Optional.empty();
    }

    public static void main(String[] args) {

    }
}
