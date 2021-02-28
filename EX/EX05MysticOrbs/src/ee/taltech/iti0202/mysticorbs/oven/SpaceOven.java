package ee.taltech.iti0202.mysticorbs.oven;

import ee.taltech.iti0202.mysticorbs.orb.Orb;
import ee.taltech.iti0202.mysticorbs.orb.SpaceOrb;
import ee.taltech.iti0202.mysticorbs.storage.ResourceStorage;

import java.util.Optional;

public class SpaceOven extends Oven {
    private int orbsMadeBySpaceOven = 0;

    public SpaceOven(String name, ResourceStorage resourceStorage) {
        super(name, resourceStorage);
    }

    @Override
    public boolean isBroken() {
        return this.orbsMadeBySpaceOven >= 25;
    }

    @Override
    public Optional<Orb> craftOrb() {
        if (!isBroken() && resourceStorage.hasEnoughResource("meteorite stone", 1) && resourceStorage.hasEnoughResource("star fragment", 15)) {
            if (resourceStorage.hasEnoughResource("meteorite stone", 1)
                    && resourceStorage.hasEnoughResource("star fragment", 15)) {
                Orb newObject = new SpaceOrb(this.name);
                resourceStorage.takeResource("meteorite stone", 1);
                resourceStorage.takeResource("star fragment", 15);
                allOrbs.add(newObject);
                orbsMadeBySpaceOven++;
                return Optional.of(newObject);
            }
        } else if (resourceStorage.hasEnoughResource("pearl", 1)
                && resourceStorage.hasEnoughResource("silver", 1)) {
            Orb newObject = new Orb(this.name);
            resourceStorage.takeResource("pearl", 1);
            resourceStorage.takeResource("silver", 1);
            allOrbs.add(newObject);
            orbsMadeBySpaceOven++;
            return Optional.of(newObject);
        }
        return Optional.empty();
    }
}
