package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;

import static ee.taltech.iti0202.mysticorbs.orb.Orb.creators;

public class Oven {
    private int orbsMadeByOven;
    public static int counter = 1;
    public String name;
    public ResourceStorage resourceStorage;
    public Boolean isMagic = false;
    public Boolean isSpace = false;
    public static LinkedList<Orb> allOrbs = new LinkedList<>();

    public Oven(String name, ResourceStorage resourceStorage) {
        this.name = name;
        this.resourceStorage = resourceStorage;
        this.orbsMadeByOven = counter;
        counter++;
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
        if (this.orbsMadeByOven >= 15) {
            return true;
        }
        return false;
    }

    public Optional<Orb> craftOrb() {
        if (!isBroken() && resourceStorage.hasEnoughResource("pearl", 1)
                && resourceStorage.hasEnoughResource("silver", 1)) {
            Orb newObject = new Orb(this.name);
            newObject.charge("pearl", 1);
            newObject.charge("silver", 1);
            resourceStorage.takeResource("pearl", 1);
            resourceStorage.takeResource("silver", 1);
            this.allOrbs.add(newObject);
            return Optional.of(newObject);
        }
        return Optional.empty();
    }
}
